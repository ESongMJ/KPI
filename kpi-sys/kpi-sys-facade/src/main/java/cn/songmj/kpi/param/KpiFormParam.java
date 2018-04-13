package cn.songmj.kpi.param;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 绩效申请表单
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
public class KpiFormParam extends PageParam implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long kfId;
    private String kfName;
    /**
     * 开始时间
     */
    private String kfBeginDate;
    /**
     * 结束时间
     */
    private String kfEndDate;
}
