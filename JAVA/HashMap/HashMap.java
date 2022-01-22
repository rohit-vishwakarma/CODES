package HashMap;

import java.util.ArrayList;
import java.util.LinkedList;
public class HashMap{

    public class Node{
        int key = 0;
        int value = 0;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return (key +"="+ value);
        }
    }

    LinkedList<Node>[] buckets;
    int noOfElements = 0;
    int maxSizeOfBucket = 0;
    private void intialize(int size){
        buckets = new LinkedList[size];
        for(int i=0; i<size ; i++){
            buckets[i] = new LinkedList<>();
        }
        this.maxSizeOfBucket = size;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int sizeOfMap = this.noOfElements;
        for(int i=0 ; i< this.maxSizeOfBucket ; i++){
            LinkedList<Node> group = this.buckets[i];
            int size = group.size();
            while(size-->0){
                sb.append(group.getFirst());
                if(sizeOfMap>1)
                 sb.append(", ");
                 group.addLast(group.removeFirst());
                 sizeOfMap--;
            }
        }
        sb.append("]");
        return sb.toString(); 
    }

    public HashMap(){
        intialize(10);
    }

    public Integer size(){
        return this.noOfElements;
    }

    public boolean isEmpty(){
        return this.noOfElements==0;
    }

    private LinkedList<Node> group(int key){
        int groupno = groupNo(key);
        return this.buckets[groupno];
    }

    private Integer groupNo(Integer key){
        Integer hc = Math.abs(key.hashCode());
        return hc % maxSizeOfBucket;
    }

    public void put(Integer key, Integer value){
        LinkedList<Node> group = group(key);
        boolean res = containsKey(key);
        if(res){
            group.getFirst().value = value;
        }else{
            Node node = new Node(key,value);
            group.addLast(node);
            this.noOfElements++;
        }
    }

    public Integer get(Integer key){
        LinkedList<Node> group = group(key);
        int size = group.size();
        while(size-->0){
            if(group.getFirst().key == key){
                return group.getFirst().value;
            }
            group.addLast(group.removeFirst());
        }
        return null;
    }
    
    public Integer remove(Integer key){
        LinkedList<Node> group = group(key);
        int size = group.size();
        while(size-->0){
            if(group.getFirst().key == key){
                this.noOfElements--;
                return group.removeFirst().value;
            }
            group.addLast(group.removeFirst());
        }
        return null;
    }

    public boolean containsKey(Integer key){
        LinkedList<Node> group = group(key);
        int size = group.size();
        while(size-->0){
            if(group.getFirst().key == key){
                return true;
            }
            group.addLast(group.removeFirst());
        }
        return false;
    }

    public void allKeysOfGroup(LinkedList<Node> group, ArrayList<Integer> ans){
        int size = group.size();
        while(size-->0){
            ans.add(group.getFirst().key);
            group.addLast(group.removeFirst());
        }
    }

    public ArrayList<Integer> keySet(){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i =0; i<this.maxSizeOfBucket ; i++){
            allKeysOfGroup(this.buckets[i], ans);
        }
        return ans;
    }

    public Integer getOrDefault(Integer key, Integer defaultValue){
        LinkedList<Node> group = group(key);
        int size = group.size();
        while(size-->0){
            if(group.getFirst().key == key){
                return group.getFirst().value;
            }
            group.addLast(group.removeFirst());
        }
        // group.addLast(defaultValue);
        return defaultValue;
    }

    public void putIfAbsent(Integer key, Integer value){
        LinkedList<Node> group = group(key);
        boolean res = containsKey(key);
        if(!res){
            Node node = new Node(key,value);
            group.addLast(node);
            this.noOfElements++;
        }
    }

   
}