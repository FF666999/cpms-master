package com.cpms.single;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author gulang
 * @Description:
 * @time: 2021/11/24 21:38
 */
@SpringBootApplication
public class CpmsApplication {
    public static void main(String[] args)
    {
        try {
            SpringApplication.run(CpmsApplication.class, args);
            System.out.println("(♥◠‿◠)ﾉﾞ  Cpms服务启动成功   ლ(´ڡ`ლ)ﾞ");
        }catch(Throwable e) {
            e.printStackTrace();
        }
    }
}
