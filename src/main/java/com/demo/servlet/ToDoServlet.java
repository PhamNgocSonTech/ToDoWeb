package com.demo.servlet;

import com.demo.beans.ToDo;
import com.demo.dao.ToDoDao;
import com.demo.imple.ToDoDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/")
public class ToDoServlet extends HttpServlet {
    ToDoDao toDoDao;

    @Override
    public void init() throws ServletException {
        toDoDao = new ToDoDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choose = request.getServletPath();
        try {
            switch (choose) {
                case "/NewToDo":
                    newForm(request, response);
                    break;
                case "/Insert":
                    insertToDo(request, response);
                    break;
                case "/Delete":
                    deleteToDo(request, response);
                    break;
                case "/Update":
                    updateToDo(request, response);
                    break;
                case "/EditForm":
                    editForm(request, response);
                    break;
                case "/ListToDo":
                    listToDo(request, response);
                    break;
                default:
//                    RequestDispatcher dispatcher = request.getRequestDispatcher("/user-detail.jsp");
//                    dispatcher.forward(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void listToDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ToDoDao toDoDao = new ToDoDaoImpl();
        HttpSession session = request.getSession();
        if(session.getAttribute("accSession") != null){
            List<ToDo> listTodo = toDoDao.selectAllToDo();
            request.setAttribute("listTodo", listTodo);
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/todo-list.jsp");
            dispatcher.forward(request, response);
        }else{
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
            dispatcher.forward(request, response);
        }

    }

    private void newForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/todo-form.jsp");
        dispatcher.forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
//        ToDoDao toDoDao = new ToDoDaoImpl();
        ToDo existsDo = toDoDao.selectToDo(id);
        request.setAttribute("todo", existsDo);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/todo-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertToDo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String title = request.getParameter("title");
        String username = request.getParameter("username");
        String detail = request.getParameter("detail");
        boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
        ToDo insertNewToDo = new ToDo(title, username, detail, LocalDate.now(), isDone);
//        ToDoDao toDoDao = new ToDoDaoImpl();
        toDoDao.insertToDo(insertNewToDo);
        response.sendRedirect("ListToDo");
    }

    private void updateToDo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String username = request.getParameter("username");
        String detail = request.getParameter("detail");
        LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"));
        boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
        ToDo updateToDo = new ToDo(id, title, username, detail, targetDate, isDone);
//        ToDoDao toDoDao = new ToDoDaoImpl();
//      ToDo toDo = new ToDo(id, title, username, detail, targetDate, isDone);
//        toDoDao.updateToDo(updateToDo);
//        response.sendRedirect("ListToDo");
        try {
            boolean check = toDoDao.updateToDo(updateToDo);
            if (check) {
                request.setAttribute("succUpdate", "Successfully Update!!!");
                RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/ListToDo");
                dispatcher.forward(request, response);
//                response.sendRedirect("ListToDo");

            } else {
                request.setAttribute("failUpdate", "Failed Update!!!");
                RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/EditForm");
                dispatcher.forward(request, response);
//                response.sendRedirect("EditForm");
            }
        } catch (SQLException | ServletException e) {
            e.printStackTrace();
        }

    }

    private void deleteToDo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
//        ToDoDao toDoDao = new ToDoDaoImpl();
        toDoDao.deleteToDo(id);
        response.sendRedirect("ListToDo");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
