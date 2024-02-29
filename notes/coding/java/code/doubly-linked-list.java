// Definition for doubly-linked list
class DoublyListNode {
  int val;
  DoublyListNode next;
  DoublyListNode prev;

  DoublyListNode(int x) {
    val = x;
  }
}

class MyLinkedList {
  private DoublyListNode head;

  public MyLinkedList() {
    head = null;
  }

  // Helper function to return the index-th node in the linked list
  private DoublyListNode getNode(int index) {
    DoublyListNode curr = head;
    for (int i = 0; i < index && curr != null; i++) {
      curr = curr.next;
    }
    return curr;
  }

  // Helper function to return the last node in the linked list
  private DoublyListNode getTail() {
    DoublyListNode curr = head;
    while (curr != null && curr.next != null) {
      curr = curr.next;
    }
    return curr;
  }

  // Get the value of the index-th node in the linked list. If the index is invalid, return -1
  public int get(int index) {
    DoublyListNode curr = getNode(index);
    return curr == null ? -1 : curr.val;
  }

  // Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list
  public void addAtHead(int val) {
    DoublyListNode curr = new DoublyListNode(val);
    curr.next = head;
    if (head != null) {
      head.prev = curr;
    }
    head = curr;
    return;
  }

  // Append a node of value val to the last element of the linked list
  public void addAtTail(int val) {
    if (head == null) {
      addAtHead(val);
      return;
    }
    DoublyListNode prev = getTail();
    DoublyListNode curr = new DoublyListNode(val);
    prev.next = curr;
    curr.prev = prev;
  }

  // Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted
  public void addAtIndex(int index, int val) {
    if (index == 0) {
      addAtHead(val);
      return;
    }
    DoublyListNode prev = getNode(index - 1);
    if (prev == null) {
      return;
    }
    DoublyListNode curr = new DoublyListNode(val);
    DoublyListNode next = prev.next;
    curr.prev = prev;
    curr.next = next;
    prev.next = curr;
    if (next != null) {
      next.prev = curr;
    }
  }

  // Delete the index-th node in the linked list, if the index is valid
  public void deleteAtIndex(int index) {
    DoublyListNode curr = getNode(index);
    if (curr == null) {
      return;
    }
    DoublyListNode prev = curr.prev;
    DoublyListNode next = curr.next;
    if (prev != null) {
      prev.next = next;
    } else {
      // Modify head when deleting the first node
      head = next;
    }
    if (next != null) {
      next.prev = prev;
    }
  }
}
