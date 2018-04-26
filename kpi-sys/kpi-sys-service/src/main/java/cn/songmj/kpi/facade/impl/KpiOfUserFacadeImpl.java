package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.KpiForm;
import cn.songmj.kpi.entity.KpiOfUser;
import cn.songmj.kpi.facade.KpiOfUserFacade;
import cn.songmj.kpi.mapper.KpiOfUserMapper;
import cn.songmj.kpi.param.KpiFormParam;
import cn.songmj.kpi.param.KpiOfUserParam;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
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
public class KpiOfUserFacadeImpl extends ServiceImpl<KpiOfUserMapper, KpiOfUser> implements KpiOfUserFacade {

    @Override
    public Page<KpiOfUserParam> page(KpiOfUserParam kpiOfUserParam) {
        return null;
    }

    @Override
    public List<KpiOfUserParam> list(KpiOfUserParam kpiOfUserParam) {
        return null;
    }

    @Override
    public Integer insert(KpiOfUserParam kpiOfUserParam) {
        return null;
    }

    @Override
    public Integer update(KpiOfUserParam kpiOfUserParam) {
        return null;
    }

    @Override
    public Integer updateDateById(KpiOfUserParam kpiOfUserParam) {
        KpiOfUser ku = new KpiOfUser();
        BeanUtils.copyProperties(kpiOfUserParam, ku);
        return baseMapper.updateById(ku);
    }

    @Override
    public Integer delete(Long kuId) {
        return null;
    }

    @Override
    public Integer send(Long kfId, List<String> userIdList) {
        List<KpiOfUser> kuList = bindFormAndUser(kfId, userIdList);
        return baseMapper.insertBatch(kuList);
    }

    @Override
    public Page<KpiOfUserParam> pageByUser(Long userId, KpiOfUserParam kpiOfUserParam) {
        Page<KpiOfUser> kuPage = new Page<>();
        KpiOfUser ku = new KpiOfUser();
        BeanUtils.copyProperties(kpiOfUserParam, ku);
        kuPage.setSize(kpiOfUserParam.getPageSize());
        kuPage.setCurrent(kpiOfUserParam.getCurrentPage());
        List<KpiOfUser> kuList = baseMapper.selectPageByUser(kuPage, userId, ku);
        Page<KpiOfUserParam> kuParamPage = new Page<>();
        BeanUtils.copyProperties(kuPage, kuParamPage);
        kuParamPage.setRecords(kuList.stream().map(kpiOfUser -> {
            KpiOfUserParam kuParam = new KpiOfUserParam();
            BeanUtils.copyProperties(kpiOfUser, kuParam);
            KpiFormParam kf = new KpiFormParam();
            BeanUtils.copyProperties(kpiOfUser.getKf(), kf);
            kf.setKfBeginDate(kf.getKfBeginDate().substring(0, 4));
            kf.setKfEndDate(kf.getKfEndDate().substring(0, 4));
            kuParam.setKf(kf);
            return kuParam;
        }).collect(Collectors.toList()));
        return kuParamPage;
    }

    private List<KpiOfUser> bindFormAndUser(Long kfId, List<String> userIdList) {
        return userIdList.stream().map(userId -> {
            KpiOfUser ku = new KpiOfUser();
            ku.setKuId(null);
            ku.setUserId(Long.valueOf(userId));
            ku.setKfId(kfId);
            ku.setKuStatus(1);
            ku.setKuFinishDate("----.--.--");
            return ku;
        }).collect(Collectors.toList());
    }
}
