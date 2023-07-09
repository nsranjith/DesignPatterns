package LLD.Practice.ParkingLot.dtos;

import LLD.Practice.ParkingLot.model.Gate;
import LLD.Practice.ParkingLot.model.ParkingSlot;
import LLD.Practice.ParkingLot.model.Vehicle;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRequestDto {
    private ParkingSlot parkingSlot;
    private Vehicle vehicle;
    private Gate gate;
}
