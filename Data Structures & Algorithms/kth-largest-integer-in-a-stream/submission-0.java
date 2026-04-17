class KthLargest {
    // Create a minHeap/array to track all items
    List<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        // Initilize a new empty minHeap ( array underneath )
        this.heap = new ArrayList<>();
        this.k = k;

        // Add each element in nums into the heap
        for(int number: nums){
            insert(number);
        }

        // Now we need to maintain only k items in the heap
        // since that denotes that the kth largest is currently
        // at the top of the heap ( index = 0 )
        while (this.heap.size() > k){
            pop();
        }
    }
    
    public int add(int val) {
        // Add the current value to the heap
        insert(val);

        // Now we need to maintain only k items in the heap
        // since that denotes that the kth largest is currently
        // at the top of the heap ( index = 0 )
        while (this.heap.size() > k){
            pop();
        }

        // At this point in time, we have the kth largest at top, return that
        return this.heap.get(0);
    }


    /*
     * This method takes in a single argument: value
     * and inserts the given value inside the minHeap.
     * In order to maintain the "structure" property, the
     * value is first inserted at the end of the heap/array
     * and then bubbled up until the "order" property is
     * not satisfied.
     */
    public void insert(int value){
        // Insert the element at the end of the minHeap
        this.heap.add(value);

        // Bubble-up until the "order" property is not valid
        int curr_idx = this.heap.size() - 1;
        while(curr_idx > 0 && (this.heap.get(curr_idx) < this.heap.get((curr_idx - 1) / 2))){
            int root = this.heap.get((curr_idx - 1) / 2);
            this.heap.set(((curr_idx - 1) / 2), this.heap.get(curr_idx));
            this.heap.set(curr_idx, root);
            curr_idx = (curr_idx - 1) / 2;
        }
    }

    /*
     * This method does not need any parameter, as it pops/removes
     * the element based on the priority of the heap (min in this case)
     * In order to maintain the "structure" property, the root element is
     * popped and is swapped with the last element. Then to maintain the
     * "order" property, it is bubbled down in the tree/array.
     */
    public int pop(){
        // Check if the heap is not empty
        if(heap.isEmpty()){
           return -1; 
        }

        // If the heap only has a single item
        // then remove the current item and return
        if(this.heap.size() == 1){
            return this.heap.remove(0);
        }

        // Swap the highest priority item/element with
        // the lowest priority item (end of the array)
        // then remove the last item
        int highestPriorityItem = this.heap.get(0);
        this.heap.set(0, this.heap.get(this.heap.size() - 1));
        this.heap.remove(this.heap.size() - 1);

        // Bubble the current highestPriorityItem until the "order" is correct
        int curr_idx = 0;
        while((2 * curr_idx) + 1 < this.heap.size()){
            int leftChildIndex = (2 * curr_idx) + 1;
            int rightChildIndex = (2 * curr_idx) + 2;

            // Case 1: When the rightChild is smaller than the leftChild + currentNode
            if ( 
                rightChildIndex < this.heap.size() && // Right child exits?
                this.heap.get(rightChildIndex) < this.heap.get(leftChildIndex) && // Is the rightChild smaller than the leftchild?
                this.heap.get(curr_idx) > this.heap.get(rightChildIndex) // Is the currChild greater than rightChild? i.e also from both?
               )
            {
                int temp = this.heap.get(rightChildIndex);
                this.heap.set(rightChildIndex, this.heap.get(curr_idx));
                this.heap.set(curr_idx, temp);
                curr_idx = rightChildIndex;
            }

            // Case 2: When the leftChild is smaller than the rightChild + currentNode
            else if (
                this.heap.get(leftChildIndex) < this.heap.get(curr_idx)
            ){
                int temp = this.heap.get(leftChildIndex);
                this.heap.set(leftChildIndex, this.heap.get(curr_idx));
                this.heap.set(curr_idx, temp);
                curr_idx = leftChildIndex;
            }

            // Case 3: Neither is smaller than the currentNode, exit
            else {
                break;
            }
        }

        return highestPriorityItem;
    }

}