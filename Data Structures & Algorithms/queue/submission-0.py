# Class to implement a doubly linkedlist
class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None
        self.prev = None

class Deque:
    def __init__(self):
        # Initilize head and tail pointers
        # None <- head <-> tail -> None
        self.head = ListNode(0)
        self.tail = ListNode(0)
        self.head.next = self.tail
        self.tail.prev = self.head

    def isEmpty(self) -> bool:
        # If the head and the tail pointers point to each other
        # means that there are no elements between then
        if self.head.next == self.tail: return True
        return False

    def append(self, value: int) -> None:
        # Create a listnode with the given value
        new_node = ListNode(value)
        
        # Insert the value
        new_node.next = self.tail
        new_node.prev = self.tail.prev

        self.tail.prev.next = new_node
        self.tail.prev = new_node

    def appendleft(self, value: int) -> None:
        # Create a listnode with the given value
        new_node = ListNode(value)

        # Insert the value
        new_node.next = self.head.next
        new_node.prev = self.head

        self.head.next.prev = new_node
        self.head.next = new_node

    def pop(self) -> int:
        # If the queue is empty, return a -1
        if self.isEmpty(): return -1

        # Return the value of the node the tail is pointing to
        # and then remove the pointers at the tail
        # None <- head <-> 1 <-> tail -> None
        end_value = self.tail.prev.val
        self.tail.prev.prev.next = self.tail
        self.tail.prev = self.tail.prev.prev
        return end_value

    def popleft(self) -> int:
        # If the queue is empty, return a -1
        if self.isEmpty(): return -1

        # None <- head <-> 1 <-> tail -> None
        front_end = self.head.next.val
        self.head.next.next.prev = self.head
        self.head.next = self.head.next.next

        return front_end

        
