package ParkingLot.strategies;

import ParkingLot.models.Gate;
import ParkingLot.models.ParkingSlot;
import ParkingLot.models.VehicleType;
import ParkingLot.repositories.ParkingSlotRepository;

public class RandomStrategy implements SlotAssigmentStrategy{
    private ParkingSlotRepository parkingSlotRespository;

    public RandomStrategy(ParkingSlotRepository parkingSlotRespository) {
        this.parkingSlotRespository = parkingSlotRespository;
    }

    @Override
    public ParkingSlot assignSlot(VehicleType vehicleType, Gate gate) {
        ParkingSlot parkingSlot = new ParkingSlot();
        //get all the slots available based on the vehicle type
        // pick the nearest floor
        return null;
    }
}
