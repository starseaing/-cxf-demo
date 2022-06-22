package com.example.cxf001jaxwsserver;

import com.example.cxf001jaxwsserver.cxf.IUserService;
import com.example.cxf001jaxwsserver.cxf.MessageInterceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.phase.Phase;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientTest {
    @Test
    public void test(){
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(IUserService.class);
        jaxWsProxyFactoryBean.setAddress("http://localhost:9999/userService?wsdl");

        jaxWsProxyFactoryBean.getInInterceptors().add(new LoggingInInterceptor());
        jaxWsProxyFactoryBean.getOutFaultInterceptors().add(new LoggingOutInterceptor());

        jaxWsProxyFactoryBean.getInInterceptors().add(new MessageInterceptor(Phase.RECEIVE));
        jaxWsProxyFactoryBean.getOutInterceptors().add(new MessageInterceptor(Phase.SEND));

        IUserService userService = (IUserService) jaxWsProxyFactoryBean.create();
        String result = userService.sayHello("小明");
        System.out.println(result);
    }
}
