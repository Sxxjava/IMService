/*
 * Copyright (C) 2017  即时通讯网(52im.net) & Jack Jiang.
 * The MobileIMSDK_X (MobileIMSDK v3.x) Project. 
 * All rights reserved.
 * 
 * > Github地址: https://github.com/JackJiang2011/MobileIMSDK
 * > 文档地址: http://www.52im.net/forum-89-1.html
 * > 即时通讯技术社区：http://www.52im.net/
 * > 即时通讯技术交流群：320837163 (http://www.52im.net/topic-qqgroup.html)
 *  
 * "即时通讯网(52im.net) - 即时通讯开发者社区!" 推荐开源工程。
 * 
 * MessageQoSEventListenerS2C.java at 2017-5-2 15:49:28, code by Jack Jiang.
 * You can contact author with jack.jiang@52im.net or jb2011@163.com.
 */
package com.iuling.imserver.core.im.event;

import com.iuling.imserver.core.im.protocal.Protocal;

import java.util.ArrayList;

public interface MessageQoSEventListenerS2C
{
	void messagesLost(ArrayList<Protocal> lostMessages);
	void messagesBeReceived(String theFingerPrint);
}
