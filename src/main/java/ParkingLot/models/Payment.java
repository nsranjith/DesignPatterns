package ParkingLot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {
    int id;
    PaymentMode mode;
    PaymentStatus paymentStatus;
}
