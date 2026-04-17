# Create a linkedList node class
class ListNode:
    def __init__(self, value, next=None):
        self.value = value
        self.next = next

class LinkedList:    
    def __init__(self):
        # Initilize a ListNode with a head and a tail
        self.head = ListNode(0)
        self.tail = self.head
    
    def get(self, index: int) -> int:
        # Create a dummy node to iterate and
        # a variable to keep track of the iteration
        curr, curr_idx = self.head.next, 0

        # Iterate through the linkedList until we find or get out of bounds
        while curr:
            if curr_idx == index: return curr.value
            curr = curr.next
            curr_idx += 1
        
        # If we couldn't return the index, it means we went out of bounds
        return -1

    def insertHead(self, val: int) -> None:
        # Create a new ListNode object to add before the current head
        new_node = ListNode(val)
        
        # Point the new_node to the current head
        # and then point the curr_head to new_node
        new_node.next = self.head.next
        self.head.next = new_node

        # Check if the new_node is actually the last value
        if new_node.next == None: self.tail = new_node

    def insertTail(self, val: int) -> None:
        self.tail.next = ListNode(val)
        self.tail = self.tail.next

    def remove(self, index: int) -> bool:
        # Create a dummy node to iterate and
        # a variable to keep track of the iteration
        curr, curr_idx = self.head, 0
        while curr_idx < index:
            # If we reach end of the LinkedList before finding the index
            # then return False and exit
            if curr == None: return False
            curr = curr.next
            curr_idx += 1
        
        # At this point its possible that we found the index but now
        # either this index is None/Null or next one is
        if curr == None or curr.next == None: return False

        # Remove the pointer of curr node to next and assign it to the next of next
        # But if the next one is the tail then update that
        if curr.next == self.tail:
            self.tail = curr
        curr.next = curr.next.next
        return True

    def getValues(self) -> List[int]:
        # Create a list to store the values of the LinkedList
        values = []
        
        # Iterate through the linkedList
        curr = self.head.next
        while curr:
            values.append(curr.value)
            curr = curr.next
        return values
        
