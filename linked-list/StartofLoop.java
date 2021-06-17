import java.util.*;



class ListNode{

    int data;
    ListNode next;

    ListNode(int data){
      this.data = data;
      this.next = null;
    }

    ListNode(int data, ListNode next){
      this.data = data;
      this.next = next;
    }
}

class LinkedList{


  ListNode detectLoop(ListNode head){

    if(head == null) return null;

    ListNode fast, slow;

    fast = slow = head;

    while(slow != null && fast !=null && fast.next != null){

      slow = slow.next;
      fast = fast.next.next;

      if(slow == fast){
        return slow;
      }
    }

    return null;
  }

  ListNode findStartofLoop(ListNode head){

    ListNode ptr1 = head; //1
    ListNode ptr2 = detectLoop(head); //4

    if(ptr2 == null) return null;

    
    while(ptr1.next != ptr2.next){
      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
    }
    ptr2 = null;
    return ptr1;
  }

}

/*
  p1           p2
  1 -> 2-> 3-> 4  -> null      
*/

class StartofLoop {
  public static void main(String[] args) {
  
    LinkedList l = new LinkedList();

    ListNode one, two, three, four, five;

    // no loop test case
    five = new ListNode(5);
    four = new ListNode(4, five);
    three = new ListNode(3, four);
    two = new ListNode(2, three);
    one = new ListNode(1, two);

    // loop detected
    five.next = three;

    ListNode start = l.findStartofLoop(one);
    if(start == null)
      System.out.println("No loop");
    else
      System.out.println(start.data);
  }
}