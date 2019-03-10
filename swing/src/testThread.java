public class testThread {


    public static void main(String[] args){

        printNum1 p1=new printNum1();
        printNum2 p2= new printNum2();

        p1.setName("线程1");
        //p1.setPriority(4);
        p2.setName("线程2");
        p1.start();
        //p1.run();
        p2.start();

    }
}
class printNum1 extends  Thread{

    public  void  run(){
        for (int i=0;i<100;i++){
            if (i%2 ==0){

                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class printNum2 extends  Thread{

    public  void  run(){
        for (int i=0;i<100;i++){
            if (i%2 !=0){

                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
