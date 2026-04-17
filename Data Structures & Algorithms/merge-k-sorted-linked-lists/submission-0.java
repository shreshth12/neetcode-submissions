/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // If there is a single List or no list at all
        // return, as its sorted by itself
        if(lists == null || lists.length == 0){
            return null;
        }

        // Move all the linkedLists into an arrayList for easier merging
        ArrayList<ListNode> arraylistsOfNodes = new ArrayList<>();
        for (ListNode node: lists){
            arraylistsOfNodes.add(node);
        }

        // Merge all the lists two at a time
        while(arraylistsOfNodes.size() > 1){

            // Create a temporary list to hold the sorted lists
            ArrayList<ListNode> temp = new ArrayList<>();

            for(int i = 0; i < arraylistsOfNodes.size(); i += 2){
                ListNode pair1 = arraylistsOfNodes.get(i);
                ListNode pair2 = (i + 1 < arraylistsOfNodes.size()) ? arraylistsOfNodes.get(i + 1) : null;
                temp.add(merge(pair1, pair2));
            }


            // Make the temp the new arraylistsOfNodes
            arraylistsOfNodes = temp;
        }

        return arraylistsOfNodes.get(0);
    }

    // Create a function to merge two linkedLists
    public ListNode merge(ListNode list1, ListNode list2){
        // Create a new pointer that will point to the start
        // of the sorted merged lists
        ListNode sortedList = new ListNode();

        // Set the current pointer to the sorted list's head
        ListNode currPointer = sortedList;

        // Iterate through both the lists and merge
        while(list1 != null && list2 != null){
            if (list1.val <= list2.val){
                currPointer.next = list1;
                list1 = list1.next;
            }
            else{
                currPointer.next = list2;
                list2 = list2.next;
            }
            currPointer = currPointer.next;
        }

        // Add any remaining nodes
        currPointer.next = (list1 != null) ? list1 : list2;

        // Return the pointer to the sorted head
        return sortedList.next;
    }
}
