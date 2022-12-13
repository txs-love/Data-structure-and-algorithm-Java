package org.LeetCode;

public class Two_Add2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(9);
        Two_Add2 twoAdd2 = new Two_Add2();
        ListNode listNode = twoAdd2.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //定义两个指针来操作;
        ListNode pre = new ListNode(0);
        ListNode temp = pre;     //这里这个指针用来返回结果元素;
        int carry = 0;
        while (l1!=null || l2!=null){
            int x = l1.val == 0? 0: l1.val;
            int y = l2.val ==0 ? 0: l2.val;
            int sum = x+y+carry;
            carry = sum/10;
            sum =sum % 10;
            temp.next = new ListNode(sum);
            temp = temp.next;
            if (l1!=null){
                l1 = l1.next;
            }
            if (l2!=null){
                l2 = l2.next;
            }
            if (carry==1){
                temp.next = new ListNode(carry);
            }
        }
        return pre.next;
    }
}
class ListNode {
     int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
