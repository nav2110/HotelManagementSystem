package service;

import model.Hotel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;

public class IOExamples {

    public static final Logger logger = LogManager.getLogger(IOExamples.class);


    /*
     Methods that read and write files
     called in MainMenu class
     */

    //Read and write with try-and-catch that uses finally to close the non-null files
    public static void readAndWriteFile() throws IOException {
        FileInputStream in = null;

        FileOutputStream out = null;

        try {
            in = new FileInputStream("text.txt");

            out = new FileOutputStream("newtext.txt");

            int c;


            while ((c = in.read()) != -1) {

                out.write(c);

            }

            logger.debug("File read and written without try-with-resources with names of two employees.");

        } catch (IOException e) {

            logger.error("Inside catch block: IOException thrown");

        } finally {

            if (in != null) {

                in.close();
            }

            if (out != null) {

                out.close();
            }
        }
    }

    /**
     * Method that uses try without resources to read and write a file
     */
    public static void tryWithResources() {

        try (
                FileInputStream in = new FileInputStream("text2.txt");

                FileOutputStream out = new FileOutputStream("newtext2.txt");) {

            logger.debug("File read and writen WITH try-with-resources for types of rooms.");

            int c;


            while ((c = in.read()) != -1) {

                out.write(c);

            }
        } catch (IOException e) {
            logger.error("IOException: " + e.getMessage());
        }

    }

    //Method that writes Hotel data in a non-readable file (serialization)
    public static void writeAndReadHotelObject(List<Hotel> hotels) {
        //Write object
        try (ObjectOutputStream hotelsFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("hotels.dat")))) {

            logger.debug("Try block for writing objects to a file.");

            for (Hotel hotel : hotels) {
                hotelsFile.writeObject(hotel);
            }

        } catch (FileNotFoundException e) {
            logger.error(" File was not found when trying to write hotel object to file.");
            e.printStackTrace();
        } catch (IOException e) {
            logger.error(" I/O exception when trying to write hotel object to file.");

            e.printStackTrace();
        }

        //Read Object from a file
        try (ObjectInputStream hotelsFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("hotels.dat")))) {

            logger.debug("Try block for reading objects from a file.");
            //Read to the end of the file
            boolean eof = true;
            while (!eof) {
                try {
                    Hotel hotel = (Hotel) hotelsFile.readObject();

                    logger.debug("Reading hotel name from objectInputStream: " + hotel.getName());
                } catch (EOFException e) {

                    logger.debug("End of file exception." + e.getMessage());
                    eof = true;
                }
            }

        } catch (IOException e) {
            logger.error("IO exception when reading the object file." + e.getMessage());
        } catch (ClassNotFoundException e) {
            logger.error("Class not found exception when reading the object file." + e.getMessage());
        }

    }

}
