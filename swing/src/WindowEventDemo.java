import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class WindowEventDemo extends JFrame implements WindowListener{

    @Override
    public void windowOpened(WindowEvent e) {
        //窗口首次打开时调用
        new Thread(new MyThread()).start();

    }

    @Override
    public void windowClosing(WindowEvent e) {
        //从系统菜单中关闭窗体时调用

        System.out.println("窗口关闭了");
        System.exit(-1);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //关闭窗体时调用  API: 因对窗口调用 dispose 而将其关闭时调用。
//			System.exit(-1);放在这里不能完全关闭程序   红点还是亮的
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //窗体变为最小化时调用
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //窗体变为正常状态事调用
    }


    @Override
    public void windowActivated(WindowEvent e) {
        //窗体被激活时调用

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // 当 Window 不再是活动 Window 时调用。
    }
    //WindowAdaptor类中的
/*		public void windowDeactivated(WindowEvent e) {
			// 当 Window 不再是活动 Window 时调用。
		}


		public void windowStateChanged(WindowEvent e) {
			//当窗口状态改变时调用。
		}


		public void windowGainedFocus(WindowEvent e) {
			//窗口获得焦点时调用

		}

		public void windowLostFocus(WindowEvent e) {
			//窗口失去焦点时调用
		}*/



    private JLabel label = new JLabel();
    private int time = 10;
    WindowEventDemo() {

        JPanel jp=new JPanel();    //创建一个JPanel对象
        jp.setLayout(new BorderLayout()); //为面板设置布局为BorderLayout

        label.setFont(new Font("楷体",Font.BOLD,30)); //设置标签字体大小
        label.setForeground(Color.blue);//设置标签字体颜色
        label.setHorizontalAlignment(SwingConstants.CENTER);  //lable1内容居中显示
        jp.add(label);
        add(jp);
        jp.setBackground(Color.white);    //设置背景色
        addWindowListener(this);
        setSize(500, 500);

        setLocationRelativeTo(null);//居中显示
        setVisible(true);
        this.setUndecorated(true); //去掉标题栏
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    class MyThread implements Runnable
    {
        public void run() {
            while (time > 0)
            {
                time--;
                label.setText(time + "");
                try
                {
                    Thread.sleep(1000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            WindowEventDemo .this.dispose();
        }
    };

    public static void main(String[] args) {
        new  WindowEventDemo();
    }
}
