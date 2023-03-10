import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner inp = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        Garage garage = new Garage();
        do {
            System.out.println("""
                    [1] Enter a vehicle in the garage
                    [2] Remove a vehicle from the garage
                    [3] Print cars info
                    [4] Get available places
                    [5] Add an hour
                    [6] Payment \n>""");

            choice = inp.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Are you parking a car or a bike? [0] Car [1] Bike");
                    int parking = inp.nextInt();
                    if(parking == 0) {
                        String type = "car";

                        System.out.println("Name of the car: ");
                        String name = inp.next();

                        System.out.println("Brand of the car: ");
                        String brandName = inp.next();

                        System.out.print("License Plate: ");
                        String licensePlate = inp.next();

                        System.out.print("Insert the hour: ");
                        int hour = inp.nextInt();
                        Car car = new Car(name, brandName, licensePlate, hour, type);

                        int indexPlace = garage.enterVehicle(car);
                        if (indexPlace != -1) {
                            System.out.println("Vehicle reserved at place: " + indexPlace);
                        } else {
                            System.out.println("Garage is full, unable to reserve more places.\n");
                        }
                    }
                    else if(parking == 1) {
                        String type = "bike";
                        System.out.println("Name of the bike: ");
                        String name = inp.next();

                        System.out.println("Brand of the bike: ");
                        String brandName = inp.next();

                        System.out.print("License Plate: ");
                        String licensePlate = inp.next();

                        System.out.print("Insert the hour: ");
                        int hour = inp.nextInt();
                        Bike bike = new Bike(name, brandName, licensePlate, hour, type);
                        int indexPl = garage.enterVehicle(bike);
                        if (indexPl != -1) {
                            System.out.println("Vehicle reserved at place: " + indexPl);
                        } else {
                            System.out.println("Garage is full, unable to reserve more places.\n");
                        }
                    }
                    break;
                case 2:
                    boolean removed = false;
                    do {
                        System.out.print("Insert the license plate of your car: ");
                        String tempLicensePlate = inp.next();
                        Vehicles vehicletoLeave = null;
                        int placeToLeave = -1;
                        for (Vehicles indexvehicle : garage.getOccupiedPlaces()) {
                            if (indexvehicle.getPlate().equals(tempLicensePlate)) {
                                vehicletoLeave = indexvehicle;
                                placeToLeave = garage.getOccupiedPlaces().indexOf(indexvehicle) + 1;
                            }
                        }
                        if (vehicletoLeave != null) {
                            garage.removeVehicle(vehicletoLeave, placeToLeave);
                            System.out.println("Vehicle succesfully removed from: " + placeToLeave);
                            removed = true;
                        }
                    }while (!removed);

                case 3:
                    //ve.Info();
                    break;
                case 4:
                    System.out.println("Non occupied places [cars] : " + garage.getNonOccupiedCarPlaces());
                    System.out.println("Non occupied places [bike] : " + garage.getNonOccupiedBikePlaces());
                    break;
                case 5:
                    garage.addHour();
                    break;
                case 6:
                    System.out.println("Insert the license plate of the car: ");
                    String tempLicensePlate = inp.next();
                    Vehicles payment = null;
                    for (Vehicles vIndex : garage.getOccupiedPlaces()) {
                        if (vIndex.getPlate().equals(tempLicensePlate)) {
                            payment = vIndex;
                            break;
                        }
                        if (payment != null) {
                            float price = garage.calculatePrice(payment);
                            System.out.println("Price: " + price);
                        } else {
                            System.out.println("Couldn't find a vehicle with that license plate, retry.");
                            break;
                        }
                    }
                default:
                    System.out.println("Wrong choice\n");
            }
        }while (choice!=6);
    }
}

    class Garage {

        private final int maxPlaces = 25;
        private final int carPlaces = 15;
        private final int bikePlaces = 10;
        private int currentHour;
        private ArrayList<Vehicles> vehicles = new ArrayList<>();
        private ArrayList<Vehicles> occupiedPlaces = new ArrayList<>();
        private ArrayList<Integer> nonOccupiedCar = new ArrayList<>();
        private ArrayList<Integer> nonOccupiedBike = new ArrayList<>();

        public Garage(){
            for(int i = 1; i <= carPlaces; i++) {
                nonOccupiedCar.add(i);
            }
            for (int i = carPlaces + 1; i <= maxPlaces; i++) {
                nonOccupiedBike.add(i);
            }
        }

        public int enterVehicle(Vehicles vehicle) {
            int occupiedplace = -1;
            if ((vehicle.getType()).equals("car") && !nonOccupiedCar.isEmpty()) {
                occupiedplace = nonOccupiedCar.remove(0);
                occupiedPlaces.add(vehicle);
            } else if ((vehicle.getType()).equals("bike") && !nonOccupiedBike.isEmpty()) {
                occupiedplace = nonOccupiedBike.remove(0);
                occupiedPlaces.add(vehicle);
            }
            return occupiedplace;
        }

        public void removeVehicle(Vehicles vehicle, int place) {
            occupiedPlaces.remove(vehicle);
            if ((vehicle.getType()).equals("car") && !nonOccupiedCar.isEmpty()) {
                nonOccupiedCar.add(place);
            } else if ((vehicle.getType()).equals("bike") && !nonOccupiedBike.isEmpty()) {
                nonOccupiedBike.add(place);
            }
        }

        public void addHour() {
            currentHour++;
            for (Vehicles vehicle : vehicles) {
                if (vehicle != null) {
                    vehicle.hour += 1;
                }
            }
        }

        public ArrayList<Vehicles> getOccupiedPlaces() {
            return occupiedPlaces;
        }

        public ArrayList<Integer> getNonOccupiedCarPlaces() {
            return nonOccupiedCar;
        }

        public ArrayList<Integer> getNonOccupiedBikePlaces() {
            return nonOccupiedBike;
        }

        public void getBrands(){
            for(Vehicles brandVe : vehicles){
                System.out.println("Vehicle Brands: "+brandVe.getBrand());
            }
        }

        public float calculatePrice(Vehicles vehicle) {
            return vehicle.pricing();
        }
    }

    class Vehicles {
        static String name;
        static String brandName;
        static String licensePlate;
        static int hour;
        static String typeVehicle; //car or bike


        public Vehicles(String name, String brandName, String licensePlate, int hour, String tipeVehicle) {
            this.name = name;
            this.brandName = brandName;
            this.licensePlate = licensePlate;
            this.hour = hour;
            this.typeVehicle = tipeVehicle;
        }


        public int pricing() {
            if (typeVehicle.equals("car")) {
                return 2;
            } else if (typeVehicle.equals("bike")) {
                return 1;
            } else {
                return 0;
            }
        }

        static String getType() {
            if (typeVehicle.equals("car")) {
                return "car";
            } else if (typeVehicle.equals("bike")) {
                return "bike";
            } else {
                return null;
            }
        }

        static String getName(){
            return name;
        }
        static String getPlate(){
            return licensePlate;
        }
        public String getBrand() {
            return brandName;
        }
        public int getHour(){
            return hour;
        }

        /*public void Info() {
            System.out.println("Name: " + getName());
            System.out.println("License plate: " + getPlate());
            System.out.println("Brand: " + getBrand());
            System.out.println("Type: " + getBrand());
            System.out.println("Hour: " + getHour());
        }
        */
    }


    class Car extends Vehicles {

        public Car(String name, String brandName, String licensePlate, int hour, String tipeVehicle) {
            super(name, brandName, licensePlate, hour, tipeVehicle);
        }
    }

    class Bike extends Vehicles {
        public Bike(String name, String brandName, String licensePlate, int hour, String tipeVehicle) {
            super(name, brandName, licensePlate, hour, tipeVehicle);
        }
    }
