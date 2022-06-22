package com.example.cxf001jaxwsserver;

import com.example.cxf001jaxwsserver.cxf.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Cxf001JaxWsServerFactoryBeanApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cxf001JaxWsServerFactoryBeanApplication.class, args);
        startWsService();
    }

    /**
     * https://cxf.apache.org/javadoc/latest/org/apache/cxf/jaxws/JaxWsServerFactoryBean.html
     */
    static void startWsService(){
        //发布的地址和服务名
        JaxWsServerFactoryBean jaxWsServerFactoryBean = new JaxWsServerFactoryBean();
        jaxWsServerFactoryBean.setAddress("http://localhost:9999/userService");
        jaxWsServerFactoryBean.setServiceClass(UserServiceImpl.class);
        Server server = jaxWsServerFactoryBean.create();
        server.start();
        log.info(">>>>>>>>开始服务>>>>>>>>");
    }
}
