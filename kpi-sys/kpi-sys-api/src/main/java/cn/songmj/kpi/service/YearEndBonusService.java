package cn.songmj.kpi.service;

import cn.songmj.kpi.param.YearEndBonusParam;
import com.baomidou.mybatisplus.plugins.Page;

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

}
