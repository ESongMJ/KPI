package cn.songmj.kpi.controller;


import cn.songmj.kpi.service.BenefitAllocaService;
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
@RequestMapping("/benefitAlloca")
public class BenefitAllocaController extends BaseController {
    @Resource
    private BenefitAllocaService benefitAllocaService;

}

