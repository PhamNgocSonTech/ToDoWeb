package com.demo.servlet;

import com.demo.beans.Account;
import com.demo.dao.AcccoutDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("register-username");
        String pass = request.getParameter("register-password");
        String email = request.getParameter("email");
        AcccoutDao accDao = new AcccoutDao();
        Account acc = accDao.checkRegister(username);
        if(acc == null){
            accDao.register(username, pass, email);
            request.setAttribute("sucMess","Signup Successfully");
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
            dispatcher.forward(request, response);
        }else{
            request.setAttribute("errRegister","Exists Account In Page");
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp");
            dispatcher.forward(request, response);
        }

    }
}
