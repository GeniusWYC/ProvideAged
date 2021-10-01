package com.provideaged.provideaged.controller;

import com.provideaged.provideaged.base.ResultData;
import com.provideaged.provideaged.entity.User;
import com.provideaged.provideaged.enums.ReturnCode;
import com.provideaged.provideaged.security.JwtUtil;
import com.provideaged.provideaged.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName: UserController
 * @Description: 用户controller
 * @author: 巫运辰
 * @date: 2021/08/26 17:46
 */
@RestController
@RequestMapping("API/User")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultData<String> login(@RequestBody User user) {
        // 判断账号密码是否正确，这一步肯定是要读取数据库中的数据来进行校验的，这里为了模拟就省去了
        if (userService.login(user)) {
            // 如果正确的话就返回生成的token（注意哦，这里服务端是没有存储任何东西的）
            return new ResultData<>(ReturnCode.RC1000, JwtUtil.generate(user.getUsername()));
        }
        return new ResultData<>(ReturnCode.RC1004);
    }

    @PostMapping("/createUser")
    public void createUser(@RequestBody @Valid User user) {
        userService.createUser(user);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody String username) {
        userService.deleteUser(username);
    }

    @GetMapping("/queryByRole")
    public List<User> queryByRole(@RequestParam short roleId,int pageNumber,int pageSize) {
        return userService.queryByRole(roleId,pageNumber,pageSize);
    }

    @GetMapping("/queryByUsername")
    public User queryByUsername(@RequestParam String username) {
        return userService.queryByUsername(username);
    }

    @PostMapping("/updateState")
    public void updateState(@RequestBody User user) {
        userService.updateState(user);
    }

    @PostMapping("/updatePassword")
    public void updatePassword(@RequestBody User user) {
        userService.updatePassword(user);
    }

}