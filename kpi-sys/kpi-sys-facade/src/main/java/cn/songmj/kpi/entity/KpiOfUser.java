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
 * 绩效申请表单 <=> 用户  -> 中间表
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
@TableName("kpi_of_user")
public class KpiOfUser extends Model<KpiOfUser> implements Serializable {

    @TableId("ku_id")
    private Long kuId;
    /**
     * 用户
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 绩效申请表单
     */
    @TableField("kf_id")
    private Long kfId;
    @TableField(exist = false)
    private KpiForm kf;
    /**
     * 表单状态
     */
    @TableField("ku_status")
    private Integer kuStatus;
    /**
     * 完成填写/申请日期
     */
    @TableField("ku_finish_date")
    private String kuFinishDate;

    @Override
    protected Serializable pkVal() {
        return this.kuId;
    }
}
