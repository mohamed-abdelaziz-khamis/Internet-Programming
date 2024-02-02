

public class Queue extends List {
  public Queue() {
  }
  public synchronized void enqueue(Object obj)
   {
     insertAtBack(obj);
   }

   public synchronized Object dequeue() throws EmptyListException
   {
     return removeFromFront();
   }

}
