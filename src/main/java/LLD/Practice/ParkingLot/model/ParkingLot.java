package LLD.Practice.ParkingLot.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingLot extends BaseModel {
    List<ParkingFloor> parkingFloors;
    Gate entry;
    Gate exit;
    // GEO details
}
