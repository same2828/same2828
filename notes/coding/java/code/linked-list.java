public class linked_list {
  // Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  class MyLinkedList {
    private ListNode head;
    private ListNode tail;

    public MyLinkedList() {
      head = null;
    }

    // Helper function to return the index-th node in the linked list
    private ListNode getNode(int index) {
      ListNode curr = head;
      for (int i = 0; i < index && curr != null; i++) {
        curr = curr.next;
      }
      return curr;
    }

    // Helper function to return the last node in the linked list
    private ListNode getTail() {
      return tail;
      // ListNode curr = head;
      // while (curr != null && curr.next != null) {
      //   curr = curr.next;
      // }
      // return curr;
    }

    // Get the value of the index-th node in the linked list. If the index is invalid, return -1
    public int getAtIndex(int index) {
      ListNode curr = getNode(index);
      return curr == null ? -1 : curr.val;
    }

    // Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list
    public void addAtHead(int val) {
      ListNode newNode = new ListNode(val);
      newNode.next = head;
      head = newNode;
      return;
    }

    // Append a node of value val to the last element of the linked list
    public void addAtTail(int val) {
      ListNode newNode = new ListNode(val);
      if (head == null && tail == null) {
        head = newNode;
        tail = newNode;
        return;
      } else {
        tail.next = newNode;
        tail = newNode;
      }
      // ListNode prev = getTail();
      // ListNode curr = new ListNode(val);
      // prev.next = curr;
    }

    // Add a node of value val before the index-th node in the linked list.
    // If index equals to the length of linked list, the node will be appended to the end of linked list.
    // If index is greater than the length, the node will not be inserted
    public void addAtIndex(int index, int val) {
      if (index == 0) {
        addAtHead(val);
        return;
      }
      ListNode prev = getNode(index - 1);
      if (prev == null) {
        return;
      }
      ListNode curr = new ListNode(val);
      ListNode next = prev.next;
      curr.next = next;
      prev.next = curr;
    }

    // Delete the index-th node in the linked list, if the index is valid
    public void deleteAtIndex(int index) {
      ListNode curr = getNode(index);
      if (curr == null) {
        return;
      }
      ListNode next = curr.next;
      if (index == 0) {
        // Modify head when deleting the first node.
        head = next;
      } else {
        ListNode prev = getNode(index - 1);
        prev.next = next;
      }
    }
  }
}
