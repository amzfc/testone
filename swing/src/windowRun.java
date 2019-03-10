public class windowRun {

    public static void main(String[] args){

        windowTicke w=new windowTicke();
        Thread t1=new Thread(w);
        Thread t2=new Thread(w);
        Thread t3=new Thread(w);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();

    }
}

class  windowTicke implements  Runnable{
    int ticket =100;
    Object obj= new Object();
    public void  run(){
        while (true) {
            synchronized (obj) {

                if (ticket != 0) {
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "售票编号:" + ticket--);
                }
           }
            }
    }


    }
