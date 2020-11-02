package com.allchip.pack.web;

import com.allchip.pack.bean.RequestBean;
import com.allchip.pack.mapper.UserMapper;
import com.allchip.pack.pojo.User;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;


    /**接口 */
    /**登录*/
    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public String login(@RequestBody User reqUser) throws Exception {
        RequestBean<User> bean = new RequestBean<User>();
        if(reqUser == null){
            bean.setStatus(RequestBean.STATUS_FAILED);
            bean.setMsg("请求信息错误");
            return new Gson().toJson(bean);
        }
        User user = userMapper.getByName(reqUser.getName());
        if(user == null){
            bean.setStatus(RequestBean.STATUS_FAILED);
            bean.setMsg("账号不存在");

        }else if(reqUser.getPassword().equals( user.getPassword())){
            bean.setStatus(RequestBean.STATUS_SUCCESS);
            bean.setMsg("登录成功");
            User respUser = new User();
            respUser.setId(user.getId());
            respUser.setName(user.getName());
            bean.setData(respUser);
        }else{
            bean.setStatus(RequestBean.STATUS_FAILED);
            bean.setMsg("密码错误");
        }
        return new Gson().toJson(bean);
    }

    /**用户名重复性校验*/
    @RequestMapping("/check")
    public String checkUserName(String username) throws Exception{
        RequestBean<User> bean = new RequestBean<User>();
        User user = userMapper.getByName(username);
        if(user == null){
            bean.setStatus(RequestBean.STATUS_SUCCESS);
            bean.setMsg("用户名可以使用");
        }else{
            bean.setStatus(RequestBean.STATUS_SUCCESS);
            bean.setMsg("用户名已经被使用");
        }
        return new Gson().toJson(bean);
    }

    /**注册*/
    @RequestMapping(value = "/signUp" , method = RequestMethod.GET)
    public String signUp(String name , String password) throws Exception {
        User user = userMapper.getByName(name);
        RequestBean<Object> bean = new RequestBean<Object>();
        if(user == null){
            user = new User();
            user.setName(name);
            user.setPassword(password);
            userMapper.save(user);
            bean.setStatus(RequestBean.STATUS_SUCCESS);
            bean.setMsg("注册成功");
        }else{
            bean.setStatus(RequestBean.STATUS_SUCCESS);
            bean.setMsg("用户已经注册");
        }
        return new Gson().toJson(bean);
    }


    /**修改密码*/
    @RequestMapping(value = "/newPassword" , method = RequestMethod.GET)
    public String newPassword(String name , String password) throws Exception {
        User user = userMapper.getByName(name);
        RequestBean<Object> bean = new RequestBean<Object>();
        if(user == null){
            bean.setStatus(RequestBean.STATUS_SUCCESS);
            bean.setMsg("用户不存在");
        }else{
            user.setName(name);
            user.setPassword(password);
            userMapper.update(user);
            bean.setStatus(RequestBean.STATUS_SUCCESS);
            bean.setMsg("修改密码成功");
        }
        return new Gson().toJson(bean);
    }

}
