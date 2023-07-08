package LLD.ParkingLot;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ObjectRegistry {
    private Map<String, Object> map = new HashMap<>();
    public void register(String key, Object object){
        map.put(key,object);
    }

}
