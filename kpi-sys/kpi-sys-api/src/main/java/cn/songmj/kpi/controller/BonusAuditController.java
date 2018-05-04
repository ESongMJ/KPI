package cn.songmj.kpi.controller;


import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.param.BonusAuditParam;
import cn.songmj.kpi.param.YearEndBonusParam;
import cn.songmj.kpi.result.Result;
import cn.songmj.kpi.service.BonusAuditService;
import cn.songmj.kpi.service.YearEndBonusService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author meijie.song123
 * @since 2018-03-23
 */
@RestController
@RequestMapping("/sys/ba")
public class BonusAuditController extends BaseController {
    @Resource
    private BonusAuditService bonusAuditService;
    @Resource
    private YearEndBonusService yearEndBonusService;

    @PostMapping("/save")
    public Result save(BonusAuditParam bonusAuditParam) {
        // 审核成功之后级联修改申请表中审核状态
        if (bonusAuditService.save(bonusAuditParam) > 0) {
            YearEndBonusParam yearEndBonusParam = new YearEndBonusParam();
            yearEndBonusParam.setYebId(bonusAuditParam.getYebId());
            yearEndBonusParam.setYebStatus(bonusAuditParam.getBaResult());
            yearEndBonusService.save(yearEndBonusParam);
        }
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }
    @PostMapping("/get/one")
    public Result getOne(Long yebId) {
        BonusAuditParam bonusAuditParam = bonusAuditService.selectOne(yebId);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), bonusAuditParam);
    }
}

