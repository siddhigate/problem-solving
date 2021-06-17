import java.util.*;

/*

  1 -> 2-> 3-> 4-> -> 5 -> null
  f        f          f    fast.next   

  1 -> 2-> 3-> 4-> null
  f        f       f  fast = null               

// ll even fast.next
// lll odd fast null

              p2
  1 -> 2-> 3-> 4 -> null

    ---------- 

  
*/

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

    while(fast !=null && fast.next != null){

      slow = slow.next;
      fast = fast.next.next;

      if(slow == fast){
        return slow;
      }
    }

    return null;
  }

  boolean deleteLoop(ListNode head){

    ListNode ptr1 = head;
    ListNode ptr2 = detectLoop(head);

    //  if no loop then return
    if(ptr2 == null) return false;

    // same node == head
    if(ptr2 == head){
      
      while(ptr2.next != head){
        ptr2 = ptr2.next;
      }
      
      ptr2.next = null;
      return true;
    }

    while(ptr1.next != ptr2.next){
      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
    }

    ptr2.next = null;
    return true;
  }

}


class RemoveLoop {
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
    five.next = two;

    if(l.deleteLoop(one))
        System.out.println("loop deleted");
    else
      System.out.println("NO loop detected");
  }
}