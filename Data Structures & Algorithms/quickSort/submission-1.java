// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        // If the array is empty or has a single element, then return since its already sorted
        if (pairs == null || pairs.size() <= 1) {
            return pairs;
        }
        
        // Perform sorting and then return the number
        quickSelect(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    public static void quickSelect(List<Pair> array, int start, int end) {
        // Base case: At single element, exit
        if(start >= end){
            return;
        }

        // Get the pivot and put all the elements less than it
        // on the left side, leaving the greater ones on right
        Pair pivot_number = array.get(end);
        int replacement_index = start;
        for (int i = start; i < end; i++){
            if(array.get(i).key < pivot_number.key){
                Pair temp = array.get(replacement_index);
                array.set(replacement_index, array.get(i));
                array.set(i, temp);
                replacement_index++;
            }
        }

        // Put the pivot at the index where the arrays get divided
        array.set(end, array.get(replacement_index));
        array.set(replacement_index, pivot_number);

        // Continue the sorting at the left and right portions of the array
        quickSelect(array, start, replacement_index - 1);
        quickSelect(array, replacement_index + 1, end);
    }
}
