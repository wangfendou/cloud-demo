package cn.itcast.feign;

import cn.itcast.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("userservice")
public interface UserFeign {
@GetMapping("user/{id}")
User getbyId(@PathVariable Long id);
}
