class Solution:
    def countBits(self, n: int) -> List[int]:
        output = [0]

        # Go through each number and count the number of bits
        for number in range(1, n + 1):
            num_bits = 0
            temp_num = number
            while temp_num != 0:
                if temp_num & 1 == 1: num_bits += 1
                temp_num = temp_num >> 1
            output.append(num_bits)
        
        return output