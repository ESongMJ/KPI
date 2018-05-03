package cn.songmj.kpi.facade;

import cn.songmj.kpi.entity.YearEndBonus;
import cn.songmj.kpi.param.YearEndBonusParam;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 年终奖预报接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface YearEndBonusFacade extends IService<YearEndBonus> {
    /**
     * 插入
     *
     * @param yearEndBonusParam
     * @return
     */
    Integer insert(YearEndBonusParam yearEndBonusParam);

    /**
     * 更新
     *
     * @param yearEndBonusParam
     * @return
     */
    Integer updateById(YearEndBonusParam yearEndBonusParam);

    /**
     * 列表查询
     *
     * @param yearEndBonusParam
     * @return
     */
    List<YearEndBonusParam> list(YearEndBonusParam yearEndBonusParam);
}
