package cn.itcast.order.service;

import cn.itcast.feign.UserFeign;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserFeign userFeign;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

        // 2.实用外部调用查询用户信息

//        String url= "http://userservice/user/"+order.getUserId();
//        User user = restTemplate.getForObject(url, User.class);
        User user = userFeign.getbyId(order.getUserId());

        // 3.将用户信息放到请求实体中
        order.setUser(user);
        // 4.返回
        return order;
    }
}
