package com.comleader.ldmapdownload.service;

import com.comleader.ldmapdownload.util.CLStringUtil;
import com.comleader.ldmapdownload.util.HttpUtil;

import java.io.File;

/**
 * @ClassName DownMapLv1
 * @Description: 下载第一层(全地图)
 * @Author zhanghang
 * @Date 2020/4/3
 * @Version V1.0
 **/
public class DownMapLv6 {

    private static int z = 6;

    /**
     * @description: 下载第四级的Map
     * @param
     * @return: void
     * @author: zhanghang
     * @date: 2020/4/3
     **/
    public static void downLoad() {
        new Thread(() -> {
            for (int x = 45; x <= 57; x++) { // Y轴
                for (int y = 20; y <= 28; y++) { // X轴
                    //高德地图(6：影像，7：矢量，8：影像路网)
                    String imgUrl = CLStringUtil.getImgUrl(z, x, y);
                    File file = CLStringUtil.getFullFile(z, x, y);
                    System.out.println(imgUrl);

                    // 开始下载地图
                    try {
                        HttpUtil.downImageByGet(imgUrl, file);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

}