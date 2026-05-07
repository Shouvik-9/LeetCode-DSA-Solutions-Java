class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            temp.next = smallest;
            temp = temp.next;

            if (smallest.next != null) {
                pq.offer(smallest.next);
            }
        }
        return dummy.next;
    }
}