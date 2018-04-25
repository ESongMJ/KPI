package cn.songmj.kpi.service;

import cn.songmj.kpi.param.KpiOfUserParam;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author songmj123
 * @since 2018-03-23
 */
public interface KpiOfUserService {
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
     * 保存
     *
     * @param kpiOfUserParam
     * @return
     */
    Integer save(KpiOfUserParam kpiOfUserParam);

    /**
     * 删除
     *
     * @param kuId
     * @return
     */
    Integer delete(Long kuId);

    /**
     * 批量插入
     * 分发表单
     *
     * @param kfId
     * @param userIdList
     * @return
     */
    Integer send(Long kfId, List<String> userIdList);

    /**
     * 根据用户分页查找绩效表单
     *
     * @param userId
     * @param kpiOfUserParam
     * @return
     */
    Page<KpiOfUserParam> pageByUser(Long userId, KpiOfUserParam kpiOfUserParam);
}
