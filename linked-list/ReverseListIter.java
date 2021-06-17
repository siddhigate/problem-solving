class ListNode{

  int data;
  ListNode next;

  ListNode(int data){
    this.data = data;
    this.next = next;
  }

  ListNode(int data, ListNode next){
    this.data = data;
    this.next = next;
  }
}

class LinkedList{

  void printList(ListNode head){

    System.out.println();
    while(head != null){
      System.out.print(head.data+"->");
      head = head.next;
    }
  }


  ListNode reverseList(ListNode head){

    ListNode prev, curr, next;

    /*
    
      1 -> 2 -> 3 -> 4 -> null
    */

    prev = next = null;
    curr= head;

    while(curr != null){

      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
  }
}


class ReverseListIter {
  public static void main(String[] args) {
  
    ListNode one, two, three, four, five;

    five = new ListNode(5);
    four = new ListNode(4, five);
    three = new ListNode(3, four);
    two = new ListNode(2, three);
    one = new ListNode(1, two);

    LinkedList ll = new LinkedList();

    ll.printList(one);
    ListNode head = ll.reverseList(one);
    ll.printList(head);
  }
}