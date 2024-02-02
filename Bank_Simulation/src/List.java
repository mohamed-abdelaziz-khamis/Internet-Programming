
// class to represent one node in a list
class ListNode {

   // package access members; List can access these directly
   Object data;
   ListNode nextNode;

   // create a ListNode that refers to object
   ListNode( Object object )
   {
      this( object, null );
   }

   // create ListNode that refers to Object and to next ListNode
   ListNode( Object object, ListNode node )
   {
      data = object;
      nextNode = node;
   }

   // return reference to data in node
   Object getObject()
   {
      return data; // return Object in this node
   }

   // return reference to next node in list
   ListNode getNext()
   {
      return nextNode; // get next node
   }

} // end class ListNode

// class List definition
public class List {
   private ListNode firstNode;
   private ListNode lastNode;
   private ListNode currentNode;
   private String name;  // string like "list" used in printing
   public int length;
   // construct empty List with "list" as the name
   public List()
   {
      this( "list" );
      length=0;
   }
   public void begin()
   {
     currentNode=firstNode;
   }
   public Object getNext()
   {
     Object n=currentNode.data;
     if(currentNode!=lastNode)
     {
       currentNode = currentNode.nextNode;
     }
     return n;
   }
   // construct an empty List with a name
   public List( String listName )
   {
     length=0;
      name = listName;
      firstNode = lastNode = null;
   }

   // insert Object at front of List
   public synchronized void insertAtFront( Object insertItem )
   {
      if ( isEmpty() ) // firstNode and lastNode refer to same object
         firstNode = lastNode = new ListNode( insertItem );

      else // firstNode refers to new node
         firstNode = new ListNode( insertItem, firstNode );

      length++;
   }

   // insert Object at end of List
   public synchronized void insertAtBack( Object insertItem )
   {
      if ( isEmpty() ) // firstNode and lastNode refer to same Object
         firstNode = lastNode = new ListNode( insertItem );

      else // lastNode's nextNode refers to new node
         lastNode = lastNode.nextNode = new ListNode( insertItem );

      length++;
   }

   // remove first node from List
   public synchronized Object removeFromFront() throws EmptyListException
   {
      if ( isEmpty() ) // throw exception if List is empty
         throw new EmptyListException( name );

      Object removedItem = firstNode.data; // retrieve data being removed

      // update references firstNode and lastNode
      if ( firstNode == lastNode )
         firstNode = lastNode = null;
      else
         firstNode = firstNode.nextNode;
      length--;
      return removedItem; // return removed node data

   } // end method removeFromFront

   // remove last node from List
   public synchronized Object removeFromBack() throws EmptyListException
   {
      if ( isEmpty() ) // throw exception if List is empty
         throw new EmptyListException( name );

      Object removedItem = lastNode.data; // retrieve data being removed

      // update references firstNode and lastNode
      if ( firstNode == lastNode )
         firstNode = lastNode = null;

      else { // locate new last node
         ListNode current = firstNode;

         // loop while current node does not refer to lastNode
         while ( current.nextNode != lastNode )
            current = current.nextNode;

         lastNode = current; // current is new lastNode
         current.nextNode = null;
      }
      length--;
      return removedItem; // return removed node data

   } // end method removeFromBack

   // determine whether list is empty
   public synchronized boolean isEmpty()
   {
      return firstNode == null; // return true if List is empty
   }

   // output List contents
   public synchronized void print()
   {
      if ( isEmpty() ) {
         System.out.println( "Empty " + name );
         return;
      }

      System.out.print( "The " + name + " is: " );
      ListNode current = firstNode;

      // while not at end of list, output current node's data
      while ( current != null ) {
         System.out.print( current.data.toString() + " " );
         current = current.nextNode;
      }

      System.out.println( "\n" );
   }

} // end class List

