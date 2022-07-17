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

//@WebServlet(name = "InsertToDo", value = "/InsertToDo")
public class InsertToDo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String username = request.getParameter("username");
        String detail = request.getParameter("detail");
        boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
        ToDo insertNewToDo = new ToDo(title, username, detail, LocalDate.now(), isDone);
        ToDoDao toDoDao = new ToDoDaoImpl();
        try {
            toDoDao.insertToDo(insertNewToDo);
            response.sendRedirect("ToDoList");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
