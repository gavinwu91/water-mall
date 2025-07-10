package com.netsdk.esct;

import com.jcraft.jsch.JSchException;
import com.netsdk.demo.module.LoginModule;
import com.netsdk.lib.NetSDKLib;
import com.sun.jna.Pointer;

import javax.swing.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName CommonEvent
 * @Desc TODO
 * @Author Gavin
 * @Date 0008/2025/5/8 13:38
 * @Version 1.0
 **/
public class CommonEvent {
    private static Map<String,CameraEntity> cameraMap = new HashMap<>();
    public static void main(String[] args) throws JSchException {
        getCameraList();
        CommonAnalyzerDataCB analyzerCallback = new CommonAnalyzerDataCB(cameraMap);
        for(Map.Entry<String,CameraEntity> entry : cameraMap.entrySet()){
            String cameraId = entry.getKey();
            CameraEntity cameraEntity = entry.getValue();
            Task task = new Task(cameraEntity,analyzerCallback);
            new Thread(task).start();
        }
    }



    public static class Task implements Runnable{
        CameraEntity camera;
        CommonAnalyzerDataCB analyzerCallback;
        public Task(CameraEntity cameraEntity,CommonAnalyzerDataCB analyzerCallback){
            this.camera = cameraEntity;
            this.analyzerCallback = analyzerCallback;
        }
        @Override
        public void run() {
            LoginModule.init(new CommonEvent.DisConnect(),new CommonEvent.HaveReConnect());
            NetSDKLib.LLong lLong = LoginModule.loginRId(
                    camera.getIp(),
                    camera.getPort(),
                    camera.getUserName(),
                    camera.getPassword());
            NetSDKLib.LLong listenerHandle = LoginModule.netsdk.CLIENT_RealLoadPictureEx(lLong, 0, NetSDKLib.EVENT_IVS_ALL,
                    1, analyzerCallback, Pointer.createConstant(Integer.valueOf(camera.getId())), null);
            System.out.println("当前  "+camera.getCameraName()+"开始监听，登录句柄=="+lLong+"   "+"  监听句柄===="+listenerHandle);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.out.println("关闭程序，释放资源");
                LoginModule.logout();
                LoginModule.cleanup();
            }));
            try {
                new CountDownLatch(1).await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void getCameraList(){
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@192.168.88.171:1521:orcl";
            conn = DriverManager.getConnection(url,"angellinux","angelhot");
            String sql = "select * from camera_info where enable = 1";
            pre = conn.prepareStatement(sql);
            ResultSet resultSet = pre.executeQuery();
            while(resultSet.next()){
                CameraEntity cameraEntity = CameraEntity.builder()
                        .id(resultSet.getString("id"))
                        .ip(resultSet.getString("ip"))
                        .password(resultSet.getString("password"))
                        .userName(resultSet.getString("user_name"))
                        .port(resultSet.getInt("port"))
                        .cameraName(resultSet.getString("camera_name"))
                        .enable(resultSet.getInt("enable"))
                        .build();
                cameraMap.put(cameraEntity.getId(),cameraEntity);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try{
                if(pre != null){
                    pre.close();
                }
                if(conn != null) {
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }


    private static class DisConnect implements NetSDKLib.fDisConnect {
        public DisConnect() { }

        public void invoke(NetSDKLib.LLong m_hLoginHandle, String pchDVRIP, int nDVRPort, Pointer dwUser) {
            System.out.printf("Device[%s] Port[%d] DisConnect!\n", pchDVRIP, nDVRPort);

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                }
            });
        }
    }

    // device reconnect(success) callback class
    // set it's instance by call CLIENT_SetAutoReconnect, when device reconnect success sdk will call it.
    private static class HaveReConnect implements NetSDKLib.fHaveReConnect {
        public void invoke(NetSDKLib.LLong m_hLoginHandle, String pchDVRIP, int nDVRPort, Pointer dwUser) {
            System.out.printf("ReConnect Device[%s] Port[%d]\n", pchDVRIP, nDVRPort);
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {

                }
            });
        }
    }

}
