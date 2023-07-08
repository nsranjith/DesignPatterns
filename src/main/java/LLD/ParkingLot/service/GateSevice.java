package LLD.ParkingLot.service;

import LLD.ParkingLot.models.Gate;
import LLD.ParkingLot.models.GateType;
import LLD.ParkingLot.models.Operator;

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
