# Create a ListNode class that can create a Node for LinkedList
class ListNode:
    def __init__(self, value, next=None):
        self.value = value
        self.next = next

class LinkedList:
    def __init__(self):
        # Initilize an emtpy ListNode
        # And at start it is the tail as well
        self.head = ListNode(0)
        self.tail = self.head

    def get(self, index: int) -> int:
        curr = self.head.next
        i = 0
        while curr:
            if i == index:
                return curr.value
            i += 1
            curr = curr.next
        return -1  # Index out of bounds or list is empty

    def insertHead(self, val: int) -> None:
        # Create the new node with the given value
        # and point it to the head
        # then point the head to the new_node
        new_node = ListNode(value=val)      
        new_node.next = self.head.next
        self.head.next = new_node
        
        # In case the head is the last node, update the tail
        if not new_node.next: 
            self.tail = new_node
        
    def insertTail(self, val: int) -> None:
        self.tail.next = ListNode(value=val)
        self.tail = self.tail.next
        
    def remove(self, index: int) -> bool:
        # Create a pointer to iterate over the linkedList
        curr = self.head
        curr_index = 0

        # Increment the pointer until we get to the given index
        while curr_index < index:
            # If we reached a Null node, return False
            if curr == None: return False
            curr = curr.next
            curr_index += 1
        
        # Now its possible that the current pointer we are at
        # is null or the next is null, in that case we will reach
        # out of bounds, so return false
        if curr == None or curr.next == None: return False

        # Point the current node to the next of the next node
        if curr.next == self.tail:
            self.tail = curr
        curr.next = curr.next.next
        return True  

    def getValues(self) -> List[int]:
        # Create a list to store all the values of the LinkedList
        res = []
        
        # Iterate till the end of the linkedList
        curr = self.head.next
        while curr:
            res.append(curr.value)
            curr = curr.next
        return res
