package com.sana.filter;



import com.sana.pojo.Authorizations;
import com.sana.service.AuthorizationsService;
import com.sana.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

@Configuration("AuthorizationsFilter")
public class AuthorizationsFilter implements Filter{
    @Autowired
    private AuthorizationsService authorizationsService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //查询角色，并在login页面显示
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        List<Authorizations> list=authorizationsService.getAllRole();
        //保存查询的角色到request里的list
        servletRequest.setAttribute("list",list);
        //请求向下传递
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
