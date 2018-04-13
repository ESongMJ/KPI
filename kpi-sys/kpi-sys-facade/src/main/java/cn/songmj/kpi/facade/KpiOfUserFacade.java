package cn.songmj.kpi.facade;

import cn.songmj.kpi.entity.KpiOfUser;
import cn.songmj.kpi.param.KpiOfUserParam;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  kpi of user 中间表接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface KpiOfUserFacade extends IService<KpiOfUser> {
    /**
     * 分页查询
     *
     * @param kpiOfUserParam
     * @return
     */
    Page<KpiOfUserParam> page(KpiOfUserParam kpiOfUserParam);

    /**
     * 列表查询
     *
     * @param kpiOfUserParam
     * @return
     */
    List<KpiOfUserParam> list(KpiOfUserParam kpiOfUserParam);

    /**
     * 插入
     *
     * @param kpiOfUserParam
     * @return
     */
    Integer insert(KpiOfUserParam kpiOfUserParam);

    /**
     * 更新
     *
     * @param kpiOfUserParam
     * @return
     */
    Integer update(KpiOfUserParam kpiOfUserParam);

    /**
     * 删除
     *
     * @param kuId
     * @return
     */
    Integer delete(Long kuId);
}
