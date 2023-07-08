package LLD.ParkingLot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {
    int id;
    String vehicleNumber;
    VehicleType vehicleType;
}
