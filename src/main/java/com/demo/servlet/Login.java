package com.demo.servlet;

import com.demo.beans.Account;
import com.demo.dao.AcccoutDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        AcccoutDao accDao = new AcccoutDao();
        Account acc = accDao.login(username, pass);
        if (acc != null) {
            HttpSession session = request.getSession();
//            request.setAttribute("acc", acc);
            session.setAttribute("accSession", acc);
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
            dispatcher.forward(request, response);
//            response.sendRedirect(request.getContextPath() + "/UserDetail");
        } else {
            String errLogin = "Login Failed, Try Again Please!!!";
            request.setAttribute("err", errLogin);
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
            dispatcher.forward(request, response);
        }


    }
}
