package cn.songmj.kpi.param;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 年终奖预报审核
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
public class BonusAuditParam extends PageParam implements Serializable {
    private Integer baId;
    /**
     * 年终预报
     */
    private Integer yebId;
    /**
     * 审核结果
     */
    private String baResult;
    /**
     * 审核信息
     */
    private String baReason;
}
