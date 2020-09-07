package com.kaikeba.handler;

import com.kaikeba.model.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveUserHandler implements SimpleControllertHandler{
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
        response.getWriter().write("湖人总冠军-SaveUserHandler");
        return null;
    }
}
