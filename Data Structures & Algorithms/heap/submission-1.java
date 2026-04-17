class MinHeap {
    // Create a variable to store a heap
    List<Integer> heap;

    public MinHeap() {
        // Initilize a new empty minHeap ( array underneath )
        this.heap = new ArrayList<>();
    }

    public void push(int val) {
        // Insert the element at the end of the minHeap
        this.heap.add(val);

        // Bubble-up until the "order" property is not valid
        int currIndex = this.heap.size() - 1;
        while(currIndex > 0 && (this.heap.get(currIndex) < this.heap.get((currIndex - 1) / 2))){
            int root = this.heap.get((currIndex - 1) / 2);
            this.heap.set(((currIndex - 1) / 2), this.heap.get(currIndex));
            this.heap.set(currIndex, root);
            currIndex = (currIndex - 1) / 2;
        }
    }

    public Integer pop() {
        // Check if the heap is not empty
        if(this.heap.isEmpty()){
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
        int currIndex = 0;
        while((2 * currIndex) + 1 < this.heap.size()){
            int leftChildIndex = (2 * currIndex) + 1;
            int rightChildIndex = (2 * currIndex) + 2;

            // Case 1: When the rightChild is smaller than the leftChild + currentNode
            if ( 
                rightChildIndex < this.heap.size() && // Right child exits?
                this.heap.get(rightChildIndex) < this.heap.get(leftChildIndex) && // Is the rightChild smaller than the leftchild?
                this.heap.get(currIndex) > this.heap.get(rightChildIndex) // Is the currChild greater than rightChild? i.e also from both?
               )
            {
                int temp = this.heap.get(rightChildIndex);
                this.heap.set(rightChildIndex, this.heap.get(currIndex));
                this.heap.set(currIndex, temp);
                currIndex = rightChildIndex;
            }

            // Case 2: When the leftChild is smaller than the rightChild + currentNode
            else if (
                this.heap.get(leftChildIndex) < this.heap.get(currIndex)
            ){
                int temp = this.heap.get(leftChildIndex);
                this.heap.set(leftChildIndex, this.heap.get(currIndex));
                this.heap.set(currIndex, temp);
                currIndex = leftChildIndex;
            }

            // Case 3: Neither is smaller than the currentNode, exit
            else {
                break;
            }
        }

        return highestPriorityItem;
    }

    public Integer top() {
        // Check if the heap is not empty
        if(this.heap.isEmpty()){
           return -1; 
        }
        return this.heap.get(0);
    }

    public void heapify(List<Integer> nums) {
        // Make the current array as the heap
        this.heap = nums;

         /* 
          Since the leaf nodes/element satisfy both structure and order
          property, we only need to bubble down the numbers which are non-leaf
          That is, we only look at half of the nodes, which is N // 2
         */

        int currIndex = (this.heap.size() / 2) - 1;

        // TODO: the bubbling down logic is duplicated across the current and pop method.
        //       create a global function to do this.

        while(currIndex >= 0){
            int bubbleDownIndex = currIndex;

            // Keep bubbling down until there are no children
            while((2 * bubbleDownIndex) + 1 < this.heap.size()){
                int leftChildIndex = (2 * bubbleDownIndex) + 1;
                int rightChildIndex = (2 * bubbleDownIndex) + 2;

                // Case 1: When the rightChild is smaller than the leftChild + currentNode
                if ( 
                    rightChildIndex < this.heap.size() && // Right child exits?
                    this.heap.get(rightChildIndex) < this.heap.get(leftChildIndex) && // Is the rightChild smaller than the leftchild?
                    this.heap.get(bubbleDownIndex) > this.heap.get(rightChildIndex) // Is the currChild greater than rightChild? i.e also from both?
                ){
                    int temp = this.heap.get(rightChildIndex);
                    this.heap.set(rightChildIndex, this.heap.get(bubbleDownIndex));
                    this.heap.set(bubbleDownIndex, temp);
                    bubbleDownIndex = rightChildIndex;
                }

                // Case 2: When the leftChild is smaller than the rightChild + currentNode
                else if (
                    this.heap.get(leftChildIndex) < this.heap.get(bubbleDownIndex)
                ){
                    int temp = this.heap.get(leftChildIndex);
                    this.heap.set(leftChildIndex, this.heap.get(bubbleDownIndex));
                    this.heap.set(bubbleDownIndex, temp);
                    bubbleDownIndex = leftChildIndex;
                }

                // Case 3: Neither is smaller than the currentNode, exit
                else{
                    break;
                }
            }

            // Move to the next element to bubble down
            currIndex--;
        }
    }
}
