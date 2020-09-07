package com.kaikeba.servlet;

import com.kaikeba.adapter.HandlerAdapter;
import com.kaikeba.adapter.HttpRequestHandlerAdapter;
import com.kaikeba.adapter.SimpleControllertHandlerAdapter;
import com.kaikeba.mapping.BeanNameUrlHandlerMapping;
import com.kaikeba.mapping.HandlerMapping;
import com.kaikeba.mapping.SimpleUrlHandlerMapping;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * springmvc提供的唯一的一个Servlet类
 */
public class DispatcherServlet extends AbstractServlet {

    // 随缘不变，不变随缘

    // HandlerAdapter的策略集合
    private List<HandlerAdapter> handlerAdapters = new ArrayList<>();
    // HandlerMapping的策略集合
    private List<HandlerMapping> handlerMappings = new ArrayList<>();

    /**
     * Servlet的初始化
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        handlerAdapters.add(new HttpRequestHandlerAdapter());
        handlerAdapters.add(new SimpleControllertHandlerAdapter());

        handlerMappings.add(new BeanNameUrlHandlerMapping());
        handlerMappings.add(new SimpleUrlHandlerMapping());
    }

    /**
     * 请求分发
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doDispath(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        try {
            // 根据请求，查找对应的处理类
            // 1.处理类长啥样？（它和Servlet无关，可以随便写，只是说为了统一，最后指定规范[接口]）
            // 2.去哪找处理类？（也就是请求URL和处理类的关系在哪建立）
            Object handler = getHandler(request);
            if (handler == null){
                return ;
            }
            // 调用处理类的方法，执行请求处理，并返回处理结果
            HandlerAdapter ha = getHandlerAdapter(handler);
            if (ha == null) {
                return ;
            }
            ha.handleRequest(handler,request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private HandlerAdapter getHandlerAdapter(Object handler) {
        if (handlerAdapters != null){
            // 遍历策略集合
            for (HandlerAdapter ha : handlerAdapters) {
                if (ha.supports(handler)){
                    return ha;
                }
            }
        }
        return null;
    }

    private Object getHandler(HttpServletRequest request) throws Exception{
        // 首先处理类和请求之间 的映射关系可能存储在不同的地方（HandlerMapping）
        if (handlerMappings !=null){
            for (HandlerMapping hm : handlerMappings) {
                Object handler = hm.getHandler(request);
                if(handler != null){
                    return handler;
                }
            }
        }
        return null;
    }
}
