package cn.songmj.kpi.controller;


import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.param.UserParam;
import cn.songmj.kpi.result.Result;
import cn.songmj.kpi.service.UserService;
import cn.songmj.kpi.util.CookieUtil;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
@RequestMapping("/sys/user")
public class UserController extends BaseController {
    @Resource
    private UserService userService;
    @Resource
    private DefaultKaptcha defaultKaptcha;

    @PostMapping("/page")
    public Result page(UserParam userParam) {
        Page<UserParam> paramPage = userService.page(userParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), paramPage);
    }

    /**
     * 暴露给外部的接口
     * 返回一个符合要求的用户列表
     *
     * @param userParam
     * @return
     */
    @PostMapping("/list")
    @CrossOrigin
    public Result list(UserParam userParam) {
        List<UserParam> userParamList = userService.list(userParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), userParamList);
    }

    /**
     * 外部接口
     * 返回用户id列表
     *
     * @param userParam
     * @return
     */
    @PostMapping("/uid/list")
    @CrossOrigin
    public Result listUserIds(UserParam userParam) {
        List<String> uids = userService.listUserIds(userParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), uids);
    }

    @PostMapping("/save")
    public Result save(UserParam userParam) {
        userService.save(userParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }

    @PostMapping("/delete")
    public Result delete(Long userId) {
        userService.delete(userId);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }

    /**
     * (弃用)
     * 外部接口
     * 验证用户时候处于登录状态
     *
     * @param request
     * @return
     */
    @PostMapping("/checkLogin")
    @CrossOrigin
    public Result checkLogin(HttpServletRequest request) {
        UserParam userParam = (UserParam) getSessionValue(request, "user");
        if (userParam == null) {
            return view(StatusCode.LOGOUT.getCode(), StatusCode.LOGOUT.getMsg());
        }
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), userParam);
    }

    /**
     * 外部接口
     * 根据用户id获取用户详细信息
     * id根据存储在客户端的cookie获取
     *
     * @param userId
     * @return
     */
    @PostMapping("/getUser")
    @CrossOrigin
    public Result getLoginUser(String userId) {
        UserParam userParam = userService.getUserById(Long.parseLong(userId));

        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), userParam);
    }

    @PostMapping("/login")
    public Result login(HttpServletRequest request, HttpServletResponse response, UserParam userParam, String code) {
        // 检查验证码是否正确
        if (!verifyCode(request, code)) {
            return view(StatusCode.FAIL.getCode(), "验证码输入错误");
        }
        // 根据用户名查询用户
        // 检查用户是否输入正确
        List<UserParam> userParamList = userService.list(userParam);
        if (userParamList.size() != 1) {
            return view(StatusCode.FAIL.getCode(), "用户名错误");
        }
        // 检查密码密码输入是否正确
        UserParam userParam1 = userParamList.get(0);
        if (!userParam1.getUserPassword().equals(userParam.getUserPassword())) {
            return view(StatusCode.FAIL.getCode(), "密码错误");
        }
        // 登录成功
        // 把user信息写入session和cookie
        setSessionValue(request, "user", userParam1);
        response.addCookie(bindUserToCookie(userParam1));
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), userParam1);
    }

    /**
     * 把用户id写入cookie
     *
     * @param userParam
     * @return
     */
    private Cookie bindUserToCookie(UserParam userParam) {
        Cookie userCookie = new Cookie("user_id", String.valueOf(userParam.getUserId()));
        userCookie.setPath("/");
        return userCookie;
    }

    /**
     * 检查验证码
     *
     * @param request
     * @param code
     * @return
     */
    public Boolean verifyCode(HttpServletRequest request, String code) {
        String key = "verifyCode";
        if (code.equals(getSessionValue(request, key))) {
            return true;
        }
        return false;
    }

    /**
     * 获取登录验证码接口
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    @GetMapping("/verifyCode")
    public Object getVerifyCode(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            setSessionValue(httpServletRequest, "verifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        byte[] captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        try {
            ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
            responseOutputStream.write(captchaChallengeAsJpeg);
            responseOutputStream.flush();
            responseOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

