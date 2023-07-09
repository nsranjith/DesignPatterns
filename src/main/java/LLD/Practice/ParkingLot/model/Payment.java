package LLD.Practice.ParkingLot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseModel {
    String referenceId;
    Bill bill;
    PaymentStatus paymentStatus;
}
