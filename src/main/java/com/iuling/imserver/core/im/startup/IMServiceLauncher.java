package com.iuling.imserver.core.im.startup;

import com.iuling.imserver.core.im.ServerLauncher;
import com.iuling.imserver.core.im.listener.OnMsgReceivedListener;
import com.iuling.imserver.core.im.listener.OnSendReceiptListener;
import com.iuling.imserver.core.im.qos.QoS4SendDaemonS2C;
import com.iuling.imserver.core.im.utils.ServerToolKits;

import java.io.IOException;

public class IMServiceLauncher extends ServerLauncher {

    private static IMServiceLauncher instance;

    public static IMServiceLauncher getInstance() throws IOException{
        if(instance == null)
        {
            // 设置AppKey
            ServerLauncher.appKey = "5418023dfd98c579b6001741";
            IMServiceLauncher.debug = true;
            IMServiceLauncher.PORT = 7901;
            ServerToolKits.setSenseMode(ServerToolKits.SenseMode.MODE_10S);
            instance = new IMServiceLauncher();
        }
        return instance;
    }

    public IMServiceLauncher() throws IOException {
        super();
    }

    @Override
    protected void initListeners() {
        this.setServerEventListener(new OnMsgReceivedListener());
        this.setServerMessageQoSEventListener(new OnSendReceiptListener());
    }
}
