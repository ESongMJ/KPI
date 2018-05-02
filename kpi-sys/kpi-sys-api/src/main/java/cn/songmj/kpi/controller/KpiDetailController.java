package cn.songmj.kpi.controller;


import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.param.KpiDetailParam;
import cn.songmj.kpi.param.StatisticalObj;
import cn.songmj.kpi.result.Result;
import cn.songmj.kpi.service.KpiDetailService;
import cn.songmj.kpi.service.KpiOfUserService;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author meijie.song123
 * @since 2018-03-23
 */
@RestController
@RequestMapping("/sys/kd")
public class KpiDetailController extends BaseController {
    @Resource
    private KpiDetailService kpiDetailService;
    @Resource
    private KpiOfUserService kpiOfUserService;

    @PostMapping("/save")
    public Result save(KpiDetailParam kpiDetailParam) {
        // 申请成功，则更新对应表单最后的修改时间为当前时间
        if (kpiDetailService.save(kpiDetailParam) > 0) {
            kpiOfUserService.updateDateById(kpiDetailParam.getKuId());
        }
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }

    @PostMapping("/pageByUser")
    public Result pageByUser(KpiDetailParam kpiDetailParam) {
        Page<KpiDetailParam> page = kpiDetailService.pageByUser(kpiDetailParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), page);
    }

    @PostMapping("/getDetail")
    public Result getDetails(String kuId) {
        StatisticalObj statisticalObj = kpiDetailService.selectDetail(kuId);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), statisticalObj);
    }
}

