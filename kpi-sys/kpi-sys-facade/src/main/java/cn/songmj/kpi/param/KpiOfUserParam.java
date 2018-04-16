package cn.songmj.kpi.param;

import cn.songmj.kpi.entity.KpiForm;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 绩效申请表单 <=> 用户  -> 中间表
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
public class KpiOfUserParam extends PageParam implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long kuId;
    /**
     * 用户
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    /**
     * 绩效申请表单
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long kfId;
    private KpiFormParam kf;
    /**
     * 表单状态
     */
    private Integer kuStatus;
    /**
     * 完成填写/申请日期
     */
    private String kuFinishDate;
}
