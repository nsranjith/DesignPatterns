package LLD.ParkingLot.strategies;

import LLD.ParkingLot.models.Gate;
import LLD.ParkingLot.models.ParkingSlot;
import LLD.ParkingLot.models.VehicleType;

public interface SlotAssigmentStrategy {
    ParkingSlot assignSlot(VehicleType vehicleType, Gate gate);
}
