package repository;
/*
The hotel management app adds and removes a list of hotels,
add and list clients and employees to a hotel, find hotels that have available rooms,
get the total costs of a room for a particular client.
 */


import model.Client;
import model.Hotel;
import model.Room;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.*;

import java.util.*;


public class MainMenu {

    private static Logger logger = LogManager.getLogger(MainMenu.class);


    public static void main(String[] args) throws Exception {
        /*
        The exception is handled in the client class (model package)
        for the method getTotalCosts for
        the case in which the users enters by mistake a negative number of nights.
         */

        logger.debug("Test for log4j");

        //Creating a list of hotels that will be passed to all the static methods in the service repository,
        List<Hotel> hotels = new ArrayList<>();

        //Adding hotels to the hotel list
        AddHotels.addHotels(hotels);


        AddEmployees.addEmployees(hotels);


        AddClients.addClientsAndRooms(hotels);

        removeHotels(hotels);

        HotelService.listHotels(hotels);

        ClientsService.listClientsOfAHotel(hotels);

        EmployeeService.listEmployeesOfAHotel(hotels);

        Information information = new Information(hotels);
        information.findHotelRoom();

        IOExamples.readAndWriteFile();

        IOExamples.tryWithResources();

        IOExamples.writeAndReadHotelObject(hotels);


        setClients();

        sortListOfHotelsAndRoomsByStars(hotels);

        mapHotels(hotels);


    }

    private static void mapHotels(List<Hotel> hotels) {
        //Set random UUID numbers for hotels

        Map<Long, List<Room>> uuidRooms = new HashMap<>();

        Random rand = new Random();

        for (Hotel hotel : hotels) {

            hotel.setUuid(rand.nextLong());

            long key = hotel.getUuid();

            List<Room> rooms = hotel.getRooms();

            uuidRooms.put(key, rooms);

        }

        for (Map.Entry entry : uuidRooms.entrySet()) {

            List<Room> rooms = (List<Room>) entry.getValue();
            if (rooms.size() == 0) {
                continue;
            }
            logger.info("Number of rooms for hotel" +
                    " with UUID: " + entry.getKey() + " is " + (rooms.size() - 1));

        }


    }

    private static void sortListOfHotelsAndRoomsByStars(List<Hotel> hotels) {

        Collections.sort(hotels, new Comparator<Hotel>() {
            @Override
            public int compare(Hotel h1, Hotel h2) {
                return Integer.valueOf(h2.getStars()).compareTo(h1.getStars());
            }
        });

        logger.info("Sorted hotels by number of stars in descending order: ");
        for (Hotel hotel : hotels) {

            logger.info(hotel.getName() + " has " + hotel.getStars() +
                    "stars. It has the following types of room in ascending order by name:");

            sortRooms(hotel);
        }


    }

    private static void sortRooms(Hotel hotel) {
        List<Room> rooms = hotel.getRooms();

        Collections.sort(rooms, new Comparator<Room>() {
            @Override
            public int compare(Room r1, Room r2) {
                return String.valueOf(r1.getType()).compareTo(String.valueOf(r2.getType()));
            }
        });

        for (Room room : rooms) {

            logger.info(room.getType());

        }


    }

    private static void setClients() {
        Set<Client> setOfClients = new HashSet<>();
        //Creating 20 clients: three with the same id


        setOfClients.add(new Client("Gigi", "123", "3333"));
        setOfClients.add(new Client("Gigi", "123", "3333"));
        setOfClients.add(new Client("Gigi", "123", "3333"));

        for (int i = 3; i < 20; i++) {
            Random rand = new Random();

            int idnr = rand.nextInt(50);

            int creditCardNr = rand.nextInt(1000);

            String id = Integer.toString(idnr);

            String creditCard = Integer.toString(creditCardNr);

            setOfClients.add(new Client("Gigi", id, creditCard));
        }

        //By overriding the equals and hascode in the Client class we can avoid duplicates in our set
        for (Client client4 : setOfClients) {
            System.out.println(client4);
        }


    }


    protected static void removeHotels(List<Hotel> hotels) {
        //Removes hotel Grand model Pata Rat from the list of hotels

        String name = "Grand model Pata Rat";

        for (int i = 0; i < hotels.size(); i++) {

            if (name.equals(hotels.get(i).getName())) {

                logger.info(hotels.get(i).getName() +
                        " situated in " + hotels.get(i).getLocation() +
                        " has been removed from the list of hotels.");
                hotels.remove(hotels.get(i));
            }
        }
    }
}
