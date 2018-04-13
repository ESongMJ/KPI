package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.YearEndBonus;
import cn.songmj.kpi.facade.YearEndBonusFacade;
import cn.songmj.kpi.mapper.YearEndBonusMapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author meijie.song123
 * @since 2018-03-23
 */
@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class YearEndBonusFacadeImpl extends ServiceImpl<YearEndBonusMapper, YearEndBonus> implements YearEndBonusFacade {

}
