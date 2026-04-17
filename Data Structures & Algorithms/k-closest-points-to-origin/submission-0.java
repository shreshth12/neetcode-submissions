class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Create a minType priority queue / heap
        PriorityQueue<Map.Entry<Double, int[]>> pq = new PriorityQueue<>(
            Comparator.comparingDouble(Map.Entry::getKey) // Compare by Integer key only
        );

        // Go through each of the points and add its distance
        // from origin into the priority queue
        for(int[] point: points){
            double distance = Math.sqrt((point[0] * point[0]) + (point[1] * point[1]));
            pq.add(Map.entry(distance, new int[]{point[0], point[1]}));
        }

        // Create an array to store the output
        int[][] outputArray = new int[k][2];
        int arrayIndex = 0;

        // Pop k times from the pq
        while(k > 0){
            Map.Entry<Double, int[]> entry = pq.poll();
            outputArray[arrayIndex++] = entry.getValue();
            k--;
        }

        // Return the result
        return outputArray;
    }
}
