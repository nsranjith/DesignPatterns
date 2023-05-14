package ParkingLot.dto;

import ParkingLot.models.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketRequestDTO {
    private String vehicleNo;
    private VehicleType vehicleType;
    private long gateId;
}
