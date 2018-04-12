package cn.songmj.kpi.facade;

import cn.songmj.kpi.entity.KpiBasicRequire;
import cn.songmj.kpi.param.KpiBasicRequireParam;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  kpi基本要求
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface KpiBasicRequireFacade extends IService<KpiBasicRequire> {
    /**
     * 分页查询数据
     * @param kbrParam
     * @return
     */
    Page<KpiBasicRequireParam> page(KpiBasicRequireParam kbrParam);

    /**
     * 列表查询数据
     * @param kbrParam
     * @return
     */
    List<KpiBasicRequireParam> list(KpiBasicRequireParam kbrParam);

    /**
     * 删除用户
     * @param kbrId
     * @return
     */
    Integer delete(Long kbrId);

    /**
     * 插入用户
     * @param kbrParam
     * @return
     */
    Integer insert(KpiBasicRequireParam kbrParam);

    /**
     * 更新用户
     * @param kbrParam
     * @return
     */
    Integer update(KpiBasicRequireParam kbrParam);
}
