import java.util.Date;
import javax.swing.*;
import java.awt.*;

public class TestApproach1
{
  Approach1 W1,W2,W3;
  SecondStep Wout;
  Date t=new Date();
  static final int X=300;
  static final int Y=100;
  static final int STEPX=10;
  static final int STEPY=10;
  static final int LWIDTH=60;
  static final int LHIGTH=60;
  public TestApproach1(User Users[])
  {
    W1=new Approach1(Wout.q,0);
    W2=new Approach1(Wout.q,1);
    W3=new Approach1(Wout.q,2);
    int length=Users.length/3;
//    int labelsCount=Ba.length;
    int i;
    int j;

    for(i=0;i<length*3;i+=3)
    {
      j=i/3;
      W1.addUser(Users[i]);
      ((JLabel)BankSim.labels.get(i)).setLocation(X+(LWIDTH+STEPX)*(j+1),Y);
      W2.addUser(Users[i+1]);
      ((JLabel)BankSim.labels.get(i+1)).setLocation(X+(LWIDTH+STEPX)*(j+1),Y+STEPY+LHIGTH);
      W3.addUser(Users[i+2]);
      ((JLabel)BankSim.labels.get(i+2)).setLocation(X+(LWIDTH+STEPX)*(j+1),Y+(STEPY+LHIGTH)*2);
    }
    if(Users.length%3==1)
    {
      j=i/3;
      W1.addUser(Users[Users.length-1]);
      ((JLabel)BankSim.labels.get(Users.length-1)).setLocation(X+(LWIDTH+STEPX)*(j+1),Y);
    }
    else if(Users.length%3==2)
    {
      j=i/3;
      W1.addUser(Users[Users.length-2]);
      ((JLabel)BankSim.labels.get(Users.length-2)).setLocation(X+(LWIDTH+STEPX)*(j+1),Y);
      W2.addUser(Users[Users.length-1]);
      ((JLabel)BankSim.labels.get(Users.length-1)).setLocation(X+(LWIDTH+STEPX)*(j+1),Y+STEPY+LHIGTH);
    }
    for (i = 0; i < Users.length; i++) {
     ((JLabel)BankSim.labels.get(i)).show(true);
    }

    Date startTime=new Date(t.getTime());
    Wout=new SecondStep(startTime);
    W1.start();
    W2.start();
    W3.start();
    Wout.start();

  }//end of constructor

  public static Point UserQPos(int UserOrder, int WindowIndex) {
   Point p = new Point();
    //user = -1 means the window position
    //WindowIndex from 0 to 2
    p.x = X + (LWIDTH + STEPX) * (UserOrder + 1);
    p.y=Y+(STEPY+LHIGTH)*WindowIndex;
    return p;
  }
  public static Point UserQOutPos(int UserOrder) {
   Point p = new Point();
    //user = -1 means the window position
    //WindowIndex from 0 to
    p.x = 10+(LWIDTH + STEPX) * (UserOrder + 1);
    p.y=Y+(STEPY+LHIGTH)*4;
    return p;
  }

  public void addUser(User user)
  {
    Approach1 minApp=((Approach1)min(W1,W2,W3));
    minApp.q.enqueue(user);
    ((JLabel)BankSim.labels.get(user.id)).setLocation(X+(LWIDTH+STEPX)*
        (minApp.q.length),Y+(STEPY+LHIGTH)*minApp.index);
    ((JLabel)BankSim.labels.get(user.id)).show(true);
  }
  public static Object min(Object obj1,Object obj2)
  {
    if(  ((Approach1)obj1).q.length +((Approach1)obj1).doService
         <((Approach1)obj2).q.length +((Approach1)obj2).doService)
     return obj1;
   return obj2;
  }
  public static Object min(Object obj1,Object obj2,Object obj3)
  {
      return min(obj1,min(obj2,obj3));
  }
  public void Terminate()
  {
    W1.stop();
    W2.stop();
    W3.stop();
    Wout.stop();
  }

}
