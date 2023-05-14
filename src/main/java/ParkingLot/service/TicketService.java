package ParkingLot.service;

import ParkingLot.exceptions.InvalidRequestInfo;
import ParkingLot.exceptions.NoParkingSlotException;
import ParkingLot.models.*;
import ParkingLot.repositories.TicketRepository;
import ParkingLot.strategies.SlotAssigmentStrategy;

public class TicketService {
    private VehicleService vehicleService;
    private GateSevice gateSevice;
    private SlotAssigmentStrategy slotAssigmentStrategy;
    private TicketRepository ticketRepository;
    public TicketService(VehicleService vehicleService, GateSevice gateSevice, SlotAssigmentStrategy slotAssigmentStrategy, TicketRepository ticketRepository){
        this.vehicleService=vehicleService;
        this.gateSevice = gateSevice;
        this.slotAssigmentStrategy = slotAssigmentStrategy;
        this.ticketRepository = ticketRepository;
    }
    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType, long gateId) throws InvalidRequestInfo, NoParkingSlotException {
        // 1. getVehicleByNumber
        // 2. Use vehicleRepo to fetch it
        // 3. create New Vehicle

        // Gate service
        // fetch Get details
        Vehicle vehicle = null;
        if(vehicleService.doesExists(vehicleNumber)){
            //
            vehicle = vehicleService.getVehicleDetails(vehicleNumber);
        }else{
            vehicle = vehicleService.createVehicle(vehicleNumber, vehicleType);
        }
        Gate gate = gateSevice.getGateDetails(gateId);
        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
        ParkingSlot parkingSlot = slotAssigmentStrategy.assignSlot(vehicleType, gate);
        if (parkingSlot == null){
            throw new NoParkingSlotException("Unable to allocate a SLOT... Try after some time");
        }
        ticket.setParkingSlot(parkingSlot);
        return ticketRepository.save(ticket);
    }
}
