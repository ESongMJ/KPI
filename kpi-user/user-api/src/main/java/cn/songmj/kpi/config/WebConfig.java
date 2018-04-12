package cn.songmj.kpi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <p>
 * web配置类
 * </p>
 *
 * @author meijie.song
 * @date 2018/4/12
 **/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * 注册登录拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginAuthInterceptor());
    }
}
