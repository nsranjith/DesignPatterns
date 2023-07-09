package LLD.Practice.ParkingLot.strategy;

import LLD.Practice.ParkingLot.model.ParkingLot;
import LLD.Practice.ParkingLot.model.ParkingSlot;
import LLD.Practice.ParkingLot.model.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSlot assignSpot(ParkingLot parkingLot, VehicleType vehicleType);
}
