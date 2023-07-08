package LLD.BMS.model;

public class Payment { // always consider partial payment
    long id;
    long amount;
    PaymentMode mode;
    Ticket ticket;
    long transactionId;
    PaymentStatus paymentStatus;

}
