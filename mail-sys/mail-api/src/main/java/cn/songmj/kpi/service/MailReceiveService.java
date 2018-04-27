package cn.songmj.kpi.service;

import cn.songmj.kpi.param.MailParam;
import cn.songmj.kpi.param.MailReceiveParam;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author songmj123
 * @since 2018-03-23
 */
public interface MailReceiveService {
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
     * 删除收件信息
     *
     * @param mrId
     * @return
     */
    Integer deleteById(String mrId);
}
