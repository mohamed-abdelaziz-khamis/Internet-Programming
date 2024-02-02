public class SynchronizedQueue extends List {
  //synchronized method: only one thread can execute that function at the same
  //time.

  public synchronized void enqueue(Object obj)
  {
    insertAtBack(obj);
    notifyAll(); // make all waiting threads not waiting
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
