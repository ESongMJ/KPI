package cn.songmj.kpi.facade;

import cn.songmj.kpi.entity.MailReceive;
import cn.songmj.kpi.param.MailParam;
import cn.songmj.kpi.param.MailReceiveParam;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 站内信接收接口
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

    /**
     * 分页获取信件
     *
     * @param mailParam
     * @return
     */
    Page<MailReceiveParam> page(MailParam mailParam);

    /**
     * 批量标记信件为已读
     *
     * @param mrIdList
     * @return
     */
    Integer batchMarkMailRead(List<String> mrIdList);

    /**
     * 标记信件
     *
     * @param mrId
     * @return
     */
    Integer markMailRead(String mrId);

    /**
     * 读取信件内容
     *
     * @param mrId
     * @return
     */
    MailReceiveParam readMail(String mrId);

    /**
     *
     * @param mrId
     * @return
     */
    Integer deleteById(String mrId);
}
