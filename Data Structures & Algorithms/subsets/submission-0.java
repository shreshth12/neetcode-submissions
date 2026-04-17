class Solution {
    // Create a global arrayList to hold the solution subsets
    List<List<Integer>> solution = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        generateSubsets(nums, 0, new ArrayList<>());
        return solution;
    }

    /* 
         At each point we can choose to either take the current element
         or skip and move to the next element in the rootArray
    */
    public void generateSubsets(int[] rootArray, int index, ArrayList<Integer> list){
        // Base case: If the index is out of range, that is we reached the end
        // then add whatver solution we could generate
        if(index >= rootArray.length){
            solution.add(new ArrayList<>(list));
            return;
        }

        // Recursive case: We take the current element
        list.add(rootArray[index]);
        generateSubsets(rootArray, index + 1, list);

        // Recursive case: We skip the current element
        list.remove(list.size() - 1);
        generateSubsets(rootArray, index + 1, list);
    }
}
