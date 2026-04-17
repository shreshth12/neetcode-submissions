# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # Create Null variable to reverse point the given linkedList to
        prev = None

        # Iterate through the given linkedList
        while head:
            # Store the next pointer to head
            next_node = head.next

            # Point the head to prev Node
            head.next = prev

            # Now our previous node becomes the current head
            prev = head

            # Move our head to next node
            head = next_node
        
        # At this point our prev pointer is the start of new LinkedList
        return prev

        
        