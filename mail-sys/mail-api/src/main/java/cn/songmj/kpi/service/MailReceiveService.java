package cn.songmj.kpi.service;

import java.util.List;

/**
 * <p>
 *  服务类
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

}
