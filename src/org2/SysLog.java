package org2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;

/**
 * Created by jingbao on 18-2-1.
 */
public class SysLog {
    public static void info(String massage)  {
        writeToToday("INFO:",massage);
        

    }
    public static void warning(String massage){
        writeToToday("warn:  ",massage);
    }
    public static void error(String massage){
        writeToToday("error:  ",massage);
    }

    private static void writeToToday(String flag, String massage) {
//        Date nowTime = new Date(System.currentTimeMillis());
//        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd");
//        String retStrFormatNowDate = sdFormatter.format(nowTime);
        RandomAccessFile raf=null;
        Calendar now=Calendar.getInstance();
        String yyyy=String.valueOf(now.get(Calendar.YEAR));
        String mm=String.valueOf(now.get(Calendar.MONTH)+1);
        String dd=String.valueOf(now.get(Calendar.DAY_OF_MONTH));
        String hh=String.valueOf(now.get(Calendar.HOUR_OF_DAY));
        String ff=String.valueOf(now.get(Calendar.MINUTE));
        String ss=String.valueOf(now.get(Calendar.SECOND));
        mm=(1==mm.length())?("0"+mm):mm;
        dd=(1==dd.length())?("0"+dd):dd;
        hh=(1==hh.length())?("0"+hh):hh;
        ff=(1==ff.length())?("0"+ff):ff;
        ss=(1==ss.length())?("0"+ss):ss;
        String yyyymmdd=yyyy+mm+dd;
        String hhffss=hh+ff+ss;
        String path=System.getProperties().getProperty("user.dir")+ File
                .separator+"log";
        File p=new File(path);
        if(!p.exists()){
            p.mkdirs();
        }
        path+=File.separator+"jPOINTmap_"+yyyymmdd+".log";
        File f=new File(path);
        if(f.isDirectory()){
            f.delete();
        }
        try {
            raf=new RandomAccessFile(f,"rw");
            raf.seek(raf.length());
            raf.writeBytes(hhffss+"  "+flag+":"+massage+"\r\n");
            raf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
