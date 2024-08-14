import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

// Definition for singly-linked list
public class ListNode {
  int val;
  ListNode next;

  ListNode() {
    this.val = 0;
    this.next = null;
  }

  ListNode(int val) {
    this.val = val;
    this.next = null;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
