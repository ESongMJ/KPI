package cn.songmj.kpi.controller;


import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.result.Result;
import cn.songmj.kpi.service.KpiOfUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
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
@RequestMapping("/sys/ku")
public class KpiOfUserController extends BaseController {
    @Resource
    private KpiOfUserService kpiOfUserService;

    @PostMapping("/send")
    public Result send(Long kfId, @RequestParam("uids[]") Long[] uids) {
        kpiOfUserService.send(kfId, Arrays.asList(uids));
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }
}

