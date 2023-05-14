package ParkingLot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSlot {
    int id;
    VehicleType vehicleType;
    AvailibityStatus availibityStatus;
}
