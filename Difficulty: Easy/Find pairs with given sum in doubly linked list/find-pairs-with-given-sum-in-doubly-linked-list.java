/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (head == null) return ans;
        
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        
        Node first = head;
        Node last = tail;
        
        while (first != last && last.next != first) {
            int sum = first.data + last.data;
            if (sum == target) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(first.data);
                pair.add(last.data);
                ans.add(pair);

                first = first.next;
                last = last.prev;
            } 
            else if (sum < target) {
                first = first.next;
            } 
            else {
                last = last.prev;
            }
        }

        return ans;
    }
}
