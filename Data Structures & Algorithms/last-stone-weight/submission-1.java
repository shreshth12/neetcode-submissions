class Solution {
    public int lastStoneWeight(int[] stones) {
        // Create a priority queue (min) / heap to store all elements
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Since we want the maximum of each stones, we will add
        // the stone weights as negative integers into the pq
        for(int stoneWeight: stones){
            pq.add(stoneWeight * -1);
        }

        // Now, keep running the simulation until we only have a
        // single stone left in the heap
        while(pq.size() > 1){
            int firstHeaviest = pq.poll() * -1;
            int secondHeaviest = pq.poll() * -1;

            // We only need to evaluate case: 2
            if(firstHeaviest > secondHeaviest){
                pq.add((firstHeaviest - secondHeaviest) * -1);
            }
        }
        // If none remain, return 0, else return the weight of last stone
        return (pq.size() == 0) ? 0 : pq.poll() * -1;
    }
}
