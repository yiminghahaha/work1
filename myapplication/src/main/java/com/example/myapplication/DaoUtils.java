package com.example.myapplication;

import com.example.myapplication.dao.DaoMaster;
import com.example.myapplication.dao.DaoSession;
import com.example.myapplication.dao.StudentDao;

public class DaoUtils {
    private  static  DaoUtils daoUtils;
    private final StudentDao studentDao;

    private DaoUtils() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(App.getApp(), "ddd");
        DaoMaster master = new DaoMaster(helper.getWritableDatabase());
        DaoSession session = master.newSession();
        studentDao = session.getStudentDao();
    }

    public static DaoUtils getDaoUtils() {
        if (daoUtils==null){
            synchronized (DaoUtils.class){
                if (daoUtils==null){
                    daoUtils = new DaoUtils();
                }
            }
        }
        return daoUtils;
    }

    public  void  insertAll(Student student){
        studentDao.insert(student);
    }
}
