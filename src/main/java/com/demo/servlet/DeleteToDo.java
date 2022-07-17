package com.demo.servlet;

import com.demo.dao.ToDoDao;
import com.demo.imple.ToDoDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

//@WebServlet(name = "DeleteToDo", value = "/DeleteToDo")
public class DeleteToDo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ToDoDao toDoDao = new ToDoDaoImpl();
        try {
            toDoDao.deleteToDo(id);
            response.sendRedirect("/ToDoList");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
