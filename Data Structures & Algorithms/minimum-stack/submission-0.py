class MinStack:
    def __init__(self):
        # Initialize two lists/stacks
        # One to keep track of the elements
        # Two to keep track of minimum at that time
        self.stack = []
        self.min_stack = []
        self.min_stack_length = 0

    def push(self, val: int) -> None:
        # Simply push the element onto the top of the stack
        self.stack.append(val)

        # Check if the value is the minimum seen so far
        if self.min_stack_length == 0 or val <= self.min_stack[-1]:
            self.min_stack.append(val)
            self.min_stack_length += 1

    def pop(self) -> None:
        # Simply pop the element from the top of the stack
        popped_element = self.stack.pop()
        
        # If the popped element was the minimum we have seen so far
        # then remove that element from the min_stack and update its length
        if popped_element == self.min_stack[-1]:
            self.min_stack.pop()
            self.min_stack_length -= 1

    def top(self) -> int:
        # Simply return the top of the stack
        return self.stack[-1]
        
    def getMin(self) -> int:
        # Simply return the top of the min_stack
        return self.min_stack[-1]
