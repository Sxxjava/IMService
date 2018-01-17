package com.iuling.imserver.core.im.qos;

public class QoS4SendDaemonS2C extends QoS4SendDaemonRoot
{
	private static QoS4SendDaemonS2C instance = null;
	
	public static QoS4SendDaemonS2C getInstance()
	{
		if(instance == null)
			instance = new QoS4SendDaemonS2C();
		return instance;
	}
	
	private QoS4SendDaemonS2C()
	{
		super(0 // QoS质量保证线程心跳间隔（单位：毫秒），本参数<=0表示使用父类的默认值
			, 0 // “刚刚”发出的消息阀值定义（单位：毫秒），本参数<=0表示使用父类的默认值
			, -1// 一个包允许的最大重发次数，本参数<0表示使用父类的默认值
			, true
			, "-本机QoS");
	}
}
