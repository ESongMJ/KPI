package cn.songmj.kpi.facade;

import cn.songmj.kpi.entity.BonusAudit;
import cn.songmj.kpi.param.BonusAuditParam;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 年终奖审核接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface BonusAuditFacade extends IService<BonusAudit> {
    /**
     * 插入
     *
     * @param bonusAuditParam
     * @return
     */
    Integer insert(BonusAuditParam bonusAuditParam);

    /**
     * 更新
     *
     * @param bonusAuditParam
     * @return
     */
    Integer updateById(BonusAuditParam bonusAuditParam);

    /**
     * 查询
     *
     * @param yebId
     * @return
     */
    BonusAuditParam selectOne(Long yebId);
}
