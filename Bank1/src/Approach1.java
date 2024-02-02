import javax.swing.*;
import java.util.ArrayList;


public class Approach1 extends Thread
{
 public SynQueue q;
 public int doService=0;
 // private ArrayList larr;
  private SynQueue outq;
//  private List outl;
  public int index;

  public Approach1(SynQueue out,int Index)
  {

    q=new SynQueue();
    outq=out;
   // outl=outs;
    index=Index;
  }
  public void addUser (User user)
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
          ((JLabel)BankSim.labels.get(((User)q.getNext()).id)).setLocation(TestApproach1.UserQPos(i,this.index));
        }
        //JLabel l=(JLabel)sl.pop();
        //l.setLocation(TestApproach1.X,TestApproach1.Y+(45+TestApproach1.STEPY)*index);
        doService=1;
        this.sleep(user.time);
        doService=0;
        outq.enqueue(user);
        ((JLabel)BankSim.labels.get(user.id)).setLocation(TestApproach1.
              UserQOutPos(outq.length-1));
     /*   outq.begin();
        for (int i = 0; i < outq.length; i++)
        {
          BankSim.label[ ( (User) outq.getNext()).id].setLocation(TestApproach1.
              UserQOutPos(i));
        }*/

       // outsl.push(l);
      }
      catch (InterruptedException ex) {}

    }//end while
  //  JOptionPane.showMessageDialog(null,"finish q is empty of thread "+this.toString());
  }//end run

}
