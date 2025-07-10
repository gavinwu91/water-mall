package com.netsdk.esct;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.jcraft.jsch.JSchException;
import com.netsdk.lib.NetSDKLib;
import com.netsdk.lib.ToolKits;
import com.netsdk.util.DBUtil;
import com.netsdk.util.SftpUtil;
import com.netsdk.util.SftpUtilPool;
import com.sun.jna.Pointer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName AnalyzerDataCB
 * @Desc TODO
 * @Author Gavin
 * @Date 0005/2025/5/5 12:07
 * @Version 1.0
 **/
@Slf4j
public class CommonAnalyzerDataCB implements NetSDKLib.fAnalyzerDataCallBack {
    private File picturePath;
    public static String ip;
    public static String cameraName;
    static ResultSet res = null;
    Map<String,CameraEntity> cameraMap = new HashMap<>();
    ReentrantLock lock = new ReentrantLock();
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    SftpUtilPool sftpUtilPool = new SftpUtilPool(5);
    public CommonAnalyzerDataCB(Map<String,CameraEntity> cameraMap) throws JSchException {
        picturePath = new File("./AnalyzerPicture/");
        if (!picturePath.exists()) {
            picturePath.mkdir();
        }
        this.cameraMap = cameraMap;

    }

    // 回调
    public int invoke(NetSDKLib.LLong lAnalyzerHandle, int dwAlarmType, Pointer pAlarmInfo,
                      Pointer pBuffer, int dwBufSize, Pointer dwUser, int nSequence, Pointer reserved){
        long cameraId = Pointer.nativeValue(dwUser);

        System.out.println("触发事件----- dwAlarmType ===="+dwAlarmType+" 处理的设备ID ==== "+cameraId);
        if (lAnalyzerHandle == null || lAnalyzerHandle.longValue() == 0) {
            return -1;
        }
        ThreadPoolExecutor executor = (ThreadPoolExecutor)executorService;
        System.out.println(" poolsize ===="+executor.getPoolSize() +
                " Activecount ===="+executor.getActiveCount() +
                " queueSize  ===="+executor.getQueue().size() +
                " completed ===="+executor.getActiveCount()
        );
        DateTime date = DateUtil.date();
//        java.sql.Date alarmTime = new java.sql.Date(date.getTime());
        Timestamp alarmTime = new Timestamp(date.getTime());
        String msgUtc = DateUtil.format(date, DatePattern.NORM_DATETIME_FORMATTER);
        String dayDir = DateUtil.format(date, DatePattern.PURE_DATE_PATTERN);
        switch (dwAlarmType) {

            case NetSDKLib.EVENT_IVS_RIOTERDETECTION: ///< 聚众事件
            {
                NetSDKLib.DEV_EVENT_RIOTERL_INFO msg = new
                        NetSDKLib.DEV_EVENT_RIOTERL_INFO();
                ToolKits.GetPointerData(pAlarmInfo, msg);
                Msg msg2 = new Msg(msgUtc,msg.nChannelID+"","","",alarmTime);
                executorService.execute( () -> {
                    System.out.println(Thread.currentThread().getName()+" 执行插入聚众事件");
                    saveInfo(pBuffer,pAlarmInfo,dwBufSize,dayDir,"rioterDetection",4,msg2,cameraId,"10");
                });
                break;
            }

            case NetSDKLib.EVENT_IVS_CROSSLINEDETECTION: // 警戒线事件
            {
                NetSDKLib.DEV_EVENT_CROSSLINE_INFO msg = new
                        NetSDKLib.DEV_EVENT_CROSSLINE_INFO();
                ToolKits.GetPointerData(pAlarmInfo, msg);
                Msg msg2 = new Msg(msgUtc,msg.nChannelID+"",msg.stuObject.stuStartTime+"",msg.stuObject.stuEndTime+"",alarmTime);
                executorService.execute( () -> {
                    System.out.println(Thread.currentThread().getName()+" 执行插入警戒线事件");
                    saveInfo(pBuffer,pAlarmInfo,dwBufSize,dayDir,"crossLineDetection",1,msg2,cameraId,"10");
                });
                break;
            }
            case NetSDKLib.EVENT_IVS_CROSSREGIONDETECTION: ///< 警戒区事件
            {
                NetSDKLib.DEV_EVENT_CROSSREGION_INFO msg = new
                        NetSDKLib.DEV_EVENT_CROSSREGION_INFO();
                ToolKits.GetPointerData(pAlarmInfo, msg);
                Msg msg2 = new Msg(msgUtc,msg.nChannelID+"",msg.stuObject.stuStartTime+"",msg.stuObject.stuEndTime+"",alarmTime);
                executorService.execute( () -> {
                    System.out.println(Thread.currentThread().getName()+" 执行插入警戒区事件");
                    saveInfo(pBuffer,pAlarmInfo,dwBufSize,dayDir,"crossRegionDetection",2,msg2,cameraId,"10");
                });
                break;
            }

            case NetSDKLib.EVENT_IVS_WANDERDETECTION: ///< 徘徊事件
            {
                NetSDKLib.DEV_EVENT_WANDER_INFO msg = new
                        NetSDKLib.DEV_EVENT_WANDER_INFO();
                ToolKits.GetPointerData(pAlarmInfo, msg);
                Msg msg2 = new Msg(msgUtc,msg.nChannelID+"","","",alarmTime);
                executorService.execute( () -> {
                    System.out.println(Thread.currentThread().getName()+" 执行插入徘徊事件");
                    saveInfo(pBuffer,pAlarmInfo,dwBufSize,dayDir,"wanderDetection",3,msg2,cameraId,"10");
                });
                break;
            }

            case NetSDKLib.EVENT_IVS_MOVEDETECTION: ///< 移动事件
            {
                NetSDKLib.DEV_EVENT_MOVE_INFO msg = new
                        NetSDKLib.DEV_EVENT_MOVE_INFO();
                ToolKits.GetPointerData(pAlarmInfo, msg);
                Msg msg2 = new Msg(msgUtc,msg.nChannelID+"",msg.stuObject.stuStartTime+"",msg.stuObject.stuEndTime+"",alarmTime);
                executorService.execute( () -> {
                    System.out.println(Thread.currentThread().getName()+" 执行插入移动事件");
                    saveInfo(pBuffer,pAlarmInfo,dwBufSize,dayDir,"moveDetection",5,msg2,cameraId,"10");
                });
                break;
            }

            case NetSDKLib.EVENT_IVS_FIGHTDETECTION: ///< 斗殴事件
            {
                NetSDKLib.DEV_EVENT_FIGHT_INFO msg = new
                        NetSDKLib.DEV_EVENT_FIGHT_INFO();
                ToolKits.GetPointerData(pAlarmInfo, msg);
                System.out.println("发生斗殴事件"+ JSONUtil.toJsonStr(msg));
                Msg msg2 = new Msg(msgUtc,msg.nChannelID+"","","",alarmTime);
                executorService.execute( () -> {
                    System.out.println(Thread.currentThread().getName()+" 执行插入斗殴事件");
                    saveInfo(pBuffer,pAlarmInfo,dwBufSize,dayDir,"fightDetection",6,msg2,cameraId,"10");
                });
                break;
            }
            case NetSDKLib.EVENT_IVS_FIREWARNING: // 检测到火警
            {
                NetSDKLib.DEV_EVENT_FIREWARNING_INFO msg = new
                        NetSDKLib.DEV_EVENT_FIREWARNING_INFO();
                ToolKits.GetPointerData(pAlarmInfo, msg);
                System.out.println("火警事件发生! 火警信息==== "+JSONUtil.toJsonStr(msg));
                Msg msg2 = new Msg(msgUtc,msg.nChannelID+"","","",alarmTime);
                executorService.execute( () -> {
                    System.out.println(Thread.currentThread().getName()+" 执行插入火警事件");
                    saveInfo(pBuffer,pAlarmInfo,dwBufSize,dayDir,"fireWarning",7,msg2,cameraId,"30");
                });
                break;
            }
        }
        return 1;
    }

