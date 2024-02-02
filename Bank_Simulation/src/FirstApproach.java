import javax.swing.*;
import java.util.ArrayList;

public class FirstApproach extends Thread
{
  public SynchronizedQueue q;
  private SynchronizedQueue outq;
  public int doService=0;
  public int index;

  public FirstApproach(SynchronizedQueue out,int Index)
  {
    q=new SynchronizedQueue();
    outq=out;
    index=Index;
  }

  public void addUser (User user)
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
        ((JLabel)BankSimulation.labels.get(user.id)).setLocation(TestFirstApproach.UserQPos(-1,this.index));
        q.begin();
        for(int i=0;i<q.length;i++)
        {
          ((JLabel)BankSimulation.labels.get(((User)q.getNext()).id)).setLocation(TestFirstApproach.UserQPos(i,this.index));
        }
        doService=1;
        this.sleep(user.time);
        doService=0;
        outq.enqueue(user);
        ((JLabel)BankSimulation.labels.get(user.id)).setLocation(TestFirstApproach.
              UserQOutPos(outq.length-1));
      }
      catch (InterruptedException ex) {}
    }//end while
  }//end run
}
