package LLD.Practice.ParkingLot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gate extends BaseModel{
    Operator operator;
    GateType gateType;
}
