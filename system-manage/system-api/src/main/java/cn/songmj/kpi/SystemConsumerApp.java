package cn.songmj.kpi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.devtools.remote.client.HttpHeaderInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * <p>
 * </p>
 *
 * @author meijie.song
 * @date 2018/3/22
 * @time 下午 2:05
 **/
@SpringBootApplication
public class SystemConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(SystemConsumerApp.class);
    }
}
