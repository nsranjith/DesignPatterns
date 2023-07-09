package LLD.Practice.ParkingLot.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSlot extends BaseModel{
    Vehicle vehicle;
    ParkingSlotStatus status;
}
