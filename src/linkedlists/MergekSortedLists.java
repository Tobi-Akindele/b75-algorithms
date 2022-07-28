package linkedlists;

import java.util.ArrayList;
import java.util.List;

public class MergekSortedLists {

	public static void main(String[] args) {

	}

	public ListNode mergeKLists(ListNode[] lists) {
		
		if(lists == null || lists.length == 0) {
			return null;
		}
		
		while(lists.length > 1) {
			List<ListNode> mergedLists = new ArrayList<>();
			
			for(int i = 0; i < lists.length; i += 2) {
				ListNode l1 = lists[i];
				ListNode l2 = null;
				// check if we've not gone out of bound
				if((i + 1) < lists.length) {
					l2 = lists[i + 1];
				}
				mergedLists.add(merger(l1, l2));
			}
			lists = mergedLists.toArray(new ListNode[mergedLists.size()]);
		}
		return lists[0];
	}
	
	private ListNode merger(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode();
		ListNode tail = dummy;
		
		while (l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				tail.next = l1;
				l1 = l1.next;
			} else {
				tail.next = l2.next;
				l2 = l2.next;
			}
			tail = tail.next;
		}
		
		if(l1 != null) {
			tail.next = l1;
		}
		if(l2 != null) {
			tail.next = l2;
		}
		return dummy.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
