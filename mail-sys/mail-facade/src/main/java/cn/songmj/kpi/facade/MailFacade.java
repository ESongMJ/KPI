package cn.songmj.kpi.facade;

import cn.songmj.kpi.entity.Mail;
import cn.songmj.kpi.param.MailParam;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 站内信接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface MailFacade extends IService<Mail> {
    /**
     * 保存为草稿
     *
     * @param mailParam
     * @return
     */
    Mail save(MailParam mailParam);

    /**
     * 获取用户草稿件
     * @param uid
     * @return
     */
    MailParam getMail(String uid);
}
