import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.net.*;
import java.util.Enumeration;

public class Test extends JFrame
{

    private JLabel label = new JLabel();
    private JLabel labelIp=new JLabel();

    private  static  int time = 0;

    Test() {
        JFrame jf=new JFrame();    //创建一个JFrame对象
        JPanel jp=new JPanel();    //创建一个JPanel对象
        jp.setLayout(new BorderLayout()); //为面板设置布局为BorderLayout
        label.setFont(new Font("楷体",Font.BOLD,300)); //设置标签字体大小
        label.setForeground(Color.blue);//设置标签字体颜色
        label.setHorizontalAlignment(SwingConstants.CENTER);  //lable1内容居中显示
        labelIp.setFont(new Font("楷体",Font.BOLD,50)); //设置标签字体大小
        labelIp.setHorizontalAlignment(SwingConstants.RIGHT);   //labe2内容居右显示
        jp.setBackground(Color.white);    //设置背景色
        jp.add(label,BorderLayout.CENTER);    //将标签添加到面板,居中显示
        jp.add(labelIp,BorderLayout.SOUTH);     //将标签添加到面板,居南显示
        jf.add(jp);    //将面板添加到窗口
        jf.setUndecorated(true);
       jf.setSize(500,300);
       //GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(jf); //窗口最大化

       if(time>30){
           label.setForeground(Color.blue);//设置标签字体蓝色颜色
           new Thread(new MyThread()).start();
       }else if(time<=30){
           label.setForeground(Color.red);//设置标签字体红色颜色
           new Thread(new MyThread()).start();
       }
        jf.setVisible(true);    //设置窗口可见
    }
    //线程
    class MyThread implements Runnable
    {
        public void run() {
            while (time > 0)
            {
                time--;
                label.setText("0:"+time + "");
                try {
                    labelIp.setText(getLocalIpv4Address());
                } catch (SocketException e) {
                    e.printStackTrace();
                }
                try
                {
                    Thread.sleep(1000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            Test.this.dispose();
        }
    };
    public static void main(String[] args)
    {
        dataTOint("00:00:60"); //传输过来的时间数据转换为整数
        new Test();
    }
    public  String getLocalIpv4Address() throws SocketException {
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

    //传输过来的时间数据转换为整数
    public static int dataTOint(String data){
        String s[] =null;
        s= data.split(":");
        int [] count = new int[3] ;
        for(int i=0;i<3;i++){
            count[i]=Integer.parseInt(s[i]);
        }
        //pow() 方法可返回 x 的 y 次幂的值
        time=time+count[0]*(int)Math.pow(60, 2)+count[1]*(int)Math.pow(60, 1)+count[2];//计算总秒数
        return  time ;
    }


}


