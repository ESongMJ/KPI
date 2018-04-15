package cn.songmj.kpi.controller;


import cn.songmj.kpi.entity.KpiForm;
import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.param.KpiFormParam;
import cn.songmj.kpi.result.Result;
import cn.songmj.kpi.service.KpiFormService;
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
@RequestMapping("/sys/kf")
public class KpiFormController extends BaseController {
    @Resource
    private KpiFormService kpiFormService;

    @PostMapping("/page")
    public Result page(KpiFormParam kpiFormParam) {
        Page<KpiFormParam> page = kpiFormService.page(kpiFormParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), page);
    }

    @PostMapping("/save")
    public Result save(KpiFormParam kpiFormParam) {
        kpiFormService.save(kpiFormParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }

    @PostMapping("/list")
    public Result list(KpiFormParam kpiFormParam) {
        List<KpiFormParam> list = kpiFormService.list(kpiFormParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), list);
    }

    @PostMapping("/delete")
    public Result delete(Long kfId) {
        kpiFormService.delete(kfId);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }
}

