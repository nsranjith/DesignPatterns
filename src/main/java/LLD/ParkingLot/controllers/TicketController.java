package LLD.ParkingLot.controllers;

import LLD.ParkingLot.dto.ResponseStatus;
import LLD.ParkingLot.dto.TicketRequestDTO;
import LLD.ParkingLot.dto.TicketResponseDTO;
import LLD.ParkingLot.exceptions.InvalidRequestInfo;
import LLD.ParkingLot.exceptions.NoParkingSlotException;
import LLD.ParkingLot.models.Ticket;
import LLD.ParkingLot.service.TicketService;

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
