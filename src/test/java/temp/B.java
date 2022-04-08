package temp;

public class B extends A{
       void m1() {    	   
    	   System.out.println("I m in B");
       }
       
       void show() {
    	  m1();
    	   
       }
   	public static void main(String[] args) {
          B bobj=new B();
          bobj.show();   
   	}
}
