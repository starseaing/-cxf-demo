package com.example.cxf001jaxwsserver;

import com.example.cxf001jaxwsserver.cxf.IUserService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientTest {
    @Test
    public void test(){
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(IUserService.class);
        jaxWsProxyFactoryBean.setAddress("http://localhost:9999/userService?wsdl");
        IUserService userService = (IUserService) jaxWsProxyFactoryBean.create();
        String result = userService.sayHello("小明");
        System.out.println(result);
    }
}
