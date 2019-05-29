package com.example.a0.myapplication.utils;

import android.os.Environment;


import java.io.File;

/**
 * Created by $lzj on 2019/5/5.
 */
public interface AppConstants {

    public static final int TYPE_ZHIHU= 0;
    public static final int TYPE_WECHAT= 1;
    public static final int TYPE_GANK= 2;
    public static final int TYPE_GOLD= 3;
    public static final int TYPE_V2EX= 4;
    public static final int TYPE_COLLECT= 5;
    public static final int TYPE_SETTINGS= 6;
    public static final int TYPE_ABOUT= 7;
    public static final int SEARCH = 8;

    String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() +
            File.separator + "code" + File.separator + "GeekNews";

    String FILE_PROVIDER_AUTHORITY="com.baidu.geek.fileprovider";

    //网络缓存的地址
    String PATH_DATA = BaseApp.getInstance().getCacheDir().getAbsolutePath() +
            File.separator + "data";

    String PATH_CACHE = PATH_DATA + "/NetCache";

}
