import javax.swing.*;
import java.util.ArrayList;


public class Approach2 extends Thread
{
 public static SynQueue q=new SynQueue();
 public int doService=0;
 private SynQueue outq;
 public int index;

  public Approach2(SynQueue out,int Index)
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
 //   while(!q.isEmpty())
   while(true)
    {
      try
      {
        User user=(User)q.dequeue();
        ((JLabel)BankSim.labels.get(user.id)).setLocation(TestApproach1.UserQPos(-1,this.index));
        q.begin();
        for(int i=0;i<q.length;i++)
        {
          ((JLabel)BankSim.labels.get(((User)q.getNext()).id)).setLocation(TestApproach1.UserQPos(i,1));
        }

        doService=1;
        this.sleep(user.time);
        doService=0;
        outq.enqueue(user);
        ((JLabel)BankSim.labels.get(user.id)).setLocation(TestApproach1.
              UserQOutPos(outq.length-1));

      }
      catch (InterruptedException ex) {}

    }//end while
  //  JOptionPane.showMessageDialog(null,"finish q is empty of thread "+this.toString());
  }//end run

}
