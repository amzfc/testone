public class test02 {
   private  static int second =0;

   public static int dataTOint(String data){
       String s[] =null;
       s= data.split(":");
       int [] count = new int[3] ;
       for(int i=0;i<3;i++){
           count[i]=Integer.parseInt(s[i]);
       }
       //pow() 方法可返回 x 的 y 次幂的值
       second=second+count[0]*(int)Math.pow(60, 2)+count[1]*(int)Math.pow(60, 1)+count[2];//计算总秒数
       return  second ;
   }
    public  static void main(String[] args)
    {
       /* String s[] =null;
        String data ="00:02:00";
        s= data.split(":");
        int [] count = new int[3] ;
        for(int i=0;i<3;i++){
          count[i]=Integer.parseInt(s[i]);
    }
       //pow() 方法可返回 x 的 y 次幂的值
        second=second+count[0]*(int)Math.pow(60, 2)+count[1]*(int)Math.pow(60, 1)+count[2];//计算总秒数
        System.out.println(second);
*/
       dataTOint("00:02:00");
        System.out.println(second);
    }


}
