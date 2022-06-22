package com.example.cxf001jaxwsserver.cxf;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;

@Slf4j
public class MessageInterceptor extends AbstractPhaseInterceptor<Message> {

    public MessageInterceptor(String phase) {
        super(phase);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        log.info("############handleMessage##########");

        if (message.getDestination() != null) {
            log.info(message.getId() + "#" + message.getDestination().getMessageObserver());
        }
        if (message.getExchange() != null) {
            log.info(message.getExchange().getInMessage() + "#" + message.getExchange().getInFaultMessage());
            log.info(message.getExchange().getOutMessage() + "#" + message.getExchange().getOutFaultMessage());
        }
    }
}
