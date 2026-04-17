class Solution:
    def countBits(self, n: int) -> List[int]:
        # Create a DP list to store the output of each number's bits
        bits_array = [0 for _ in range(n + 1)]

        # Start from 0 and go all the way to n to count bits
        for number in range(0, n + 1):
            bits_array[number] = (number & 1) + bits_array[number >> 1]
        
        # Return the result
        return bits_array