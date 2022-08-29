package com.cpms.single;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author gulang
 * @Description:
 * @time: 2021/12/4 12:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CpmsTestApplication {
    /**
     * jasypt加解密代码
     */
    @Test
    public void jasyptEncrypt(){
        // 默认加密/解密算法是 PBEWithMD5AndDES
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("123456");// 密钥
        System.out.println("password---:"+encryptor.encrypt("123456")); // 要加密的数据
        System.out.println("username---:"+encryptor.encrypt("user")); // 要加密的数据
        System.out.println("jdbc-url---:"+encryptor.encrypt("jdbc:mysql://127.0.0.1:3306/cpms-cloud?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai")); // 要加密的数据
        System.out.println("redis---:"+encryptor.encrypt("127.0.0.1:6379")); // 要加密的数据
    }
}
