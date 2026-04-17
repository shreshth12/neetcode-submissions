class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a hashmap to keep track of each index and its value
        Map<Integer, Integer> numberCount = new HashMap<>();

        // Iterate through the nums array, and check if the remainder
        // of the current number - target has been found before
        for(int idx = 0; idx < nums.length; idx++){
            int remainder = target - nums[idx];
            if(numberCount.containsKey(remainder)){
                if(idx < numberCount.get(remainder)){
                    return new int[]{idx, numberCount.get(remainder)};
                }
                else{
                    return new int[]{numberCount.get(remainder), idx};
                }
            }
            numberCount.put(nums[idx], idx);
        }

        return new int[]{};
    }
}
