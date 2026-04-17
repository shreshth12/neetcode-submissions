// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        // If the array is empty or has a single element, then return since its already sorted
        if (pairs == null || pairs.size() <= 1) {
            return pairs;
        }
        
        // Run the divide function, that will in turn run the merge and sort
        divide(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    public static void divide(List<Pair> array, int left, int right) {
        // Base case: If we cannot divide any futher, return
        if (left >= right){
            return;
        }
        
        // Get the middle point to divide the array into
        int mid = left + (right - left) / 2;

        // Divide into left and right arrays
        divide(array, left, mid);
        divide(array, mid + 1, right);

        // After dividing, merge the two arrays into one and
        // update the merged array into the main array
        merge(array, left, mid, right);

        /*
         * Sorting tree tracedown
         * 
         *                      {5, 1, 3, 2, 3, 0}
         *              {5, 1, 3}               {2, 3, 0}
         *          {5, 1}      {3}         {2, 3}      {0}                   
         *       {5}     {1}             {2}      {3}
         * 
         */
    }

    public static void merge(List<Pair> array, int left, int mid, int right) {
        // Create an array to store the sorted array
        List<Pair> sortedArray = new ArrayList<>();

        // Create three pointers:- 
        // One to iterate the leftSide of the array
        // One to iterate the rightSide of the array
        // One to keep track of index in our sortedArray
        int leftPointer = left;
        int rightPointer = mid + 1;
        int sortedArrayIndex = 0;

        // Iterate through the array and merge them together in sorted order
        while (leftPointer <= mid && rightPointer <= right){
            if(array.get(leftPointer).key <= array.get(rightPointer).key){
                sortedArray.add(array.get(leftPointer));
                leftPointer++;
            }
            else{
                sortedArray.add(array.get(rightPointer));
                rightPointer++;
            }
        }

        // If any of the elements are left in either sides of the array
        // then add those into the sorted array
        while (leftPointer <= mid){
            sortedArray.add(array.get(leftPointer));
            leftPointer++;
        }
        while (rightPointer <= right){
            sortedArray.add(array.get(rightPointer));
            rightPointer++;
        }
        
        // Replace the elements in the main array by the elements in the sortedArray
        sortedArrayIndex = 0;
        for(int i = left; i <= right; i++){
            array.set(i, sortedArray.get(sortedArrayIndex));
            sortedArrayIndex++;
        }
    }
}
