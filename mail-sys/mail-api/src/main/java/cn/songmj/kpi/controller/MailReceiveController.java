package cn.songmj.kpi.controller;


import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.param.MailParam;
import cn.songmj.kpi.param.MailReceiveParam;
import cn.songmj.kpi.result.Result;
import cn.songmj.kpi.service.MailReceiveService;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author meijie.song123
 * @since 2018-03-23
 */
@RestController
@RequestMapping("/mr")
public class MailReceiveController extends BaseController {
    @Resource
    private MailReceiveService mailReceiveService;

    @PostMapping("/page")
    public Result page(MailParam mailParam) {
        Page<MailReceiveParam> paramPage = mailReceiveService.page(mailParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), paramPage);
    }

    @PostMapping("/mark/batch")
    public Result batchMark(@RequestParam("mrIds[]") String[] mrIds) {
        List<String> uidList = Arrays.asList(mrIds);
        if (uidList.size() != mailReceiveService.batchMarkMailRead(uidList)) {
            return view(StatusCode.FAIL.getCode(), StatusCode.FAIL.getMsg());
        }
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }

    @PostMapping("/mark")
    public Result mark(String mrId) {
        mailReceiveService.markMailRead(mrId);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }

    @PostMapping("/read/mail")
    public Result readMail(String mrId) {
        MailReceiveParam mailReceiveParam = mailReceiveService.readMail(mrId);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), mailReceiveParam);
    }

    @PostMapping("/delete")
    public Result deleteById(String mrId) {
        mailReceiveService.deleteById(mrId);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }
}

