package cn.songmj.kpi.service.impl;

import cn.songmj.kpi.facade.MailReceiveFacade;
import cn.songmj.kpi.param.MailParam;
import cn.songmj.kpi.param.MailReceiveParam;
import cn.songmj.kpi.service.MailReceiveService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songmj123
 * @since 2018-03-23
 */
@Service
public class MailReceiveServiceImpl implements MailReceiveService {
    @Reference(
            version = "1.0.0",
            application = "${dubbo.application.id}"
    )
    private MailReceiveFacade mailReceiveFacade;

    @Override
    public Integer send(Long mailId, List<String> uidList) {
        return mailReceiveFacade.send(mailId, uidList);
    }

    @Override
    public Page<MailReceiveParam> page(MailParam mailParam) {
        mailParam = checkPageParam(mailParam);
        return mailReceiveFacade.page(mailParam);
    }

    @Override
    public Integer batchMarkMailRead(List<String> mrIdList) {
        return mailReceiveFacade.batchMarkMailRead(mrIdList);
    }

    @Override
    public Integer markMailRead(String mrId) {
        return mailReceiveFacade.markMailRead(mrId);
    }

    @Override
    public Integer deleteById(String mrId) {
        return mailReceiveFacade.deleteById(mrId);
    }

    @Override
    public MailReceiveParam readMail(String mrId) {
        return mailReceiveFacade.readMail(mrId);
    }
    private MailParam checkPageParam(MailParam mailParam) {
        if (mailParam.getPageSize() == null) {
            mailParam.setPageSize(10);
        }
        if (mailParam.getCurrentPage() == null) {
            mailParam.setCurrentPage(1);
        }
        return mailParam;
    }
}
