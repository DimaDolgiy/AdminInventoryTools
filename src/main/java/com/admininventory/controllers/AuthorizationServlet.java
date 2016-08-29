/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admininventory.controllers;

import com.admininventory.AdminAthorizationSQL;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dima
 */
@WebServlet(name = "AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);

        if (session.getAttribute("logIn") == null || !(Boolean) (session.getAttribute("logIn"))) {

            req.getRequestDispatcher("login.jsp").forward(req, resp);

        } else {

            resp.sendRedirect("view");

//            req.getRequestDispatcher("welcome.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);

        String page = req.getParameter("page");

        if (page.equals("login.jsp")) {

            String login = req.getParameter("login");

            String password = req.getParameter("password");

            session.setAttribute("logIn", false);

            AdminAthorizationSQL athorizationSQL = new AdminAthorizationSQL();

            if (athorizationSQL.login(login, password)) {

                session.setAttribute("logIn", true);

                resp.sendRedirect("view");

//                req.getRequestDispatcher("welcome.jsp").forward(req, resp); 
            } else {

                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }

        } else {

            session.setAttribute("logIn", false);

            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

}
