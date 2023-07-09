package LLD.Practice.repositories;

import LLD.Practice.ParkingLot.model.Ticket;
import collections.HashMap;

public class TicketRepository {
    static long id=0;
    HashMap<Long,Ticket> map=new HashMap<>();
    public Ticket save(Ticket ticket){
        ticket.setId(++id);
        map.put(id,ticket);
        return ticket;
    }
}
