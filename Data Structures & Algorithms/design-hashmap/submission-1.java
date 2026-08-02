class MyHashMap {
    private static class Node {
        int key;
        int val;
        Node(int key, int value){
            this.key = key;
            this.val = value;
        }
    }
    private ArrayList<LinkedList<Node>> hashTable;
    private int capacity = 16;
    private int size = 0;
    public MyHashMap() {
        hashTable = new ArrayList<>();
        for(int i=0; i<16; i++){
            hashTable.add(null);
        }
    }
    
    private int hash(int key){
        return key ^ (key >>> 16);
    }

    private int getIndex(int hash){
        return hash & (this.capacity -1);
    }

    private void rehash(){
        int newCapacity = this.capacity * 2;
        this.size = 0;
        this.capacity = newCapacity;

        ArrayList<LinkedList<Node>> oldHashTable = new ArrayList<>(hashTable);
        this.hashTable = new ArrayList<>(newCapacity);
        for(int i=0; i<newCapacity; i++){
            this.hashTable.add(null);
        }

        Iterator<LinkedList<Node>> it = oldHashTable.iterator();

        while(it.hasNext()){
            LinkedList<Node> list = it.next();
            if(list == null ) continue;
            Iterator<Node> i = list.iterator();

            while(i.hasNext()){
                Node n = i.next();
                put(n.key, n.val);
            }
        }
    }

    public void put(int key, int value) {
        int hashValue = hash(key);
        int index = getIndex(hashValue);

        LinkedList<Node> list = hashTable.get(index);
        if(list == null) {
            list = new LinkedList<Node>();
            hashTable.set(index, list);
        }
        Iterator<Node> it = list.iterator();
        
        while(it.hasNext()){
            Node node = it.next();
            if(node.key == key) {
                node.val = value;
                return;
            }
        }
        Node n = new Node(key, value);
        list.add(n);
        this.size++;

        if((double)size/capacity > 0.75){
            rehash();
        }
    }
    
    public int get(int key) {
        int hashValue = hash(key);
        int index = getIndex(hashValue);

        LinkedList<Node> list = hashTable.get(index);
        if(list == null) return -1;

        Iterator<Node> it = list.iterator();
        
        while(it.hasNext()){
            Node node = it.next();
            if(node.key == key) {
                return node.val;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int hashValue = hash(key);
        int index = getIndex(hashValue);

        LinkedList<Node> list = hashTable.get(index);
        if(list == null) return;

        Iterator<Node> it = list.iterator();
        
        while(it.hasNext()){
            Node node = it.next();
            if(node.key == key) {
                it.remove();
                this.size--;
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */