package cn.itcast.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignType {
    @Bean
    Logger.Level logger(){
        return Logger.Level.BASIC;
    }
}
