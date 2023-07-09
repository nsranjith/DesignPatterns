package LLD.Practice.ParkingLot;

import collections.HashMap;

public class ObjectRegistry {
    HashMap<String,Object> objects=new HashMap<>();
    public void register(String name, Object object){
        objects.put(name,object);
    }
    public Object get(String name){
        return objects.get(name);
    }
}
