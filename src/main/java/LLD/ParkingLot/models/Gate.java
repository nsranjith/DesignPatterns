package LLD.ParkingLot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gate {
    int id;
    Operator operator;
    GateType gateType;
}
