package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.YearEndBonus;
import cn.songmj.kpi.facade.YearEndBonusFacade;
import cn.songmj.kpi.mapper.YearEndBonusMapper;
import cn.songmj.kpi.param.YearEndBonusParam;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public Integer insert(YearEndBonusParam yearEndBonusParam) {
        YearEndBonus yearEndBonus = getEntityByParam(yearEndBonusParam);
        return baseMapper.insert(yearEndBonus);
    }

    @Override
    public Integer updateById(YearEndBonusParam yearEndBonusParam) {
        YearEndBonus yearEndBonus = getEntityByParam(yearEndBonusParam);
        return baseMapper.updateById(yearEndBonus);
    }

    @Override
    public List<YearEndBonusParam> list(YearEndBonusParam yearEndBonusParam) {
        EntityWrapper<YearEndBonus> ew = bindQueryParam(yearEndBonusParam);
        List<YearEndBonus> list = baseMapper.selectList(ew);
        return list.stream().map(this::getParamByEntity).collect(Collectors.toList());
    }

    private YearEndBonus getEntityByParam(YearEndBonusParam yearEndBonusParam) {
        YearEndBonus yearEndBonus = new YearEndBonus();
        BeanUtils.copyProperties(yearEndBonusParam, yearEndBonus);
        return yearEndBonus;
    }
    private YearEndBonusParam getParamByEntity(YearEndBonus yearEndBonus) {
        YearEndBonusParam yearEndBonusParam = new YearEndBonusParam();
        BeanUtils.copyProperties(yearEndBonus, yearEndBonusParam);
        return yearEndBonusParam;
    }
    private EntityWrapper<YearEndBonus> bindQueryParam(YearEndBonusParam yearEndBonusParam){
        EntityWrapper<YearEndBonus> ew = new EntityWrapper<>();

        if (yearEndBonusParam.getYebId() != null) {
            ew.eq("yeb_id", yearEndBonusParam.getYebId());
        }
        if (yearEndBonusParam.getUserId() != null) {
            ew.eq("user_id", yearEndBonusParam.getUserId());
        }
        if (yearEndBonusParam.getKuId() != null) {
            ew.eq("ku_id", yearEndBonusParam.getKuId());
        }
        return ew;
    }

}
