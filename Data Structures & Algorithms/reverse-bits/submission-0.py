class Solution:
    def reverseBits(self, n: int) -> int:
        # Create a variable to store the result
        result = 0

        # Iterate through each bit in a 32-bit unsigned integer
        # and reverse the bits in the result
        for i in range(0, 32):
            bit_set = (n >> i) & 1
            result = result | (bit_set << (31 - i))
        
        # Return the result
        return result
        