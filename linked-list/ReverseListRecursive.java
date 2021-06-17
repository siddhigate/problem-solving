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

  void printList(ListNode head){

    System.out.println();
    while(head != null){
      System.out.print(head.data+"->");
      head = head.next;
    }
  }


  ListNode reverseList(ListNode head){

    /*
      1 -> 2 -> 3 -> null
    */

    if(head == null || head.next == null)
      return head;

    ListNode newHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;

    return newHead;
  }
}

class ReverseListRecursive {
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