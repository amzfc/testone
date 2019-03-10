
import java.net.SocketException;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

import java.net.InetAddress;
import java.util.Collections;
import java.net.NetworkInterface;
import java.util.Enumeration;


public class NetUtil {

   /* public static ArrayList<String> getLocalIpAddr() {
        ArrayList<String> ipList = new ArrayList<String>();
        InetAddress[] addrList;
        try {
            Enumeration interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) interfaces.nextElement();
                Enumeration ipAddrEnum = ni.getInetAddresses();
                while (ipAddrEnum.hasMoreElements()) {
                    InetAddress addr = (InetAddress) ipAddrEnum.nextElement();
                    if (addr.isLoopbackAddress() == true) {
                        continue;
                    }

                    String ip = addr.getHostAddress();
                    if (ip.indexOf(":") != -1) {
                        //skip the IPv6 addr
                        continue;
                    }


                    ipList.add(ip);
                }
            }

            Collections.sort(ipList);
        } catch (Exception e) {
            e.printStackTrace();

            throw new RuntimeException("Failed to get local ip list");
        }

        return ipList;
    }

    public static void getLocalIpAddr(Set<String> set) {
        ArrayList<String> addrList = getLocalIpAddr();
        set.clear();
        for (String ip : addrList) {
            set.add(ip);
        }
    }*/

    public static void main(String args[]) {
        /*//ArrayList<String> addrList = getLocalIpAddr();
        HashSet<String> addrSet = new HashSet<String>();
        getLocalIpAddr(addrSet);
        for (String ip : addrSet)
        {
            System.out.println("Local ip:" + ip);
        }
    }*/


        StringBuilder sb = new StringBuilder();
        try {
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();//获取本地所有网络接口
            while (en.hasMoreElements()) {//遍历枚举中的每一个元素
                NetworkInterface ni = (NetworkInterface) en.nextElement();
                Enumeration<InetAddress> enumInetAddr = ni.getInetAddresses();
                while (enumInetAddr.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) enumInetAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress()
                            && inetAddress.isSiteLocalAddress()) {
                        sb.append("name:" + inetAddress.getHostName().toString() + "\n");
                        sb.append("ip:" + inetAddress.getHostAddress().toString() + "\n");
                    }
                }
            }
        } catch (SocketException e) {
        }
        System.out.println(sb.toString());
    }
}