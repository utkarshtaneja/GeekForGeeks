/* class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}*/
class Solution {
    static Node segregate(Node head) {
        // code here
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        
        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) count0++;
            else if (curr.data == 1) count1++;
            else{
                count2++;
            }   
            curr = curr.next;
        }
        
        curr = head;
        while(count0 > 0 && curr != null) {
            curr.data = 0;
            curr = curr.next;
            count0--;
        }
        
        while(count1 > 0 && curr != null) {
            curr.data = 1;
            curr = curr.next;
            count1--;
        }
        
        while(count2 > 0 && curr != null) {
            curr.data = 2;
            curr = curr.next;
            count2--;
        }
        
        return head;
    }
}