package model;

import model.enums.HotelLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC {
    private static Logger logger = LogManager.getLogger(JDBC.class);

    /*
        load driver
        driver manager
        connection
        query stuff
         */

    /**
     * In order to connect to a db you need a user a
     * host, port, name, pass, db, type
     */

    public static void connectToDBAndDoStuff(List<Hotel> hotels) throws SQLException {
        Connection connection = newConnection(
                "localhost",
                "5433",
                "test",
                "postgres",
                "5432",
                "postgresql"
        );

        try {

            //auto-commit set true (default)
//            PreparedStatement statement = connection.prepareStatement("CREATE TABLE hotelz (id int , name VARCHAR(64), location VARCHAR(64), stars INT, PRIMARY KEY(id))");
//            statement.execute();

            Hotel hotel5 = new Hotel.Builder().name("La Nelutzu").stars(4)
                    .location(HotelLocation.CLUJNAPOCA).stars(4).build();
            hotel5.setUuid(551);

            hotels.add(hotel5);

            Hotel hotel6 = new Hotel.Builder().name("La Sanducu").stars(3)
                    .location(HotelLocation.BUCURESTI).stars(4).build();

            hotel6.setUuid(661);

            hotels.add(hotel6);

            Hotel hotel7 = new Hotel.Builder().name("La Raducu")
                    .stars(4).location(HotelLocation.SATUMARE).stars(5).build();
            hotel7.setUuid(771);

            hotels.add(hotel7);


            // Example of auto-commit set to false: rollback if any error
            connection.setAutoCommit(false);

            //non-transactional
            try {
                PreparedStatement statement2 = connection.prepareStatement("insert into hotelz (name) values ('New Hotel');");
                statement2.execute();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                System.out.println("rolling back");
            }

            //transactional flow
            for (Hotel hotel : hotels) {

                PreparedStatement statement3 = connection.prepareStatement("insert into hotelz (id, name, location, stars) values(?,?,?,?);");
                statement3.setInt(1, hotel.getUuid());
                statement3.setString(2, hotel.getName());
                statement3.setString(3, hotel.getLocation());
                statement3.setInt(4, hotel.getStars());
                statement3.execute();
                connection.commit();
            }

            PreparedStatement statement4 = connection.prepareStatement("delete from hotelz where name = 'La Sanducu'");
            statement4.execute();
            connection.commit();

            PreparedStatement statement5 = connection.prepareStatement("update hotelz set stars = 5 where name = 'La Nelutzu';");
            statement5.execute();
            connection.commit();

            Statement statement6 = connection.createStatement();
            ResultSet resultSet = statement6.executeQuery("select name, stars from hotelz;");

            List<Hotel> hotelByNameAndStars = new ArrayList<>();
            while (resultSet.next()) {
                Hotel hotel = new Hotel.Builder().name(resultSet.getString("name"))
                        .stars(resultSet.getInt("stars")).build();
                hotelByNameAndStars.add(hotel);
            }


            hotels.forEach(System.out::println);

        } catch (SQLException e) {
//            try {
//                connection.rollback();
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            }
            e.printStackTrace();
        }
    }


    private static Connection newConnection(String host, String port, String dbName, String user,
                                            String password, String type) {

        loadDriver();

        String url = "jdbc:" + type + "://" + host + ":" + port + "/" + dbName + "?user=" +
                user + "&password=" + password;


        System.out.println(url);

        try {
            return DriverManager.getConnection(url);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static void loadDriver() {

        try {
            logger.debug("Postgresal Driver is loading");

            Class.forName("org.postgresql.Driver").newInstance();

        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}




