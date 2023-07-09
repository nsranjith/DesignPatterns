package LLD.Practice.ParkingLot.controller;

import LLD.Practice.ParkingLot.dtos.CreateRequestDto;
import LLD.Practice.ParkingLot.dtos.CreateResponseDto;
import LLD.Practice.ParkingLot.model.Ticket;
import LLD.Practice.ParkingLot.service.TicketService;

public class TicketController {
    private TicketService ticketService;

    TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }

    private CreateResponseDto createTicket(CreateRequestDto createRequestDto){
        Ticket ticket=ticketService.createTicket(createRequestDto.getVehicle(),createRequestDto.getGate());
        CreateResponseDto createResponseDto=new CreateResponseDto();
        createResponseDto.setTicket(ticket);
        return createResponseDto;
    }
}
