package com.kaikeba.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * springmvc提供的唯一的一个Servlet类
 */
public abstract class AbstractServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispath(req, resp);
    }

    public abstract void doDispath(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException ;
}
