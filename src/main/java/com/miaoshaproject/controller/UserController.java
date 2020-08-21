package com.miaoshaproject.controller;

import com.miaoshaproject.controller.viewobject.UserVO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller("user") //用于被spring扫描到，name是user
@RequestMapping("/user")
/*allowCredentials 需配合前端设置xhrFields授信后使得跨域session共享*/
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    //用户获取otp短信
    /*RequestMapping 的 consumes属性用于指定处理请求的提交内容类型（Content-Type）
    *   与consumes对应的是produces 用于指定返回值类型和字符编码
    *   这里produces可以省略，@ResponseBody注解返回值是json数据*/    //application/x-www-form-urlencoded
    @RequestMapping(value = "/getopt",method = {RequestMethod.POST},consumes = CONTENT_TYPE_FORMED)
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(name = "telephone")String telephone){
        //1、按照一定规则生成otp验证码
        Random random = new Random();
        int randomInt = random.nextInt(99999);//此时值为[0,99999)
        randomInt+=10000;
        String optCode = String.valueOf(randomInt);

        //2、将opt与用户手机关联
        httpServletRequest.getSession().setAttribute(telephone,optCode);

        //3、将opt验证码通过短信通道发送给用户
        System.out.println("telephone = "+telephone+" & optCode = "+optCode);

        return CommonReturnType.create(null);
    }


    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id")Integer id) throws BusinessException {
        UserModel userModel = userService.getUserById(id);

        //若用户不存在
        if (userModel == null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }

        UserVO userVO = convertFromModel(userModel);
        return CommonReturnType.create(userVO);
    }

    private UserVO convertFromModel(UserModel userModel){
        if (userModel == null){
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel,userVO);
        return userVO;
    }


}
