package ParkingLot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Floor {
    int id;
    int number;
    List<ParkingSlot> parkingSlotList;
}
