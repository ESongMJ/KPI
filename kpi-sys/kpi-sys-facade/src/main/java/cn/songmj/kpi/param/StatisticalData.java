package cn.songmj.kpi.param;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 统计数据
 * </p>
 *
 * @author meijie.song
 * @date 2018/5/2
 **/
@Data
public class StatisticalData  implements Serializable {
    private String name;
    private String reason;
    private Float score;
    private Integer type;
}
