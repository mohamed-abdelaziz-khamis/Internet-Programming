import java.util.Date;
import javax.swing.*;

public class SecondStep extends Thread
{
  public static SynchronizedQueue q=new SynchronizedQueue();
  final long WAIT_TIME=1500;

  public void run()  {

   while(true)
    {
          User user = (User) q.dequeue();
          ((JLabel)BankSimulation.labels.get(user.id)).setLocation(TestFirstApproach.UserQOutPos(-1));
          q.begin();
          for (int j = 0; j < q.length; j++) {
            ((JLabel)BankSimulation.labels.get(((User)q.getNext()).id)).setLocation(TestFirstApproach.
                UserQOutPos(j));
          }


          try {
            this.sleep(WAIT_TIME);
             ((JLabel)BankSimulation.labels.get(user.id)).setLocation(-100,-100);
             ((JLabel)BankSimulation.labels.get(user.id)).show(false);
          }
          catch (InterruptedException ex) {
          }
     } //end for
  } //end run
}
