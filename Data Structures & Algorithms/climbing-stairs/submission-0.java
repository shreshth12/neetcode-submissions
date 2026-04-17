class Solution {
    public int climbStairs(int n) {
        /* 
        Each time we can either take one step or two steps until we reach the top.
        Representing this mathematically, essentially it is the number of distinct 
        ways of climbing is: climbStairs(int n) = climbStairs(n - 1) + climbStairs(n - 2)
        In case of climbStairs(3), our decision tree would look like :-
                                    climbStairs(3)
                        climbStairs(2)      +      climbStairs(1)
            climbStairs(1) + climbStairs(0)   climbStairs(0) + climbStairs(-1)

        Climbing 0 stairs takes 1 step and climbing a single stair takes a single step.
        Putting those in the tree, we get :-
                                    3
                                2   +   1
                             1 + 1     1 + 0
        We got a total of 3 steps.
        */

        // Base case 1: If the steps reached less than 0, that means we don't need any more steps
        if(n < 0){
            return 0;
        }

        // Base case 2: If the steps reached 0 or 1, then we need just a single step to reach top
        if(n == 0 || n == 1){
            return 1;
        }

        // Recursive case, where we evaluate climbStairs(n - 1) + climbStairs(n - 2)
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
