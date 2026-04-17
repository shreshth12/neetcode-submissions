class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Create a priority queue to keep track of smallest elements in nums
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Go through each element in nums array and add it to the queue
        for(int number: nums){
            pq.add(number);
            
            // If adding this number resulted in a size greater than
            // k then pop the smallest element. This ensures that we
            // only keep the k largest elements in our queue
            if(pq.size() > k){
                pq.poll();
            }
        }

        // At this point our heap/priority queue will have the kth largest
        // at the top/root of the pq, so return that
        return pq.poll();
    }
}
