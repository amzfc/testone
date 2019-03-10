import javax.swing.*;
import java.awt.*;
public class Main
{
    public static void main(String[] agrs)
    {
        JFrame jf=new JFrame();    //创建一个JFrame对象
        JPanel jp=new JPanel();    //创建一个JPanel对象
        jp.setLayout(new BorderLayout()); //为面板设置布局为BorderLayout
        JLabel jl1=new JLabel("0:43");    //创建一个标签
        JLabel jl2=new JLabel("url");
        jl1.setFont(new Font("楷体",Font.BOLD,100)); //设置标签字体大小
        jl1.setForeground(Color.blue);//设置标签字体颜色
        jl2.setFont(new Font("楷体",Font.BOLD,23)); //设置标签字体大小
        jl1.setHorizontalAlignment(SwingConstants.CENTER);  //lable1内容居中显示
        jl2.setHorizontalAlignment(SwingConstants.RIGHT);   //labe2内容居右显示
        jp.setBackground(Color.white);    //设置背景色
        jp.add(jl1,BorderLayout.CENTER);    //将标签添加到面板,居中显示
        jp.add(jl2,BorderLayout.SOUTH);     //将标签添加到面板,居南显示
        jf.add(jp);    //将面板添加到窗口
        jf.setUndecorated(true); //去掉标题栏
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(jf); //最大化
        jf.setVisible(true);    //设置窗口可见
    }
}
