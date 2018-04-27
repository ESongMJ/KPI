package cn.songmj.kpi.param;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
public class MailReceiveParam extends PageParam implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long mrId;
    /**
     * 站内信
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long mailId;
    private MailParam mail;
    /**
     * 接收人
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    private String userName;
    /**
     * 已读状态 1 未读  2 已读
     */
    private Integer mrStatus;
    private String mrDate;
}
