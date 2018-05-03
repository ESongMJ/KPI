package cn.songmj.kpi.param;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 收益分配表
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
public class BenefitAllocaParam extends PageParam implements Serializable {
    private Integer baId;
    /**
     * 绩效表单详情
     */
    private Integer kdId;
    private Integer userId;
    /**
     * 受益分配分数
     */
    private String baScore;
    /**
     * 受益分配理由
     */
    private String baReason;
}
