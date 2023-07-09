package LLD.Practice.ParkingLot.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Ticket extends BaseModel{
    Operator generatedBy;
    Date generatedAt;
    Gate gate;
    ParkingSlot parkingSlot;
}
