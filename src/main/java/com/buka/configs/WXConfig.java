package com.buka.configs;

import com.github.wxpay.sdk.WXPay;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WXConfig {
    @Bean
    public WXPay getWXPay() throws Exception {
        MyConfig myConfig = new MyConfig();
      return  new WXPay(myConfig);

    }
}
