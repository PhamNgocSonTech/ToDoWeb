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

//@WebServlet(name = "UpdateToDo", value = "/UpdateToDo")
public class UpdateToDo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String username = request.getParameter("username");
        String detail = request.getParameter("detail");
        LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"));
        boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
        ToDoDao toDoDao = new ToDoDaoImpl();
        ToDo toDo = new ToDo(id, title, username, detail, targetDate, isDone);
        try {
          boolean check =  toDoDao.updateToDo(toDo);
          HttpSession session = request.getSession();
          if(check){
              session.setAttribute("SuccUpdate", "Successfully Update!!!");
              response.sendRedirect("ListToDo");

          }else{
              session.setAttribute("FailUpdate", "Failed Update!!!");
              response.sendRedirect("EditForm");
          }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ToDoDao toDoDao = new ToDoDaoImpl();
        ToDo existsDo = toDoDao.selectToDo(id);
        request.setAttribute("todo", existsDo);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/todo-form.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
