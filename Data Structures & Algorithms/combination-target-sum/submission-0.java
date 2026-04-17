class Solution {
    // Create an arrayList to hold the solution arrays
    List<List<Integer>> solutions = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        combinationSumHelper(nums, new ArrayList<Integer>(), target, 0);
        return solutions;
    }

    // Create a helper function to be able to generate unique combinations
    public void combinationSumHelper(int[] rootArray, ArrayList<Integer> combinationArray, int target, int index){
        // Base case: If we reach our target, add the formed combinationArray
        if(target == 0){
            solutions.add(new ArrayList<Integer>(combinationArray));
            return;
        }

        // Base case: If our target becomes less than 0, meaning we couldn't
        // generate a combination sum using the current set of numbers
        // or our index is out of bounds
        if(target < 0 || index >= rootArray.length){
            return;
        }

        // Recursive case: Take the current number again
        combinationArray.add(rootArray[index]);
        combinationSumHelper(rootArray, combinationArray, target - rootArray[index], index);

        // Recursive case: Do not take the current number
        combinationArray.remove(combinationArray.size() - 1);
        combinationSumHelper(rootArray, combinationArray, target, index + 1);
    }
}
