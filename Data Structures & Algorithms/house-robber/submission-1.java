class Solution {
    public int rob(int[] nums) {
        // [2, 9]
        // [9, 10]
        // [10, 12]
        // [10, 12]
        // If we have only one house, return
        if(nums.length == 1){return nums[0];}

        // If we have only two houses return the maximum
        if(nums.length == 2){return Math.max(nums[0], nums[1]);}
        
        // Create two vairables:- 
        // One to track the previous largest
        // One to track the current largest
        int prevLargest = 0;
        int currLargest = 0;

        // Start iterating from the 3rd house
        for(int currHouse: nums){
            int temp = Math.max(currLargest, currHouse + prevLargest);
            prevLargest = currLargest;
            currLargest = temp;
        }

        return currLargest;
    }
}
