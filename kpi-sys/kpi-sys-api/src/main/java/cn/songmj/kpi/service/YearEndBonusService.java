package cn.songmj.kpi.service;

import cn.songmj.kpi.param.YearEndBonusParam;
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
public interface YearEndBonusService {
    /**
     * 分页查询
     *
     * @param yearEndBonusParam
     * @return
     */
    Page<YearEndBonusParam> page(YearEndBonusParam yearEndBonusParam);
    /**
     * 更新
     *
     * @param yearEndBonusParam
     * @return
     */
    Integer save(YearEndBonusParam yearEndBonusParam);

    /**
     * 列表查询
     *
     * @param yearEndBonusParam
     * @return
     */
    List<YearEndBonusParam> list(YearEndBonusParam yearEndBonusParam);
}
