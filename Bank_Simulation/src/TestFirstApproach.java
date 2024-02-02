import java.util.Date;
import javax.swing.*;
import java.awt.*;

public class TestFirstApproach
{
  FirstApproach W1,W2,W3;
  SecondStep Wout;

  static final int X=300;
  static final int Y=100;
  static final int STEPX=10;
  static final int STEPY=10;
  static final int LWIDTH=60;
  static final int LHIGTH=60;
  public TestFirstApproach()
  {
    W1=new FirstApproach(Wout.q,0);
    W2=new FirstApproach(Wout.q,1);
    W3=new FirstApproach(Wout.q,2);


    Wout=new SecondStep();
    W1.start();
    W2.start();
    W3.start();
    Wout.start();

  }//end of constructor

  public static Point UserQPos(int UserOrder, int WindowIndex) {
    Point p = new Point();
    p.x= X+(LWIDTH + STEPX) * (UserOrder + 1);
    p.y= Y+(STEPY+LHIGTH)*WindowIndex;
    return p;
  }

  public static Point UserQOutPos(int UserOrder) {
   Point p = new Point();
    p.x= 10+(LWIDTH + STEPX) * (UserOrder + 1);
    p.y=  Y+(STEPY+LHIGTH)*4;
    return p;
  }

  public void addUser(User user)
  {
    FirstApproach minApp=((FirstApproach)min(W1,W2,W3));
    minApp.q.enqueue(user);
    ((JLabel)BankSimulation.labels.get(user.id)).setLocation(X+(LWIDTH+STEPX)*
        (minApp.q.length),Y+(STEPY+LHIGTH)*minApp.index);
    ((JLabel)BankSimulation.labels.get(user.id)).show(true);
  }

  public static Object min(Object obj1,Object obj2)
  {
    if(  ((FirstApproach)obj1).q.length +((FirstApproach)obj1).doService
         <((FirstApproach)obj2).q.length +((FirstApproach)obj2).doService)
     return obj1;
   return obj2;
  }

  public static Object min(Object obj1,Object obj2,Object obj3)
  {
      return min(obj1,min(obj2,obj3));
  }

}
