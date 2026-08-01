class MyHashSet {
    private ArrayList<LinkedList<Integer>> list;
    private int capacity = 16;
    private int size = 0;
    public MyHashSet() {
        list = new ArrayList<>(16);
        for (int i = 0; i < capacity; i++) {
            list.add(null);
        }
    }
    private int hash(int key){
        return key ^ (key >>> 16);
    }
    private int getIndex(int hash){
        return hash & (this.capacity -1);
    }
    private void rehash(){
        int newSize = capacity * 2;
        
        ArrayList<LinkedList<Integer>> oldList = new ArrayList<>(list);
        list = new ArrayList<>(newSize);
        this.capacity = newSize;
        this.size = 0;

        for (int i = 0; i < capacity; i++) {
            list.add(null);
        }
        

        Iterator<LinkedList<Integer>> it = oldList.iterator();
        while(it.hasNext()){
            LinkedList<Integer> val = it.next();
            if(val == null) continue;

            Iterator<Integer> i = val.iterator();
            while(i.hasNext()){
                int v = i.next();
                add(v);
            }
        }
    }
    public void add(int key) {
        int has = hash(key);
        int index = getIndex(has);

        LinkedList<Integer> l = list.get(index);
        if(l==null) {
            l = new LinkedList<Integer>();
            list.set(index, l);
        }

        if(l.contains(key)) return;

        l.add(key);
        size++;
        if((double)size/capacity > 0.75){
            rehash();
        }
    }
    
    public void remove(int key) {
        int h = hash(key);
        int index = getIndex(h);

        LinkedList<Integer> l = list.get(index);
        if(l==null) return;

        if(l.contains(key)) {
            l.remove(Integer.valueOf(key));
            size--;
        }
    }
    
    public boolean contains(int key) {
        int h = hash(key);
        int index = getIndex(h);

        LinkedList<Integer> l = list.get(index);

        if(l == null) return false;
        return l.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */