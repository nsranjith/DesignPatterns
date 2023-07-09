package LLD.Practice.ParkingLot.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingFloor extends BaseModel{
    List<ParkingSlot> parkingSlots;
}
