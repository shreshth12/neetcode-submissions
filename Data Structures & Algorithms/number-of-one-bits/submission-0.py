class Solution:
    def hammingWeight(self, n: int) -> int:
        number_of_one_bits = 0

        # Keep shifting the bits until the number is 0
        while(n != 0):
            if n & 1 == 1: number_of_one_bits += 1
            n = n >> 1
            
        return number_of_one_bits
        