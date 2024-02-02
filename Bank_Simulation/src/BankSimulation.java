import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class BankSimulation extends JFrame
{
  public static int USERS_NUM=0;
  public static final int DELTA=5;

  public boolean approach1=true;

  private TestFirstApproach testApporach1;
  private TestSecondApproach testApporach2;

  private JButton FirstApproachBtn;
  private JButton SecondApproachBtn;
  private JButton AddClientBtn;

  private Container Cont;

  private JPanel panel;

  public static ArrayList labels;

  public JLabel Window1;
  public JLabel Window2;
  public JLabel Window3;
  public JLabel Window4;

  public BankSimulation()
  {
    super("Bank Simulation Process");
    Cont = getContentPane();
    Cont.setBackground(new Color(100, 100, 200));
    labels=new ArrayList();

    Window1=new JLabel("W1:");
    Window1.setLocation(TestFirstApproach.X-DELTA,TestFirstApproach.Y-DELTA);
    Window1.setSize(TestFirstApproach.LWIDTH+2*DELTA,TestFirstApproach.LHIGTH+2*DELTA);
    Cont.add(Window1);
    Window1.show(true);

    Window2 = new JLabel("W2:");
    Window2.setLocation(TestFirstApproach.X - DELTA,
                        TestFirstApproach.Y+TestFirstApproach.STEPY+TestFirstApproach.LHIGTH- DELTA);
    Window2.setSize(TestFirstApproach.LWIDTH + 2 * DELTA,
                    TestFirstApproach.LHIGTH + 2 * DELTA);
    Cont.add(Window2);
    Window2.show(true);

    Window3 = new JLabel("W3:");
    Window3.setLocation(TestFirstApproach.X - DELTA,
                        TestFirstApproach.Y+(TestFirstApproach.STEPY+TestFirstApproach.LHIGTH)*2- DELTA);
    Window3.setSize(TestFirstApproach.LWIDTH + 2 * DELTA,
                    TestFirstApproach.LHIGTH + 2 * DELTA);
    Cont.add(Window3);
    Window3.show(true);

    Window4 = new JLabel("Wo:");
    Window4.setLocation(10- DELTA,
                        TestFirstApproach.Y+(TestFirstApproach.STEPY+TestFirstApproach.LHIGTH)*4- DELTA);
    Window4.setSize(TestFirstApproach.LWIDTH + 2 * DELTA,
                    TestFirstApproach.LHIGTH + 2 * DELTA);
    Cont.add(Window4);
    Window4.show(true);

    FirstApproachBtn = new JButton("First Approach");
    FirstApproachBtn.setSize(175, 50);
    FirstApproachBtn.setLocation(10, 10);
    FirstApproachBtn.addActionListener(
        new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        approach1=true;
        FirstApproachBtn.setEnabled(false);
        SecondApproachBtn.setEnabled(false);
        AddClientBtn.setEnabled(true);
        testApporach1 = new TestFirstApproach();
      }
    }
    );
    Cont.add(FirstApproachBtn);
    FirstApproachBtn.show(true);

    SecondApproachBtn = new JButton("Second Approach");
    SecondApproachBtn.setSize(175, 50);
    SecondApproachBtn.setLocation(300, 10);
    SecondApproachBtn.addActionListener(
        new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        approach1=false;
        FirstApproachBtn.setEnabled(false);
        SecondApproachBtn.setEnabled(false);
        AddClientBtn.setEnabled(true);
        testApporach2 = new TestSecondApproach();
      }
    }
    );
    Cont.add(SecondApproachBtn);
    SecondApproachBtn.show(true);

    AddClientBtn = new JButton("Add new client");
    AddClientBtn.setEnabled(false);
    AddClientBtn.setSize(175, 50);
    AddClientBtn.setLocation(600, 10);
    AddClientBtn.addActionListener(
        new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        User user=new User();
        user.id=USERS_NUM++;
        user.time=Long.parseLong(JOptionPane.showInputDialog
                                 ("Insert client's service time in seconds"))*1000;
        labels.add(new JLabel(user.id+" "+"("+user.time/1000+")",JLabel.CENTER));
        ((JLabel)labels.get(user.id)).setSize(TestFirstApproach.LWIDTH,TestFirstApproach.LHIGTH);
        Cont.add(((JLabel)labels.get(user.id)));
        ((JLabel)labels.get(user.id)).show(false);

        if(approach1)
          testApporach1.addUser(user);
        else
          testApporach2.addUser(user);
      }
    }
    );
    Cont.add(AddClientBtn);
    AddClientBtn.show(true);

    panel = new JPanel();
    panel.setLocation(500, 300);
    panel.setBackground(new Color(100, 100, 200));
    Cont.add(panel);
    panel.setVisible(false);
    setSize(1000, 500);
    setVisible(true);
  }//end of BankSimulation constructor

  public static void main(String[] args)
  {
    BankSimulation bankSim = new BankSimulation();
    bankSim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

}
