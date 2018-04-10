package cn.songmj.kpi.controller;


import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.param.NavParam;
import cn.songmj.kpi.result.Result;
import cn.songmj.kpi.service.NavService;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author meijie.song123
 * @since 2018-03-23
 */
@RestController
@RequestMapping("/sys/nav")
public class NavController extends BaseController {
    @Resource
    private NavService navService;

    @PostMapping("/page")
    public Result page(NavParam navParam) {
        Page<NavParam> paramPage = navService.page(navParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), paramPage);
    }
    @PostMapping("/list")
    public Result list(NavParam navParam) {
        List<NavParam> list = navService.list(navParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), list);
    }
    @PostMapping("/save")
    public Result save(NavParam navParam) {
        navService.save(navParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }
    @PostMapping("/delete")
    public Result delete(Long navId) {
        navService.delete(navId);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }

}

