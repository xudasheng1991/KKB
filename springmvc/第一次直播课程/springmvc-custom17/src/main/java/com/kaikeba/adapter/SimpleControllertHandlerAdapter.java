package com.kaikeba.adapter;

import com.kaikeba.handler.SimpleControllertHandler;
import com.kaikeba.model.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleControllertHandlerAdapter implements HandlerAdapter{
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof SimpleControllertHandler);
    }

    @Override
    public ModelAndView handleRequest(Object handler, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return ((SimpleControllertHandler)handler).handleRequest(request,response);
    }
}
