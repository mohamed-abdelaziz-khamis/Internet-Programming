

public class SynQueue extends List {
  public SynQueue() {
  }
  public synchronized void enqueue(Object obj)
  {
    insertAtBack(obj);
    notifyAll();
  }

  public synchronized Object dequeue()
  {
    while(isEmpty())
    {
      try
      {
           wait();
      }
      catch(InterruptedException exception)
      {
        exception.printStackTrace();
      }
    }//end while
    notifyAll();
    return removeFromFront();
  }


}
