package cn.songmj.kpi.facade;

import cn.songmj.kpi.entity.KpiForm;
import cn.songmj.kpi.entity.KpiOfUser;
import cn.songmj.kpi.param.KpiFormParam;
import cn.songmj.kpi.param.KpiOfUserParam;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * kpi of user 中间表接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface KpiOfUserFacade extends IService<KpiOfUser> {
    /**1
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
     * 更新最后修改时间
     * @param kpiOfUserParam
     * @return
     */
    Integer updateDateById(KpiOfUserParam kpiOfUserParam);
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
     * 根据用户查询表单信息
     *
     * @param userId
     * @param kpiOfUserParam
     * @return
     */
    Page<KpiOfUserParam> pageByUser(Long userId, KpiOfUserParam kpiOfUserParam);
}
