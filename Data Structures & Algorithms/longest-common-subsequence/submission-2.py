class Solution:
    """
            text1 = "cat", text2 = "crabt"
                        (0, 0)
                        {1, 1}
               (2, 1)                           {1, 2}
         (3, 1)      (2, 2)                     (2, 3)
           X    (3, 1)     (2, 3)          (3, 3)    {2, 4}
                  X   (3, 1)    {2, 4}        X      (3, 5) 
                         X      (3, 5)                  X
                                  X
    """

    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        # Create a dict to capture the results
        cache = {}

        # Create a function to recursively match the letters and 
        # return the maximum common subsequence formed
        def lcs(index_1: int, index_2: int, cache: dict) -> int:
            # Base case: If the result was computed before, return that
            if((index_1, index_2) in cache):
                return cache[(index_1, index_2)]

            # Base case: If out of bounds, cache the results and return 0
            if(index_1 >= len(text1) or index_2 >= len(text2)):
                cache[(index_1, index_2)] = 0
                return 0
            
            # Recusive case, if the letters match, add 1
            # and increment both indicies
            elif(text1[index_1] == text2[index_2]):
                cache[(index_1, index_2)] = 1 + lcs(index_1 + 1, index_2 + 1, cache)
                return cache[(index_1, index_2)]
                
            # Second recursive case, if the letters do not match
            # Return the maximum of either of the index increments
            else:
                cache[(index_1, index_2)] = max(
                    lcs(index_1 + 1, index_2, cache), 
                    lcs(index_1, index_2 + 1, cache)
                )
                return cache[(index_1, index_2)]
        
        # Call the function and return the result
        return lcs(0, 0, cache)
        
    
    
        