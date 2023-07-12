package LLD.Practice.ParkingLot;

import LLD.Practice.ParkingLot.dtos.CreateRequestDto;
import LLD.Practice.ParkingLot.strategy.RandomSpotAssignmentStrategy;
import LLD.Practice.ParkingLot.repositories.ParkingLotRepository;
import LLD.Practice.ParkingLot.repositories.ParkingSpotRepository;
import LLD.Practice.ParkingLot.repositories.TicketRepository;

public class Client {
    public static void main(String[] args) {
        ObjectRegistry objectRegistry=new ObjectRegistry();
        objectRegistry.register("parkingLotRepo", new ParkingLotRepository());
        objectRegistry.register("parkingSpotRepo", new ParkingSpotRepository());
        objectRegistry.register("ticketRepo", new TicketRepository());
        objectRegistry.register("SpotAssignment", new RandomSpotAssignmentStrategy());
//        objectRegistry.register("ticketService",new TiobjectRegistry.get("ticketRepo"));
        CreateRequestDto createRequestDto=new CreateRequestDto();
        createRequestDto.setGate(null);
        createRequestDto.setVehicle(null);
    }
}
