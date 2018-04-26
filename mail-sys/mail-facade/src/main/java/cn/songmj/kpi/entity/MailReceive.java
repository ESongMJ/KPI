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
 * 站内信接收实体
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
@TableName("mail_receive")
public class MailReceive extends Model<MailReceive> implements Serializable {

    @TableId("mr_id")
    private Long mrId;
    /**
     * 站内信
     */
    @TableField("mail_id")
    private Long mailId;
    /**
     * 接收人
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 已读状态
     */
    @TableField("mr_status")
    private Integer mrStatus;

    @Override
    protected Serializable pkVal() {
        return this.mrId;
    }
}
