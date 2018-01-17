package com.iuling.imserver.core.im.listener;

import com.iuling.imserver.core.im.event.MessageQoSEventListenerS2C;
import com.iuling.imserver.core.im.protocal.Protocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class OnSendReceiptListener implements MessageQoSEventListenerS2C {

    private Logger logger = LoggerFactory.getLogger(OnMsgReceivedListener.class);

    @Override
    public void messagesLost(ArrayList<Protocal> lostMessages) {
        logger.debug("【QoS_S2C事件】收到系统的未实时送达事件通知，当前共有"
                +lostMessages.size()+"个包QoS保证机制结束，判定为【无法实时送达】！");
    }

    @Override
    public void messagesBeReceived(String theFingerPrint) {
        if(theFingerPrint != null)
        {
            logger.debug("【QoS_S2C事件】收到对方已收到消息事件的通知，fp="+theFingerPrint);
        }
    }
}
