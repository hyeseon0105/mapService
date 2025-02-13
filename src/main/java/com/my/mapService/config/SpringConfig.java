package com.my.mapService.config;

import com.my.mapService.repository.MapMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MapMemberRepository memberRepository(){
        return new MapMemberRepository();
    }
}
