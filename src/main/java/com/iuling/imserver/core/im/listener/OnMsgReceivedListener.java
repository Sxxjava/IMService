package com.iuling.imserver.core.im.listener;

import com.iuling.imserver.core.im.event.ServerEventListener;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OnMsgReceivedListener implements ServerEventListener {

    private Logger logger = LoggerFactory.getLogger(OnMsgReceivedListener.class);
    // 用户身份验证回调方法定义
    // 服务端的应用层可在本方法中实现用户登陆验证。详细请参见API文档说明。
    @Override
    public int onVerifyUserCallBack(String userId, String token, String extra, IoSession session) {
        logger.debug("正在调用回调方法：OnVerifyUserCallBack...");
        return 0;
    }

    // 用户登录验证成功后的回调方法定义
    // 服务端的应用层通常可在本方法中实现用户上线通知等。详细请参见API文档说明。
    @Override
    public void onUserLoginAction_CallBack(String userId, String extra, IoSession session) {
        logger.debug("正在调用回调方法：OnUserLoginAction_CallBack...");
    }

    // 用户退出登录回调方法定义。
    // 服务端的应用层通常可在本方法中实现用户下线通知等。详细请参见API文档说明。
    @Override
    public void onUserLogoutAction_CallBack(String userId, Object obj, IoSession session) {
        logger.debug("正在调用回调方法：OnUserLogoutAction_CallBack...");
    }

    // 通用数据回调方法定义（客户端发给服务端的（即接收user_id=0））
    // 上层通常可在本方法中实现如：添加好友请求等业务实现。详细请参见API文档说明。
    @Override
    public boolean onTransBuffer_CallBack(String userId, String from_user_id, String dataContent, String fingerPrint, int typeu, int typem,IoSession session) {
        logger.debug("收到了客户端"+from_user_id+"发给服务端的消息：str="+dataContent);
        return true;
    }

    // 通道数据回调函数定义（客户端发给客户端的（即接收user_id>0））。详细请参见API文档说明。
    // 上层通常可在本方法中实现用户聊天信息的收集，以便后期监控分析用户的行为等^_^。
    @Override
    public void onTransBuffer_C2C_CallBack(String userId, String from_user_id, String dataContent, String fingerPrint, int typeu, int typem) {
        logger.debug("收到了客户端"+from_user_id+"发给客户端"+userId+"的消息：str="+dataContent + ",消息类型:"+typem);
    }

    // 通用数据实时发送失败后的回调函数定义（客户端发给客户端的（即接收user_id>0））
    // 开发者可在此方法中处理离线消息的保存等。详细请参见API文档说明。
    @Override
    public boolean onTransBuffer_C2C_RealTimeSendFaild_CallBack(String userId, String from_user_id, String dataContent, String fingerPrint, int typeu, int typem) {
        logger.debug("客户端"+from_user_id+"发给客户端"+userId+"的消息：str="+dataContent
                +"因实时发送没有成功，需要上层应用作离线处理哦，否则此消息将被丢弃.");
        return false;
    }

}
