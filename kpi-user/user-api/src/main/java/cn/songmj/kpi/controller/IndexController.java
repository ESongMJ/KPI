package cn.songmj.kpi.controller;

import cn.songmj.kpi.param.UserParam;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Esong
 * @date 2018/4/8
 **/
@Controller
public class IndexController {

    @GetMapping("/sys/{path}")
    public String indexSys(@PathVariable("path") String path) {
        return path;
    }

    @GetMapping("/")
    public String route() {
        return "index";
    }

    @GetMapping("/{path}")
    public String route(@PathVariable("path") String path) {
        return path;
    }
    @GetMapping("/sys/admin/{path}")
    public String routeSysAdmin(@PathVariable("path") String path) {
        return "admin/"+path;
    }
    @GetMapping("/admin/{path}")
    public String routeAdmin(@PathVariable("path") String path) {
        return "admin/"+path;
    }
}
