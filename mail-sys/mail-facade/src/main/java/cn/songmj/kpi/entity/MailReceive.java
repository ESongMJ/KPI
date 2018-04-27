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
    @TableField(exist = false)
    private Mail mail;
    /**
     * 接收人
     */
    @TableField("user_id")
    private Long userId;
    @TableField(exist = false)
    private String userName;
    /**
     * 已读状态
     */
    @TableField("mr_status")
    private Integer mrStatus;
    /**
     * 信件发送时间
     */
    @TableField("mr_Date")
    private String mrDate;

    @Override
    protected Serializable pkVal() {
        return this.mrId;
    }
}
