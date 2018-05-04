package cn.songmj.kpi.service.impl;

import cn.songmj.kpi.entity.Mail;
import cn.songmj.kpi.facade.MailFacade;
import cn.songmj.kpi.param.MailParam;
import cn.songmj.kpi.service.MailService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songmj123
 * @since 2018-03-23
 */
@Service
public class MailServiceImpl implements MailService {
    @Reference(
            version = "1.0.0",
            application = "${dubbo.application.id}"
    )
    private MailFacade mailFacade;

    @Override
    public Mail save(MailParam mailParam) {
        // 获取当前日期
        if (mailParam.getMailDate() == null || "".equals(mailParam.getMailDate())) {
            mailParam.setMailDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
        }
        return mailFacade.save(mailParam);
    }

    @Override
    public MailParam getMail(String userId) {
        return mailFacade.getMail(userId);
    }
}
