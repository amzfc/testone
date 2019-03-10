import com.sun.org.apache.bcel.internal.generic.NEW;

public class bank {
  public  static  void main(String[] args){
      Account acct =new Account();
      Customer customer = new Customer(acct);
      Thread t1 = new Thread(customer);
      Thread t2 =new Thread(customer);

      t1.setName("用户1");
      t2.setName("用户2");
      t1.start();
      t2.start();

  }


}

 class Account {
     double balance; //余额

     public  Account(){}

     //存钱
     public synchronized void save( double amt){
          balance +=amt;
         try {
             Thread.currentThread().sleep(100);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println(Thread.currentThread().getName()+":"+balance);
     }
 }

  class  Customer implements Runnable{
      Account account;
      Object obj =new Object();

      public Customer(Account account){
          this.account=account;
      }

     public  void  run(){

          for (int i =0;i<3;i++){
              account.save(1000);

          }

     }
        }