package LLD.ParkingLot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {
    int id;
    Vehicle vehicle;
    Gate gate;
    ParkingSlot parkingSlot;
}
