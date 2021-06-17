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


  boolean detectLoop(ListNode head){

    if(head == null) return false;

    ListNode fast, slow;

    fast = slow = head;

    while(slow != null && fast !=null && fast.next != null){

      slow = slow.next;
      fast = fast.next.next;

      if(slow == fast){
        return true;
      }
    }

    return false;
  }


}


class DetectLoop {
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
    five.next = one;

    if(l.detectLoop(one))
        System.out.println("loop detected");
    else
      System.out.println("NO loop detected");
  }
}