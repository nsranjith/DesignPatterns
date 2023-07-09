package LLD.Practice.ParkingLot.service;

import LLD.ParkingLot.repositories.ParkingSlotRepository;
import LLD.Practice.ParkingLot.dtos.CreateResponseDto;
import LLD.Practice.ParkingLot.model.*;
import LLD.Practice.ParkingLot.strategy.RandomSpotAssignmentStrategy;
import LLD.Practice.ParkingLot.strategy.SpotAssignmentStrategy;
import LLD.Practice.repositories.ParkingLotRepository;
import LLD.Practice.repositories.ParkingSpotRepository;
import LLD.Practice.repositories.TicketRepository;

import java.util.Date;

public class TicketService {
    TicketRepository ticketRepository;
    SpotAssignmentStrategy spotAssignmentStrategy;
    ParkingLotRepository parkingLotRepository;
    ParkingSpotRepository parkingSlotRepository;


    public TicketService(TicketRepository ticketRepository, SpotAssignmentStrategy spotAssignmentStrategy,
                         ParkingLotRepository parkingLotRepository, ParkingSpotRepository parkingSlotRepository) {
        this.ticketRepository = ticketRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSlotRepository = parkingSlotRepository;
    }

    public Ticket createTicket(Vehicle vehicle, Gate gate){
//        Operator generatedBy;
//        Date generatedAt;
//        Gate gate;
//        ParkingSlot parkingSlot;
        Ticket ticket=new Ticket();
        ticket.setGate(gate);
        ticket.setGeneratedBy(gate.getOperator());
        ticket.setGeneratedAt(new Date());
        ParkingSlot parkingSlot=spotAssignmentStrategy.assignSpot(parkingLotRepository.getParkingLostForGate(gate),vehicle.getVehicleType());
        parkingSlotRepository.save(parkingSlot);
        ticket.setParkingSlot(parkingSlot);
        return ticketRepository.save(ticket);
    }
}
