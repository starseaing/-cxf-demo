package com.example.cxf001jaxwsserver.cxf;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

/**
 * @WebService 使用类上面，标记类是 WebService 服务提供对象
 * @WebMethod 使用方法上面，标记方法 是 WebService 服务提供方法
 */
@WebService
public interface IUserService {
    @WebMethod
    public String sayHello(String str);
}
