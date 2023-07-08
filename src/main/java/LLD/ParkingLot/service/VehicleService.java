package LLD.ParkingLot.service;

import LLD.ParkingLot.models.Vehicle;
import LLD.ParkingLot.models.VehicleType;

public class VehicleService {
    public Vehicle getVehicleDetails(String vehicleNumber){
        return null;
    }

    public boolean doesExists(String vehicleNumber){
        return false;
    }

    public Vehicle createVehicle(String vehicleNumber, VehicleType vehicleType) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(vehicleType);
        vehicle.setVehicleNumber(vehicleNumber);
        return vehicle;
    }
}
