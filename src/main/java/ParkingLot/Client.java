package ParkingLot;

import ParkingLot.controllers.TicketController;
import ParkingLot.dto.ResponseStatus;
import ParkingLot.dto.TicketRequestDTO;
import ParkingLot.dto.TicketResponseDTO;
import ParkingLot.models.Vehicle;
import ParkingLot.models.VehicleType;
import ParkingLot.repositories.ParkingSlotRepository;
import ParkingLot.repositories.TicketRepository;
import ParkingLot.service.GateSevice;
import ParkingLot.service.TicketService;
import ParkingLot.service.VehicleService;
import ParkingLot.strategies.RandomStrategy;
import ParkingLot.strategies.SlotAssigmentStrategy;

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
