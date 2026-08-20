class Node{
    int key, value, cnt;
    Node next, prev;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        cnt = 1;
    }
}
class Pair<H, T>{
    H first;
    T second;
    Pair(H first, T second){
        this.first = first;
        this.second = second;
    }
}
class LFUCache {
    int capacity;
    HashMap<Integer, Node> cache;
    HashMap<Integer, Pair<Node, Node>> freqMap;
    int minfreq = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        freqMap = new HashMap<>(); 
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        moveToFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        // if present update value and move to front
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            moveToFront(node);
        }else{
            // capacity increases remove the LFU and add the node
            if(cache.size() == capacity){
                Node node = freqMap.get(minfreq).second.prev;
                cache.remove(node.key);
                removeNode(node);

                if(freqMap.get(minfreq).first.next == freqMap.get(minfreq).second){
                    freqMap.remove(minfreq);
                }
            }

            Node node = new Node(key, value);
            cache.put(key, node);

            minfreq = 1;
            addNode(node, 1);
        }
    }

    private void addNode(Node node, int freq){
        if(!freqMap.containsKey(freq)){
            Node head = new Node(-1, -1);
            Node tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            freqMap.put(freq, new Pair<>(head, tail));
        }
        Node head = freqMap.get(freq).first;
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }

    private void removeNode(Node node){
        Node delprev = node.prev;
        Node delnext = node.next;
        delprev.next = delnext;
        delnext.prev = delprev;
    }

    private void moveToFront(Node node){
        int oldFreq = node.cnt;
        removeNode(node);
        if(freqMap.get(oldFreq).first.next == freqMap.get(oldFreq).second){
            freqMap.remove(oldFreq);
            if(oldFreq == minfreq){
                minfreq++;
            }
        }
        node.cnt++;
        addNode(node, node.cnt);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */