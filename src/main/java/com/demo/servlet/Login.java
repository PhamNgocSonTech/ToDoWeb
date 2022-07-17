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
        //get username, password form cookie
        Cookie cookieArr[] = request.getCookies();
        for(Cookie ck : cookieArr){
            if(ck.getName().equals("usernameC")){
                request.setAttribute("usernameCk", ck.getValue());
            }
            if(ck.getName().equals("passC")){
                request.setAttribute("passCk", ck.getValue());
            }
        }
        //set username, password to login form
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

    /*
    * Xu ly viec login
    * */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        AcccoutDao accDao = new AcccoutDao();
        Account acc = accDao.login(username, pass);
        if (acc != null) {
            HttpSession session = request.getSession();
//            request.setAttribute("acc", acc);
//            Luu acc len session
            session.setAttribute("accSession", acc);
//            Luu acc len vao Cookie
            Cookie u = new Cookie("usernameC", username);
            Cookie p = new Cookie("passC", pass);
//            Set thoi gian ton cua cua Cookie
            u.setMaxAge(180);
            p.setMaxAge(180);
//          luu cookie username va password vao browser
            response.addCookie(u);
            response.addCookie(p);

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
