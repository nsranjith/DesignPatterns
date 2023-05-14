package ParkingLot.dto;

import ParkingLot.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketResponseDTO {
    private Ticket ticket;
    private ResponseStatus responseStatus;
}
