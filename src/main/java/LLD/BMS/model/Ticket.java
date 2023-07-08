package LLD.BMS.model;

import java.util.List;

public class Ticket {
    long id;
    Show show;
    List<ShowSeat> showSeatList;
    long amount;
    TicketStatus tickeStatus;
    List<Payment> paymentList; //supports partial payment
}
