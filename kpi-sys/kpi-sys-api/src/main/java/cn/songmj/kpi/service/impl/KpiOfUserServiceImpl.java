package cn.songmj.kpi.service.impl;

import cn.songmj.kpi.facade.KpiOfUserFacade;
import cn.songmj.kpi.param.KpiOfUserParam;
import cn.songmj.kpi.param.PageParam;
import cn.songmj.kpi.service.KpiOfUserService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
public class KpiOfUserServiceImpl implements KpiOfUserService {
    @Reference(
            version = "1.0.0",
            application = "${dubbo.application.id}"
    )
    private KpiOfUserFacade kpiOfUserFacade;

    @Override
    public Page<KpiOfUserParam> page(KpiOfUserParam kpiOfUserParam) {
        return null;
    }

    @Override
    public List<KpiOfUserParam> list(KpiOfUserParam kpiOfUserParam) {
        return kpiOfUserFacade.list(kpiOfUserParam);
    }

    @Override
    public Integer save(KpiOfUserParam kpiOfUserParam) {
        return null;
    }

    @Override
    public Integer updateDateById(Long kuId) {
        KpiOfUserParam kpiOfUserParam = new KpiOfUserParam();
        kpiOfUserParam.setKuId(kuId);
        // 更新最后修改时间
        kpiOfUserParam.setKuFinishDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
        // 设置状态为已完成
        kpiOfUserParam.setKuStatus(2);
        return kpiOfUserFacade.updateDateById(kpiOfUserParam);
    }

    @Override
    public Integer delete(Long kuId) {
        return null;
    }

    @Override
    public Integer send(Long kfId, List<String> userIdList) {
        return kpiOfUserFacade.send(kfId, userIdList);
    }

    @Override
    public Page<KpiOfUserParam> pageByUser(Long userId, KpiOfUserParam kpiOfUserParam) {
        checkPageParam(kpiOfUserParam);
        return kpiOfUserFacade.pageByUser(userId, kpiOfUserParam);
    }
    private void checkPageParam(PageParam pageParam) {
        if (pageParam.getPageSize() == null) {
            pageParam.setPageSize(10);
        }
        if (pageParam.getCurrentPage() == null) {
            pageParam.setCurrentPage(1);
        }
    }
}
