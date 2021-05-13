public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {this.val = val;}

    public ListNode(int val, ListNode next) {this.val = val; this.next = next;}

    public ListNode(int[] arr) {
        ListNode ptr = this;
        ptr.val = arr[0];
        for(int x = 1; x < arr.length; x++) {
            ListNode tmp = new ListNode(arr[x]);
            ptr.next = tmp;
            ptr = ptr.next;
        }
    }

    void display() {
        ListNode ptr = this;
        while(ptr != null){
            System.out.print(ptr.val + "->");
            ptr = ptr.next;
        }
        System.out.print("NULL\n");
    }

    public static void main(String[] args) {
        ListNode x = new ListNode(new int[] {3, 4, 5});
        x.display();
    }
}
