package cn.songmj.kpi.service;

import cn.songmj.kpi.param.KpiBasicRequireParam;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author songmj123
 * @since 2018-03-23
 */
public interface KpiBasicRequireService {
    /**
     * 分页查询数据
     *
     * @param kbrParam
     * @return
     */
    Page<KpiBasicRequireParam> page(KpiBasicRequireParam kbrParam);

    /**
     * 列表查询数据
     *
     * @param kbrParam
     * @return
     */
    List<KpiBasicRequireParam> list(KpiBasicRequireParam kbrParam);

    /**
     * 删除
     *
     * @param kbrId
     * @return
     */
    Integer delete(Long kbrId);

    /**
     * 保存
     *
     * @param kbrParam
     * @return
     */
    Integer save(KpiBasicRequireParam kbrParam);

    /**
     * 根据id查询
     *
     * @param kbrId
     * @return
     */
    KpiBasicRequireParam getOne(Long kbrId);
}
