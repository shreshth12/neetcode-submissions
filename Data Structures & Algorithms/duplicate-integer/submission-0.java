class Solution {
    public boolean hasDuplicate(int[] nums) {
        // Create a hashmap to keep track of the count of each number
        HashMap<Integer, Integer> numberCount = new HashMap<>();

        // Go through each number, if it exists, return true, else
        // add it to the hashmap
        for (int number: nums){
            if(numberCount.containsKey(number)){
                return true;
            }
            numberCount.put(number, 1);
        }

        // Return false if we never returned true
        return false;
    }
}
