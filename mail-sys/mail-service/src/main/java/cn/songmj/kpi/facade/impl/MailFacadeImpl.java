package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.Mail;
import cn.songmj.kpi.facade.MailFacade;
import cn.songmj.kpi.mapper.MailMapper;
import cn.songmj.kpi.param.MailParam;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author meijie.song123
 * @since 2018-03-23
 */
@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class MailFacadeImpl extends ServiceImpl<MailMapper, Mail> implements MailFacade {

    @Override
    public Mail save(MailParam mailParam) {
        Mail mail = getMailByParam(mailParam);
        if (mail.getMailId() != null) {
            baseMapper.updateById(mail);
        } else {
            baseMapper.insert(mail);
        }
        return mail;
    }

    @Override
    public MailParam getMail(String uid) {
        EntityWrapper<Mail> ew = new EntityWrapper<>();
        ew.eq("user_id", uid);
        List<Mail> mails = baseMapper.selectList(ew);
        // 未查询到数据
        if (mails.size() < 1) {
            return null;
        }
        return getParamByMail(mails.get(0));
    }

    private MailParam getParamByMail(Mail mail) {
        MailParam mailParam = new MailParam();
        BeanUtils.copyProperties(mail, mailParam);
        return mailParam;
    }

    private Mail getMailByParam(MailParam mailParam) {
        Mail mail = new Mail();
        BeanUtils.copyProperties(mailParam, mail);
        return mail;
    }
}