    @Data
    @AllArgsConstructor
    private class Msg{
        private String utc;
        private String channelId;
        private String startTime;
        private String endTime;
//        private java.sql.Date alarmTime;
        private Timestamp alarmTime;

    }

    public void saveInfo(Pointer pBuffer,Pointer pAlarmInfo,int dwBufSize,String dayDir,String eventName,Integer eventType,Msg msg,long cameraId,String source){
        /*NetSDKLib.DEV_EVENT_CROSSREGION_INFO msg = new
                NetSDKLib.DEV_EVENT_CROSSREGION_INFO();
        ToolKits.GetPointerData(pAlarmInfo, msg);
        NetSDKLib.NET_TIME_EX utc = msg.UTC;*/
        NetSDKLib.NET_EVENT_FILE_INFO stuFileInfo = null;
        NetSDKLib.NET_PIC_INFO stPicInfo = null;
        String img = System.currentTimeMillis() + ".jpg";
        String Picture = picturePath + "\\" + img;
        try {

//            ToolKits.savePicture(pBuffer, 0, dwBufSize, Picture);
            //上传到远程服务器
            System.out.println("上传文件开始");
            long fileBeginTime = System.currentTimeMillis();
            SftpUtil.upload(dayDir,pBuffer.getByteArray(0, dwBufSize),img);
            //sftpUtilPool.upload(dayDir,pBuffer.getByteArray(0, dwBufSize),img);
            System.out.println("文件上传结束 耗时==="+ (System.currentTimeMillis() - fileBeginTime) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(eventName + " 时间(UTC)：" + msg.utc + " 通道号:" + msg.channelId + " 开始时间:" + msg.startTime + " 结束时间:" + msg.endTime);
        try {
            save(StrUtil.join("/",dayDir,img),eventName,""+msg.utc,msg.channelId+"",cameraMap.get(String.valueOf(cameraId)).getIp(),eventType,cameraMap.get(String.valueOf(cameraId)).getCameraName(),source,msg.getAlarmTime());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public void save(String picName, String eventName, String time, String channelName, String ip, Integer eventType, String cameraName, String source, Timestamp alarmTime) throws SQLException {
        long saveDataTime = System.currentTimeMillis();
        System.out.println("保存数据开始");
//        Connection conn = null;
//        PreparedStatement pre = null;
        String sql ="INSERT INTO EVENT_RECORD (ID,PIC_NAME,EVENT_NAME,TIME,CHANNEL_NAME,IP,EVENT_TYPE,CAMERA_NAME,SOURCE,ALARM_TIME) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = DBUtil.getDataSource().getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)
        ){
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@192.168.88.171:1521:orcl";
            pre.setString(1, UUID.randomUUID().toString().replaceAll("-",""));
            pre.setString(2, picName);
            pre.setString(3, eventName);
            pre.setString(4, time);
            pre.setString(5, channelName);
            pre.setString(6, ip);
            pre.setInt(7, eventType);
            pre.setString(8, cameraName);
            pre.setString(9, source);
            pre.setTimestamp(10, alarmTime);
            pre.executeUpdate();
            System.out.println("数据保存结束 耗时==="+ (System.currentTimeMillis() - saveDataTime) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}