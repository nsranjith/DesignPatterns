package ParkingLot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Bill {
    int id;
    Ticket ticket;
    List<Payment> paymentList;
    int startTime;
    int endTime;
    BillStatus billStatus;
    int amount;
    ParkingSlot parkingSlot;
    Gate gate;
}
