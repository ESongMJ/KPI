package cn.songmj.kpi.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
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
@TableName("kpi_basic_require")
public class KpiBasicRequire extends Model<KpiBasicRequire> implements Serializable {
    @TableId("kbr_id")
    private Long kbrId;
    /**
     * 岗位类型
     */
    @TableField("kbr_type")
    private String kbrType;
    /**
     * 技术等级
     */
    @TableField("kbr_level")
    private Integer kbrLevel;
    /**
     * 教学要求分
     */
    @TableField("kbr_teach")
    private Float kbrTeach;
    /**
     * 科研要求
     */
    @TableField("kbr_research")
    private Float kbrResearch;

    @Override
    protected Serializable pkVal() {
        return this.kbrId;
    }
}
