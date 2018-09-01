package org2;

/**
 * Created by jingbao on 18-2-1.
 */
public class Route {
    private String LocalIP=null;//端口映射保定的IP
    private int LocalPort=0;//端口号
    private String DestHost=null;//转发数据的目标机器的IP
    private int DestPort=0;//转发的目标端口
    private String AllowCline=null;

    public void setLocalIP(String localIP) {
        LocalIP = localIP;
    }

    public void setLocalPort(int localPort) {
        LocalPort = localPort;
    }

    public void setDestHost(String destHost) {
        DestHost = destHost;
    }

    public void setDestPort(int destPort) {
        DestPort = destPort;
    }

    public void setAllowCline(String allowCline) {
        AllowCline = allowCline;
    }

    public String getLocalIP() {
        return LocalIP;
    }

    public int getLocalPort() {
        return LocalPort;
    }

    public String getDestHost() {
        return DestHost;
    }

    public int getDestPort() {
        return DestPort;
    }

    public String getAllowCline() {
        return AllowCline;
    }

    @Override
    public String toString() {
//        return "Route{" +
//                 + '\'' +
//                ", LocalPort=" + LocalPort +
//                ", DestHost='" + DestHost + '\'' +
//                ", DestPort=" + DestPort +
//                ", AllowCline='" + AllowCline + '\'' +
//                '}';
        StringBuffer stb=new StringBuffer();
        stb.append("LocalIP='" + LocalIP);
        stb.append("LocalPort=" + LocalPort);
        stb.append("DestHost='" + DestHost);
        stb.append("DestPort=" + DestPort);
        stb.append("AllowCline='" + AllowCline);
        //stb.append("LocalPort=" + LocalPort);
        return stb.toString();
    }
    public Route(){}




}
