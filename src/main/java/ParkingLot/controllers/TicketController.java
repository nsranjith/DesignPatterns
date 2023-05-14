package ParkingLot.controllers;

import ParkingLot.dto.ResponseStatus;
import ParkingLot.dto.TicketRequestDTO;
import ParkingLot.dto.TicketResponseDTO;
import ParkingLot.exceptions.InvalidRequestInfo;
import ParkingLot.exceptions.NoParkingSlotException;
import ParkingLot.models.Ticket;
import ParkingLot.service.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }
    public TicketResponseDTO generateTicket(TicketRequestDTO ticketRequestDTO){
        TicketResponseDTO ticketResponseDTO = null;
        try {
            Ticket ticket = ticketService.generateTicket(ticketRequestDTO.getVehicleNo(),
                    ticketRequestDTO.getVehicleType(), ticketRequestDTO.getGateId());
             ticketResponseDTO = new TicketResponseDTO();
            ticketResponseDTO.setTicket(ticket);
            ticketResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (InvalidRequestInfo exception){
            ticketResponseDTO = new TicketResponseDTO();
            ticketResponseDTO.setResponseStatus(ResponseStatus.FAILED);
        } catch (NoParkingSlotException e) {
            ticketResponseDTO.setResponseStatus(ResponseStatus.FAILED);
        }
        return ticketResponseDTO;
    }
}
