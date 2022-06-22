package com.example.cxf001jaxwsserver.cxf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserServiceImpl implements IUserService {

    public String sayHello(String name) {
        log.info("[sayHello] {}", name);
        return "Hello, " + name;
    }
}