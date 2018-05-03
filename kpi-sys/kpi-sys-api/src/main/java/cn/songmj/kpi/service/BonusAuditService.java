package cn.songmj.kpi.service;

import cn.songmj.kpi.param.BonusAuditParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author songmj123
 * @since 2018-03-23
 */
public interface BonusAuditService {
    /**
     * 更新
     *
     * @param bonusAuditParam
     * @return
     */
    Integer save(BonusAuditParam bonusAuditParam);

    /**
     * 查询
     *
     * @param yebId
     * @return
     */
    BonusAuditParam selectOne(Long yebId);
}
