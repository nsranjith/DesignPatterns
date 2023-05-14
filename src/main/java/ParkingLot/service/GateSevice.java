package ParkingLot.service;

import ParkingLot.models.Gate;
import ParkingLot.models.GateType;
import ParkingLot.models.Operator;

public class GateSevice {
    public Gate getGateDetails(long gateId) {
        Gate gate = new Gate();
        gate.setGateType(GateType.ENTRY);
        Operator operator = new Operator();
        operator.setId(123);
        operator.setName("Ranz");
        gate.setOperator(operator);
        return gate;
    }
}
