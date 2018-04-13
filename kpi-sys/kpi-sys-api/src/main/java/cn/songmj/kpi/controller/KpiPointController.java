package cn.songmj.kpi.controller;


import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.param.KpiPointParam;
import cn.songmj.kpi.result.Result;
import cn.songmj.kpi.service.KpiPointService;
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
@RequestMapping("/sys/kp")
public class KpiPointController extends BaseController {
    @Resource
    private KpiPointService kpiPointService;

    @PostMapping("/page")
    public Result page(KpiPointParam kpiPointParam) {
        Page<KpiPointParam> kpParamPage = kpiPointService.page(kpiPointParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), kpParamPage);
    }
    @PostMapping("/list")
    public Result list(KpiPointParam kpiPointParam) {
        List<KpiPointParam> kpParamList = kpiPointService.list(kpiPointParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), kpParamList);
    }
    @PostMapping("/save")
    public Result save(KpiPointParam kpiPointParam) {
        kpiPointService.save(kpiPointParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }
    @PostMapping("/delete")
    public Result delete(Long kpId) {
        kpiPointService.delete(kpId);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }
}

