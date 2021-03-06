package cn.songmj.kpi.service.impl;

import cn.songmj.kpi.facade.YearEndBonusFacade;
import cn.songmj.kpi.param.YearEndBonusParam;
import cn.songmj.kpi.service.YearEndBonusService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songmj123
 * @since 2018-03-23
 */
@Service
public class YearEndBonusServiceImpl implements YearEndBonusService {
    @Reference(
            version = "1.0.0",
            application = "${dubbo.application.id}"
    )
    private YearEndBonusFacade yearEndBonusFacade;

    @Override
    public Page<YearEndBonusParam> page(YearEndBonusParam yearEndBonusParam, String type) {
        return yearEndBonusFacade.page(yearEndBonusParam, type) ;
    }

    @Override
    public Integer save(YearEndBonusParam yearEndBonusParam) {
        if (yearEndBonusParam.getYebId() == null || yearEndBonusParam.getYebId() == -1L) {
            yearEndBonusParam.setYebId(null);
            return yearEndBonusFacade.insert(yearEndBonusParam);
        }
        return yearEndBonusFacade.updateById(yearEndBonusParam);
    }

    @Override
    public List<YearEndBonusParam> list(YearEndBonusParam yearEndBonusParam) {
        return yearEndBonusFacade.list(yearEndBonusParam);
    }
}
