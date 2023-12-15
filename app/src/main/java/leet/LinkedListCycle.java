package leet;

import java.util.ArrayList;
import java.util.List;

public class LinkedListCycle {
    List<ListNode> nodes = new ArrayList<>();
    public boolean hasCycle(ListNode head) {
        if (head.next == null){
            return false;
        }
        if (nodes.contains(head.next)){
            return true;
        }
        nodes.add(head.next);
        return hasCycle(head.next);
    }
}
