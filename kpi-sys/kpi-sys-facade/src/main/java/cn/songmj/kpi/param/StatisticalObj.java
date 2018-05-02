package cn.songmj.kpi.param;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 统计数据对象
 * </p>
 *
 * @author meijie.song
 * @date 2018/5/2
 **/
@Data
public class StatisticalObj implements Serializable {
    /**
     * 教学绩效分数总和
     */
    private Float teachScore;
    /**
     * 科研绩效分数总和
     */
    private Float researchScore;
    /**
     * 本期绩效分数总和
     */
    private Float totalScore;
    /**
     * 得分详情
     */
    private List<StatisticalData> data;
}
