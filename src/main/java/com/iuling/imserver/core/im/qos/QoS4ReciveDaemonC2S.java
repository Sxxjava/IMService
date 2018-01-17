package com.iuling.imserver.core.im.qos;

public class QoS4ReciveDaemonC2S extends QoS4ReciveDaemonRoot
{
	private static QoS4ReciveDaemonC2S instance = null;
	
	public static QoS4ReciveDaemonC2S getInstance()
	{
		if(instance == null)
			instance = new QoS4ReciveDaemonC2S();
		return instance;
	}
	
	public QoS4ReciveDaemonC2S()
	{
		super(0 // 检查线程执行间隔（单位：毫秒），本参数<=0表示使用父类的默认值
			, 0// 一个消息放到在列表中（用于判定重复时使用）的生存时长（单位：毫秒），本参数<=0表示使用父类的默认值
			, true
			, "-本机QoS");
	}
}
