package com.nowcoder.community1.config;

import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;

/**
 * Created by a4229 on 2021/1/28 22:25.
 */
public class AlphaConfig {

    @Bean
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
