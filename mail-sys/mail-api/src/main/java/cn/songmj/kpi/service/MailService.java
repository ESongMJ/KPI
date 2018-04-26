package cn.songmj.kpi.service;

import cn.songmj.kpi.entity.Mail;
import cn.songmj.kpi.param.MailParam;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author songmj123
 * @since 2018-03-23
 */
public interface MailService {

    /**
     * 保存为草稿
     *
     * @param mailParam
     * @return
     */
    Mail save(MailParam mailParam);

    /**
     * 获取用户的草稿件
     * 若没有草稿则返回Null
     *
     * @param userId
     * @return
     */
    MailParam getMail(String userId);
}
