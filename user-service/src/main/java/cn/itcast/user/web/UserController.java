package cn.itcast.user.web;

import cn.itcast.user.config.Datepattent;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RefreshScope
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Datepattent datepattent;

//    @Value("${pattern.dateformate}")
//    private String timepattern;
    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }

    //获取当前时间
    @GetMapping("/time")
    public String gettime() {
                return LocalDateTime.now().format(DateTimeFormatter.ofPattern(datepattent.getDateformate()));
    }
    //测试获取本地和nacos配置
    @GetMapping("/yml")
    public Datepattent getyml() {
        return datepattent;
    }
}
