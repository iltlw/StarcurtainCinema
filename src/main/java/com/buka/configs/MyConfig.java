package com.buka.configs;

import com.github.wxpay.sdk.IWXPayDomain;
import com.github.wxpay.sdk.WXPayConfig;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class MyConfig extends WXPayConfig {

    private byte[] certData;

    public MyConfig() throws IOException {
        InputStream certInputStream = Objects.requireNonNull(
                MyConfig.class.getClassLoader().getResourceAsStream("apiclient_cert.p12")
        );
        certData = new byte[certInputStream.available()];
        certInputStream.read(certData);
        certInputStream.close();
    }

    @Override
    public String getAppID() {
        return "wx796055a9a5d2822b";
    }

    @Override
    public String getMchID() {
        return "1617197168";
    }

    @Override
    public String getKey() {
        return "sahuan66sahuan66sahuan66sahuan66";
    }

    @Override
    public InputStream getCertStream() {
        return new ByteArrayInputStream(certData);
    }

    @Override
    public IWXPayDomain getWXPayDomain() {
        return new IWXPayDomain() {
            @Override
            public void report(String s, long l, Exception e) {
            }

            @Override
            public DomainInfo getDomain(WXPayConfig wxPayConfig) {
                return new DomainInfo("api.mch.weixin.qq.com", true);
            }
        };
    }
}
