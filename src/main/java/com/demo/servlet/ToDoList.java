package com.demo.servlet;

import com.demo.beans.ToDo;
import com.demo.dao.ToDoDao;
import com.demo.imple.ToDoDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

//@WebServlet(name = "ToDoList", value = "/ToDoList")
public class ToDoList extends HttpServlet {
    private ToDoDao toDoDao;
    public void init(){
        toDoDao = new ToDoDaoImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ToDo> listTodo = toDoDao.selectAllToDo();
        request.setAttribute("listTodo", listTodo);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/todo-list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
