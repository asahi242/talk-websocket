package com.demo.talk;

import com.demo.talk.entity.UserInfo;
import com.demo.talk.entity.po.User;
import com.demo.talk.utils.EhcacheUtils;
import net.sf.ehcache.Element;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getServletPath());
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("UserInfo");
        if (userInfo !=null && !"".equals(userInfo)){
            Element element = EhcacheUtils.getElement("USER_" + userInfo.getName());
            if (element!=null){
                EhcacheUtils.setElement("USER_"+ userInfo.getName(), userInfo);
                return true;
            }
        }

        request.getRequestDispatcher("/login").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
