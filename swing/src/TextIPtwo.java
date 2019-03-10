import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class TextIPtwo {
    public static String getLocalIpv4Address() throws SocketException {
        // 获得本机的所有网络接口
        Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces();
        //正确的ip地址
        String siteLocalAddress = null;
        while (ifaces.hasMoreElements()) {
            NetworkInterface iface = ifaces.nextElement();
            // 获得与该网络接口绑定的 所有IP 地址.
            Enumeration<InetAddress> addresses = iface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress address = addresses.nextElement();
                String hostAddress = address.getHostAddress();
                /*instanceof Inet4Address判断是不是ipv4地址
                isLoopbackAddress()判断是不是回环地址
                */
                if (address instanceof Inet4Address
                        && !address.isLoopbackAddress()
                        && !hostAddress.startsWith("192.168")
                        && !hostAddress.startsWith("172.")
                        && !hostAddress.startsWith("169.")) {
                    //isSiteLocalAddress() 是否为地区本段地址
                    if (address.isSiteLocalAddress()) {
                        siteLocalAddress = hostAddress;
                    } else {
                        return hostAddress;
                    }
                }
            }
        }
        return siteLocalAddress == null ? "" : siteLocalAddress;
    }

    public static void main(String[] args) {

        try {
            System.out.println("local ip:" + getLocalIpv4Address());
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }
}
