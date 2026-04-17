// Pair class to hold a key, value pair of elements
public class Pairs {
    int key;
    int value;

    public Pairs(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class HashTable {
    // Instance variables:- 
    // size - number of elements in the hashtable
    // capacity - maximum capacity of the hashtable
    // hashArray - array to hold the key-val pairs
    int size;
    int capacity;
    Pairs[] hashArray;

    public HashTable(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.hashArray = new Pairs[capacity];
    }

    public void insert(int key, int value) {
        // Get the index hash for the key
        int indexHash = key % this.getCapacity();
        
        // Keep finding an empty spot to insert the value
        while(true){
            if(this.hashArray[indexHash] == null){
                this.hashArray[indexHash] = new Pairs(key, value);
                this.size++;
                
                // Check if adding the current element consumed more than half of the capacity
                if((double) this.getSize() / this.getCapacity() >= 0.5){
                    resize();
                }
                return;
            }
    
            // If the key is a duplicate, replace the value
            else if(this.hashArray[indexHash].key == key){
                this.hashArray[indexHash].value = value;
                return;
            }
            
            // If we didn't return, meaning an empty slot was not found, move to next
            indexHash++;
            indexHash = indexHash % this.getCapacity(); // It is possible we overflowed, adjust
        }
    }

    public int get(int key) {
        // Get the index hash for the key
        int indexHash = key % this.getCapacity();

        while (this.hashArray[indexHash] != null) {
            if (this.hashArray[indexHash].key == key) {
                return this.hashArray[indexHash].value;
            }
            indexHash++;
            indexHash = indexHash % this.getCapacity(); // It is possible we overflowed, adjust
        }
        return -1; // Key not found
    }

    public boolean remove(int key) {
        // Get the index hash for the key
        int indexHash = key % this.getCapacity();

        // If the key is present remove it, else return false
        while (this.hashArray[indexHash] != null){
            if(this.hashArray[indexHash].key == key){
                this.hashArray[indexHash] = null;
                this.size--;
                return true;
            }
            indexHash++;
            indexHash = indexHash % this.getCapacity(); // It is possible we overflowed, adjust
        }
        
        return false;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void resize() {
        // Retain the old hashArray for copying later
        Pairs[] oldHashArray = this.hashArray;

        // Double the capacity of the current hashArray and set the size to 0, as it starts empty/null
        this.capacity = this.getCapacity() * 2;
        this.hashArray = new Pairs[this.getCapacity()];
        this.size = 0;

        // Go through each index in the old hashArray and insert into the newHashArray
        for(Pairs element: oldHashArray){
            if(element != null){
                this.insert(element.key, element.value);
            }
        }
    }
}
