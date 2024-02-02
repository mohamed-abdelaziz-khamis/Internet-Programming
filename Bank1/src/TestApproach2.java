import java.util.Date;
import javax.swing.*;
import java.awt.*;

public class TestApproach2
{
  Approach2 W1,W2,W3;
  SecondStep Wout;
  Date t=new Date();
  static final int X=300;
  static final int Y=100;
  static final int STEPX=10;
  static final int STEPY=10;
  static final int LWIDTH=60;
  static final int LHIGTH=60;

  public TestApproach2(User Users[])
  {
    W1=new Approach2(Wout.q,0);
    W2=new Approach2(Wout.q,1);
    W3=new Approach2(Wout.q,2);
   // int length=Users.length/3;

    int i;


    for(i=0;i<Users.length;i++)
    {
      Approach2.addUser(Users[i]);
      ((JLabel)BankSim.labels.get(i)).setLocation(X+(LWIDTH+STEPX)*(i+1),Y+STEPY+LHIGTH);
      ((JLabel)BankSim.labels.get(i)).show(true);
    }

/*    for (i = 0; i < Users.length; i++) {
     ((JLabel)BankSim.labels.get(i)).show(true);
    }*/

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
    Approach2.q.enqueue(user);
    ((JLabel)BankSim.labels.get(user.id)).setLocation(X+(LWIDTH+STEPX)*
        (Approach2.q.length),Y+(STEPY+LHIGTH));
    ((JLabel)BankSim.labels.get(user.id)).show(true);
  }
  public void Terminate()
  {
    W1.stop();
   W2.stop();
   W3.stop();
   Wout.stop();

  }


}
