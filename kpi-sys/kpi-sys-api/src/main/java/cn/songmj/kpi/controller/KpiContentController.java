package cn.songmj.kpi.controller;


import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.param.KpiContentParam;
import cn.songmj.kpi.result.Result;
import cn.songmj.kpi.service.KpiContentService;
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
@RequestMapping("/sys/kc")
public class KpiContentController extends BaseController {
    @Resource
    private KpiContentService kpiContentService;

    @PostMapping("/page")
    public Result page(KpiContentParam kpiContentParam) {
        Page<KpiContentParam> page = kpiContentService.page(kpiContentParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), page);
    }
    @PostMapping("/save")
    public Result save(KpiContentParam kpiContentParam) {
        kpiContentService.save(kpiContentParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }
    @PostMapping("/list")
    public Result list(KpiContentParam kpiContentParam) {
        List<KpiContentParam> list = kpiContentService.list(kpiContentParam);

        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), list);
    }
    @PostMapping("/delete")
    public Result delete(Long kcId) {
        kpiContentService.delete(kcId);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }
}

