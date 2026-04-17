class Solution {
    public int search(int[] nums, int target) {
        // Create two pointers to keep track of left and right boundaries
        int left = 0;
        int right = nums.length - 1;
        
        // Keep iterating through the nums, while halving them until the
        // given number is found, or the pointers cross each other, meaning
        // not found
        while(left <= right){
            // Get the middle index
            int middle_index = left + (right - left) / 2;

            // Check if the target is greater than the middle index
            // If yes, then search on the right half
            if(target > nums[middle_index]){
                left = middle_index + 1;
            }

            // Check if the target is less than the middle index
            // If yes, then search on the left half
            else if(target < nums[middle_index]){
                right = middle_index - 1;
            }

            // Else it means we found the target at middle
            else{
                return middle_index;
            }
        }

        // If we were never able to return an index from the while loop, it means
        // we were never able to find the target, so return a -1
        return -1;
    }
}
