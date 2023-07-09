package LLD.Practice.ParkingLot.strategy;

import LLD.Practice.ParkingLot.model.*;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{
    @Override
    public ParkingSlot assignSpot(ParkingLot parkingLot, VehicleType vehicleType) {
        for(ParkingFloor parkingFloor:parkingLot.getParkingFloors()){
            for(ParkingSlot parkingSlot:parkingFloor.getParkingSlots()){
                if(parkingSlot.getStatus().equals(ParkingSlotStatus.AVAILABLE)){
                    return parkingSlot;
                }
            }
        }
        return null;
    }
}
