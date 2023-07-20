package LLD.Practice.BookMyShow.models;

import java.util.List;

public class Ticket extends BaseModel{
    Show show;
    long amount;
    List<Payment> payments;
    ShowSeat showSeat;
    TicketStatus ticketStatus;
}
