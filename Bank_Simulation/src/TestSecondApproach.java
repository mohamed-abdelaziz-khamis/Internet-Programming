import java.util.Date;
import javax.swing.*;
import java.awt.*;

public class TestSecondApproach
{
  SecondApproach W1,W2,W3;
  SecondStep Wout;

  static final int X=300;
  static final int Y=100;
  static final int STEPX=10;
  static final int STEPY=10;
  static final int LWIDTH=60;
  static final int LHIGTH=60;

  public TestSecondApproach()
  {
    W1=new SecondApproach(Wout.q,0);
    W2=new SecondApproach(Wout.q,1);
    W3=new SecondApproach(Wout.q,2);

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
    p.y= Y +(STEPY+LHIGTH)*4;
    return p;
  }

  public void addUser(User user)
  {
    SecondApproach.q.enqueue(user);
    ((JLabel)BankSimulation.labels.get(user.id)).setLocation(X+(LWIDTH+STEPX)*
        (SecondApproach.q.length),Y+(STEPY+LHIGTH));
    ((JLabel)BankSimulation.labels.get(user.id)).show(true);
  }
}
