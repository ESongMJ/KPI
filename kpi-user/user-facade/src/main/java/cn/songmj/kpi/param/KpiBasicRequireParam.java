package cn.songmj.kpi.param;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 岗位基本任务要求
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
public class KpiBasicRequireParam extends PageParam implements Serializable {
    private Long kbrId;
    /**
     * 岗位类型
     */
    private String kbrType;
    /**
     * 技术等级
     */
    private Integer kbrLevel;
    /**
     * 教学要求分
     */
    private Float kbrTeach;
    /**
     * 科研要求
     */
    private Float kbrResearch;
}
