package People;

import Hotel.Hotel;

import java.util.List;

public class Person implements IPersonMenu{

    private String name;

    private String id;

    public Person(String name, String id){
        this.name=name;
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void findHotelWherePersonIs(List<Hotel> hotels) {

        //Loop through hotels
        for(Hotel hotel: hotels){

            //loop first through clients list to see whether the person is a client of the hotel
            List<Client> clients= hotel.getClients();
            for(Client client: clients){
                if(name.equals(client.getPersonName())&&id.equals(client.getId())){
                    System.out.println(client.getPersonName()+" is a client of the hotel "+hotel.getName());
                    break;
                }
            }

            //loop then through the employee lists to see if the client is not actually an employee
            List<HotelEmployee> employees= hotel.getHotelEmployees();
            for(HotelEmployee employee: employees){
                if(name.equals(employee.getPersonName())&&id.equals(employee.getId())){
                    System.out.println(employee.getPersonName()+" is an employee of the hotel "+hotel.getName());
                    break;
                }
            }

        }


    }

    public String getPersonName() {
        return name;
    }


}
