package LLD.ParkingLot.dto;

import LLD.ParkingLot.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketResponseDTO {
    private Ticket ticket;
    private ResponseStatus responseStatus;
}
