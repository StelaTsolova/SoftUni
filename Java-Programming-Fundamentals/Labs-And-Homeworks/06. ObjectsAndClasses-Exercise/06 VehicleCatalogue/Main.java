package VehicleCatalogue_6;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<Vehicles> vehiclesAll = new ArrayList<>();
        while (!input[0].equals("End")) {
            String type = input[0];
            String model = input[1];
            String color = input[2];
            int horsepower = Integer.parseInt(input[3]);
            Vehicles vehicles = new Vehicles(type, model, color, horsepower);
            vehiclesAll.add(vehicles);
            input = scanner.nextLine().split(" ");
        }
        String input2 = scanner.nextLine();
        while (!input2.equals("Close the Catalogue")) {
            for (Vehicles vehicles : vehiclesAll) {
                if (input2.equals(vehicles.getModel())) {
                    String type = vehicles.getType();
                    String model = vehicles.getModel();
                    String color = vehicles.getColor();
                    int horsepower = vehicles.getHorsepower();
                    vehicles.printVehicles(type, model, color, horsepower);
                    break;
                }
            }
            input2 = scanner.nextLine();
        }
        int counterCar = 0;
        int counterTruck = 0;
        int carHorsepower = 0;
        int truckHorsepower = 0;
        for (Vehicles vehicles : vehiclesAll) {
            if (vehicles.getType().equals("Car")) {
                carHorsepower += vehicles.getHorsepower();
                counterCar++;
            } else if(vehicles.getType().equals("Truck")) {
                truckHorsepower += vehicles.getHorsepower();
                counterTruck++;
            }
        }
        if(counterCar>0){
            double averageCarHorsepower =  getAverageHorsepower (carHorsepower, counterCar);
            System.out.println(String.format("Cars have average horsepower of: %.2f.",averageCarHorsepower));
        }else {
            System.out.println(String.format("Cars have average horsepower of: 0.00."));
        }
        if(counterTruck>0){
            double averageTruckHorsepower = getAverageHorsepower (truckHorsepower, counterTruck);
            System.out.println(String.format("Trucks have average horsepower of: %.2f.",averageTruckHorsepower));
        }else {
            System.out.println(String.format("Trucks have average horsepower of: 0.00."));
        }
    }

    public static double getAverageHorsepower(double horsepower, int counter){
        return horsepower/counter;
    }
}