package LLD.Practice.ParkingLot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle extends BaseModel{
    String vehicleId;
    VehicleType vehicleType;
}
