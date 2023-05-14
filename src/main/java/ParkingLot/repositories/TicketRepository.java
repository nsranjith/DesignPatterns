package ParkingLot.repositories;

import ParkingLot.models.Ticket;
import ParkingLot.service.TicketService;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    int ticketSequence=0;
    private Map<Integer, Ticket> ticketMap = new HashMap<>();
    public Ticket save(Ticket ticket){
        ticketSequence+=1;
        ticket.setId(ticketSequence);
        ticketMap.put(ticketSequence,ticket);
        return ticket;
    }
}
