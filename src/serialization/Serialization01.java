package serialization;

import java.io.*;

public class Serialization01 {
    public static void main(String[] args) {
        Vehicle bike = new Vehicle("Bike",2000,'B');
        Vehicle car = new Vehicle("Car",7000,'C');
        Vehicle truck = new Vehicle("Truck",55000,'T');

     try(FileOutputStream fos = new FileOutputStream("C:\\Users\\Asim\\IdeaProjects\\advanced_java\\FolderToWrite\\Vehicle.dat")){

         ObjectOutputStream vehicle = new ObjectOutputStream(fos);
         vehicle.writeObject(bike);
         vehicle.writeObject(car);
         vehicle.writeObject(truck);
         System.out.println("Objects are written");

     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     }


    }
}
class Vehicle implements Serializable {
    private static final long serialVersionUID = 153453453456345L;
    private String type;
    private double price;
    private char initial;

    public Vehicle(String type, double price, char initial) {
        this.type = type;
        this.price = price;
        this.initial = initial;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", initial=" + initial +
                '}';
    }
}

class ReadableObjects{

    public static void main(String[] args) {


    try(FileInputStream fis = new FileInputStream("C:\\Users\\Asim\\IdeaProjects\\advanced_java\\FolderToWrite\\Vehicle.dat")){

        ObjectInputStream obj = new ObjectInputStream(fis);
        Vehicle vBike =(Vehicle)  obj.readObject();
        Vehicle vCar =(Vehicle)  obj.readObject();
        Vehicle vTruck =(Vehicle)  obj.readObject();

        System.out.println(vBike);
        System.out.println(vCar);
        System.out.println(vTruck);

    }catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    }
}