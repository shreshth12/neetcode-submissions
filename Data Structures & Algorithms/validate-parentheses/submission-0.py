class Solution:
    def isValid(self, s: str) -> bool:
        # Create a stack to store the parantheses
        stack = []

        # Iterate through each type of parantheses in string s
        for parenthesis in s:
            # If the parenthesis is a closing one
            if parenthesis == ")" or parenthesis == "}" or parenthesis == "]":
                # Either the stack is empty, i.e there are no open parenthesis before it
                # then the string is not valid
                if len(stack) == 0: return False
                
                # If the parenthesis seen before is not of the same type, then also its string is invalid
                elif stack[-1] == "(" and parenthesis is not ")": return False
                elif stack[-1] == "[" and parenthesis is not "]": return False
                elif stack[-1] == "{" and parenthesis is not "}": return False

                # Else, we found a correct match, so let's pop that from stack and continue
                else: stack.pop()
            
            # If we are here, means the paranthesis is not a closing one, so add it to stack
            else:
                stack.append(parenthesis)
        
        # Now if the stack is not empty, then some parenthesis weren't closed
        # And if its emtpy and we never returned False, means the string was valid
        return False if len(stack) > 0 else True
        