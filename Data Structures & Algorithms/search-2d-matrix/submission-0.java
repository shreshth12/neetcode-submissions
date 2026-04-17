class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Create two pointers top, bottom to capture the length of the grid
        int top = 0;
        int bottom = matrix.length - 1;

        // Get the length of the column
        int columnLength = matrix[0].length - 1;

        // Keep closing the box until we are able to find the integer or get out of bounds
        while(top <= bottom){
            // Get the middle row
            int middle_row = top + (bottom - top) / 2;

            // If the number is larger than the largest number in this row
            // then proceed to the next row
            if(target > matrix[middle_row][columnLength]){
                top = middle_row + 1;
            }

            // If the number is smaller than the smallest number in this row
            // then go to the previous row
            else if(target < matrix[middle_row][0]){
                bottom = middle_row - 1;
            }

            // Else, the number should be in this row, find it and return if found
            else{
                return binarySearch(matrix[middle_row], target);
            }
        }

        // If we never returned anything, meaning we couldn't find
        return false;

    }

    public boolean binarySearch(int[] array, int target){
        // Create two pointers to keep track of left and right boundaries
        int left = 0;
        int right = array.length - 1;
        
        // Keep iterating through the array, while halving them until the
        // given number is found, or the pointers cross each other, meaning
        // not found
        while(left <= right){
            // Get the middle index
            int middle_index = left + (right - left) / 2;

            // Check if the target is greater than the middle index
            // If yes, then search on the right half
            if(target > array[middle_index]){
                left = middle_index + 1;
            }

            // Check if the target is less than the middle index
            // If yes, then search on the left half
            else if(target < array[middle_index]){
                right = middle_index - 1;
            }

            // Else it means we found the target at middle, return true
            else{
                return true;
            }
        }

        // If we were never able to return an index from the while loop, it means
        // we were never able to find the target, so return a false
        return false;
    }
}
