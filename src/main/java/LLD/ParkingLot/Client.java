package LLD.ParkingLot;

import LLD.ParkingLot.controllers.TicketController;
import LLD.ParkingLot.dto.ResponseStatus;
import LLD.ParkingLot.dto.TicketRequestDTO;
import LLD.ParkingLot.dto.TicketResponseDTO;
import LLD.ParkingLot.models.VehicleType;
import LLD.ParkingLot.repositories.ParkingSlotRepository;
import LLD.ParkingLot.repositories.TicketRepository;
import LLD.ParkingLot.service.GateSevice;
import LLD.ParkingLot.service.TicketService;
import LLD.ParkingLot.service.VehicleService;
import LLD.ParkingLot.strategies.RandomStrategy;
import LLD.ParkingLot.strategies.SlotAssigmentStrategy;

public class Client {
    public static void main(String[] args) {
        VehicleService vehicleService = new VehicleService();
        GateSevice gateSevice = new GateSevice();
        TicketRepository ticketRepository = new TicketRepository();
        ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();
        SlotAssigmentStrategy assigmentStrategy = new RandomStrategy(parkingSlotRepository);
        TicketService ticketService = new TicketService(vehicleService, gateSevice,
                assigmentStrategy, ticketRepository);
        TicketController ticketController = new TicketController(ticketService);

        ObjectRegistry objectRegistry = new ObjectRegistry();
        objectRegistry.register("vehicleService",vehicleService);
        objectRegistry.register("gateService",vehicleService);

        TicketRequestDTO ticketRequestDTO = new TicketRequestDTO();
        ticketRequestDTO.setGateId(123);
        ticketRequestDTO.setVehicleNo("qdsad");
        ticketRequestDTO.setVehicleType(VehicleType.SUV);

        TicketResponseDTO ticketResponseDTO = ticketController.generateTicket(ticketRequestDTO);
        if(ticketResponseDTO.getResponseStatus() == ResponseStatus.SUCCESS){
            System.out.println(ticketResponseDTO.getTicket());
        }else{
            System.out.println("Failure...");
        }
    }
}
