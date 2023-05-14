package ParkingLot.strategies;

import ParkingLot.models.Gate;
import ParkingLot.models.ParkingSlot;
import ParkingLot.models.VehicleType;

public interface SlotAssigmentStrategy {
    ParkingSlot assignSlot(VehicleType vehicleType, Gate gate);
}
