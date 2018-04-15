package cn.songmj.kpi.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

/**
 * <p>
 * 登录认证拦截器
 * </p>
 *
 * @author meijie.song
 * @date 2018/4/12
 **/
@Slf4j
public class LoginAuthInterceptor implements HandlerInterceptor {
    /**
     * 请求转发前
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String key = "user";
        System.out.println("登录拦截器: "+ request.getSession().getAttribute(key));
        if (request.getSession().getAttribute(key) != null || checkLoginViews(request)) {
            return true;
        }
        response.sendRedirect("/login");
        return false;
    }
    private boolean checkLoginViews(HttpServletRequest request) {
        String uri = request.getRequestURI();
        log.debug("uri:  " + uri);
        // 过滤掉登录页面请求和验证码请求
        String regexLogin = ".*login";
        String regexCode = ".*verifyCode";
        // 过滤跨域请求获取用户id列表
        String regexUids = ".*uid/list";
        if (Pattern.matches(regexLogin, uri)
                || Pattern.matches(regexCode, uri)
                || Pattern.matches(regexUids, uri)) {
            return true;
        }
        return false;
    }
    /**
     * 请求转发后，视图解析前
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 视图解析后
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
