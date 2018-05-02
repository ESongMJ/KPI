package cn.songmj.kpi.controller;


import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.param.KpiOfUserParam;
import cn.songmj.kpi.result.Result;
import cn.songmj.kpi.service.KpiOfUserService;
import cn.songmj.kpi.util.CookieUtil;
import cn.songmj.kpi.util.param.UserParam;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    public Result send(Long kfId, @RequestParam("uids[]") String[] uids) {
        kpiOfUserService.send(kfId, Arrays.asList(uids));
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }

    @PostMapping("/page")
    public Result pageByUser(KpiOfUserParam kpiOfUserParam) {
        Page<KpiOfUserParam> kuPage = kpiOfUserService.pageByUser(kpiOfUserParam.getUserId(), kpiOfUserParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), kuPage);
    }

    @PostMapping("/list")
    public Result list(KpiOfUserParam kpiOfUserParam) {
        List<KpiOfUserParam> kuList = kpiOfUserService.list(kpiOfUserParam);

        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), kuList);
    }
}

