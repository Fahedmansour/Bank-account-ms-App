package com.fahed.Customer.service.web;

import com.fahed.Customer.service.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {
    @Value("${global.params.p1}")
    private int p1;
    @Value("${global.params.p2}")
    private int p2;
    @Value("${customer.params.x}")
    private int x;
    @Value("${customer.params.y}")
    private int y;
    @Autowired
    private GlobalConfig globalConfig;
    @GetMapping("/testConfig")
    public Map<String,Integer> configTest(){
        return Map.of("P1",p1,"P2",p2,"X",x,"Y",y);
    }


    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }





}
