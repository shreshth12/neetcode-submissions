class DynamicArray:
    
    def __init__(self, capacity: int):
        # Create an empty array
        self.array = [0] * capacity
        
        # length is the number of 'real' elements in the array
        self.length = 0

        # capacity is the declared size of the array
        self.capacity = capacity

    def get(self, i: int) -> int:
        # Simply return the element at given index
        return self.array[i]

    def set(self, i: int, n: int) -> None:
        # Simply set the index i to value n
        self.array[i] = n

    def pushback(self, n: int) -> None:
        # Check if the array is full, if yes, double the size
        if self.length == self.capacity:
            self.capacity = self.capacity * 2

            # Copy the previous array's elements
            new_array = [0] * (self.capacity)
            for index in range(len(self.array)):
                new_array[index] = self.array[index]
            self.array = new_array[:]
        
        # Insert the given element at the end
        self.array[self.length] = n
        self.length += 1

    def popback(self) -> int:
        # Replace the end element of the array with a 0 and before returning
        last_element = self.array[self.length - 1]
        self.array[self.length - 1] = 0
        self.length -= 1
        return last_element

    def resize(self) -> None:
        # Double the capacity
        self.capacity = self.capacity * 2

        # Copy the previous array's elements
        new_array = [0] * (self.capacity)
        for index in range(len(self.array)):
            new_array[index] = self.array[index]
        self.array = new_array[:]


    def getSize(self) -> int:
        # Return the length of the array
        return self.length
        
    def getCapacity(self) -> int:
        # Return the capacity of the array
        return self.capacity