package com.demo.servlet;

import com.demo.beans.ToDo;
import com.demo.dao.ToDoDao;
import com.demo.imple.ToDoDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateForm", value = "/UpdateForm")
public class UpdateForm extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
