package com.kaikeba.mapping;

import com.kaikeba.handler.QueryUserHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <bean name="/queryUser" class="QueryUserHandler的全路径"></bean>
 */
public class BeanNameUrlHandlerMapping implements HandlerMapping{
    private Map<String,Object> urlHandlers = new HashMap<>();

    public BeanNameUrlHandlerMapping() {
        this.urlHandlers.put("/queryUser",new QueryUserHandler());
    }

    @Override
    public Object getHandler(HttpServletRequest request) throws Exception {
        String uri = request.getRequestURI();
        return this.urlHandlers.get(uri);
    }
}
