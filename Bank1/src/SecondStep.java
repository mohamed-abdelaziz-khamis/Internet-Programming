import java.util.Date;
import javax.swing.*;

public class SecondStep extends Thread
{
  final long WAIT_TIME=1500;
  private Date start_Time;
  private Date end_Time=new Date();
  public static SynQueue q=new SynQueue();
  private Date consumedTime=new Date();
  public SecondStep(Date startTime)
  {
    start_Time=startTime;
  }
  public void run()  {
   //for(int i=0;i<BankSim.USERS_COUNT;i++)
   while(true)
    {
          User user = (User) q.dequeue();
          ((JLabel)BankSim.labels.get(user.id)).setLocation(TestApproach1.UserQOutPos(-1));
          q.begin();
          for (int j = 0; j < q.length; j++) {
            ((JLabel)BankSim.labels.get(((User)q.getNext()).id)).setLocation(TestApproach1.
                UserQOutPos(j));
          }

        //  JOptionPane.showMessageDialog(null,"NOU = "+numOfUsers);
          try {
            this.sleep(WAIT_TIME);
             ((JLabel)BankSim.labels.get(user.id)).setLocation(-100,-100);
             ((JLabel)BankSim.labels.get(user.id)).show(false);
          }
          catch (InterruptedException ex) {
          }
     } //end for
/*   end_Time=new Date(end_Time.getTime());
          // display difference between start and end time
    consumedTime=new Date(end_Time.getYear()-start_Time.getYear(),
                          end_Time.getMonth()-start_Time.getMonth(),
                          end_Time.getDate()-start_Time.getDate(),
                          end_Time.getHours()-start_Time.getHours(),
                          end_Time.getMinutes()-start_Time.getMinutes(),
                          end_Time.getSeconds()-start_Time.getSeconds());
     int hour=consumedTime.getHours();
     int min=consumedTime.getMinutes();
     int sec=consumedTime.getSeconds();

          JOptionPane.showMessageDialog(null,"hours is "+hour+" min is "+min
                                        +"sec = "+sec);*/
  } //end run

}
