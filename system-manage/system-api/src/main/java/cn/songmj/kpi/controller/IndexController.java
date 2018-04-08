package cn.songmj.kpi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Esong
 * @date 2018/4/8
 **/
@Controller
public class IndexController {

    @GetMapping("/sys/index")
    public String index() {
        return "index";
    }
}
