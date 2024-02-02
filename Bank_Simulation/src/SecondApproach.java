import javax.swing.*;
import java.util.ArrayList;


public class SecondApproach extends Thread
{
 public static SynchronizedQueue q=new SynchronizedQueue();
 private SynchronizedQueue outq;
 public int doService=0;
 public int index;

  public SecondApproach(SynchronizedQueue out,int Index)
  {
    outq=out;
    index=Index;
  }
  public static void addUser (User user)
  {
    q.enqueue(user);
  }
  public void run()
  {

   while(true)
    {
      try
      {
        User user=(User)q.dequeue();
        ((JLabel)BankSimulation.labels.get(user.id)).setLocation(TestSecondApproach.UserQPos(-1,this.index));
        q.begin();
        for(int i=0;i<q.length;i++)
        {
          ((JLabel)BankSimulation.labels.get(((User)q.getNext()).id)).setLocation(TestSecondApproach.UserQPos(i,1));
        }

        doService=1;
        this.sleep(user.time);
        doService=0;
        outq.enqueue(user);
        ((JLabel)BankSimulation.labels.get(user.id)).setLocation(TestSecondApproach.
              UserQOutPos(outq.length-1));

      }
      catch (InterruptedException ex) {}

    }//end while

  }//end run

}
