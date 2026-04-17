// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {

        // Create an arrayList to store each state during sorting
        List<List<Pair>> stateList = new ArrayList<>();
        
        // If there are no elements in the given pairs argument then return
        if(pairs.size() == 0){
            return stateList;
        }

        // Add the first state of iteration
        stateList.add(copy(pairs));

        // Iterate through the given list of pairs starting from first index
        for(int main_pointer = 1; main_pointer < pairs.size(); main_pointer++){
            // If the current index is not sorted. That is
            // if the pairs[main_pointer] < pairs[main_pointer - 1]
            // then keep bubbling it to the left until its sorted
            int before_index = main_pointer - 1;
            while (before_index >= 0 && pairs.get(before_index + 1).key < pairs.get(before_index).key){
                Pair temp = pairs.get(before_index);
                pairs.set(before_index, pairs.get(before_index + 1));
                pairs.set(before_index + 1, temp);
                before_index--;
            }

            // At the end of each iteration, add its state
            stateList.add(copy(pairs));
        }

        // Return the final output
        return stateList;
    }

    // Create a function to deep copy a List<List<Pair>>
    public List<Pair> copy(List<Pair> pairs){
        // Create a list to hold copied Pairs
        List<Pair> deepCopyPairs = new ArrayList<>();

        // Iterate through each pair and create a new object of the pair
        // and add the new pair to the deepCopyPairs arrayList
        for (Pair p : pairs) {
                Pair copyPair = new Pair(p.key, p.value);
                deepCopyPairs.add(copyPair);
        }
        return deepCopyPairs;
    }

}
