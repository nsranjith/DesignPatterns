package LLD.ParkingLot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingLot {
    int id;
    String address;
    List<Floor> floorList;
    List<Gate> gateList;
}
