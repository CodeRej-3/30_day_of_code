public class swapPair {
    private void swap(ListNode l1, ListNode l2) {
        l1.val = l1.val + l2.val;
        l2.val = l1.val - l2.val;
        l1.val = l1.val - l2.val;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode tmp = head;

        if (tmp == null || tmp.next == null)
            return head;

        while (tmp != null && tmp.next != null) {
            swap(tmp, tmp.next);
            tmp = tmp.next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        swapPair sol = new swapPair();
        ListNode l = new ListNode(new int[] { 1, 2, 3, 4 });
        l.display();

        l = sol.swapPairs(l);

        l.display();
    }
}