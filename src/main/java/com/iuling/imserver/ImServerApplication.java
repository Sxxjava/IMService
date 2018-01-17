package com.iuling.imserver;

//import com.iuling.imserver.core.im.protocal.Protocal;
import com.iuling.imserver.core.im.startup.IMServiceLauncher;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.io.IOException;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.iuling.imserver.**.mapper")
public class ImServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImServerApplication.class, args);
		try {
			IMServiceLauncher.getInstance().startup();
			LoggerFactory.getLogger(ImServerApplication.class).debug("IM服务器已启动!单个消息长度请控制在390字节内");
//			Protocal protocal = new Protocal(0," ","18370979059","18370979059",true,null,1);
//			System.out.println(protocal.toGsonString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
