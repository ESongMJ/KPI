package cn.songmj.kpi.facade;

import cn.songmj.kpi.entity.MailReceive;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  站内信接收接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface MailReceiveFacade extends IService<MailReceive> {
    /**
     * 发送站内信
     *
     * @param mailId
     * @param uidList
     * @return
     */
    Integer send(Long mailId, List<String> uidList);

}
