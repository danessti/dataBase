import java.time.LocalDateTime;
import java.util.*;

import List.CustomGenericStack;
import List.CustomInStack;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        DataBase db = new DataBase();

        List<Passenger> passengers = new ArrayList<>(db.getAllPassengers());

        buildDataStructures(db, passengers);

        LocalDateTime time = LocalDateTime.now();

        Supplier<LocalDateTime> function = LocalDateTime::now;

        System.out.println(function.get());

        Function<String, Passenger> createFunction = Main::create;

        Passenger newPassenger = createFunction.apply("Juan");

        // son equivalentes
        List<Passenger> doctorsPassengers = filterPassenger(passengers, passenger1 -> passenger1.isCareer(Career.DOCTOR));
//        List<Passenger> doctorsPassengers = filterPassenger(passengers, Main::isCareer);

        List<Passenger> passengersOver65Years = filterPassenger(
                passengers,
                passenger -> passenger.getAge() > 65
        );

        List<Passenger> passengersLess18Years = filterPassenger(
                passengers,
                passenger -> passenger.getAge() > 18
        );

    }

    // passenger1 -> passenger1.isCareer(Career.DOCTOR)
    public static boolean isCareer(Passenger passenger) {
        return passenger.isCareer(Career.DOCTOR);
    }

    public static Passenger create(String name) {
        return new Passenger(name, 20,"none", Nacionality.COLOMBIAN.name(), "Cali");
    }

    private static void buildDataStructures(DataBase db, List<Passenger> passengers) {
        // Lists, Arrays
        List<Passenger> passengerLess18Years = getPassengerLess18Years(passengers);
        List<Passenger> passengersOver65YearsOld = getPassengerLess18Years(passengers);

        int average = getAverage(passengers);

        List<Passenger> passengersDoctorProfession = getPassengersDoctorProfession(passengers);
        /*
        *   key -> value
        *   nationality -> list(passengers)
        *
        *   AMERICAN -> list(american passengers)
        *   COLOMBIAN -> list(colombian passengers)
        *   SPANISH -> list(spanish passengers)
         */

        Map<String, List<Passenger>> map = getPassengersByNacionality(passengers);
        Set<String> cities = getDestinyCities(passengers);

        // stacks
        CustomInStack customInStack = createCustomInStack();

        // generic stacks
        CustomGenericStack<String> stringStack = new CustomGenericStack<>();
        CustomGenericStack<Integer> intigerStacks = new CustomGenericStack<>();

        // queues
        Queue<Passenger> passengerQueue = db.getAllPassengersOrderByAge();
        board(passengerQueue);
    }

    private static void board(Queue<Passenger> passengerQueue) {

        for (int i = 0; i < passengerQueue.size(); i++) {
            Passenger passenger = passengerQueue.poll();
            // callOtherMethod(passenger)
        }

    }

    private static CustomInStack createCustomInStack() {

        CustomInStack customInStack = new CustomInStack();
        customInStack.push(1);
        customInStack.push(2);
        customInStack.push(3);
        customInStack.search(5);

        return customInStack;

    }

    private static Set<String> getDestinyCities(List<Passenger> passengers) {

        Set<String> cities = new HashSet<>();

        for (Passenger passenger: passengers) {
            cities.add(passenger.getCityDestiny());
        }

        return cities;

    }

    private static Map<String, List<Passenger>> getPassengersByNacionality(List<Passenger> passengers) {

        Map<String, List<Passenger>> map = new HashMap<>();

        for (Passenger passenger: passengers) {

            if (map.containsKey(passenger.getNacionality())) {
                List<Passenger> nacionalityPassengers = map.get(passenger.getNacionality());
                nacionalityPassengers.add(passenger);
            } else {
                List<Passenger> nacionalityPassengers = new ArrayList<>();
                nacionalityPassengers.add(passenger);
                map.put(passenger.getNacionality(), nacionalityPassengers);
            }

        }

        return map;

    }

    private static int getAverage(List<Passenger> passengers) {

        int sumAge = 0;

        for (Passenger passenger: passengers) {
            sumAge = sumAge + passenger.getAge();
        }

        int average = sumAge / passengers.size();

        return average;

    }

    private static List<Passenger> filterPassenger(List<Passenger> passengersToFilter, Predicate<Passenger> predicate) {

        List<Passenger> filteredPassengers = new ArrayList<>();

        for (Passenger passenger: passengersToFilter) {
            if (predicate.test(passenger)) {
                passengersToFilter.add(passenger);
            }
        }

        return filteredPassengers;

    }

    private static List<Passenger> getPassengersDoctorProfession(List<Passenger> passengers) {

        List<Passenger> passengersDoctorProfession = new ArrayList<>();

        for (Passenger passenger: passengers) {
            if (passenger.isCareer(Career.DOCTOR)) {
                passengersDoctorProfession.add(passenger);
            }
        }

        return passengersDoctorProfession;

    }

    private static List<Passenger> getPassengersOver65YearsOld(List<Passenger> passengers) {

        List<Passenger> passengersOver65YearsOld = new ArrayList<>();

        for (Passenger passenger: passengers) {
            if (passenger.getAge() > 65) {
                passengersOver65YearsOld.add(passenger);
            }
        }

        return passengersOver65YearsOld;

    }

    private static List<Passenger> getPassengerLess18Years(List<Passenger> passengers) {

        List<Passenger> passengerLess18Years = new ArrayList<>();

        for (Passenger passenger: passengers) {
            if (passenger.getAge() < 18) {
                passengerLess18Years.add(passenger);
            }
        }

        return passengerLess18Years;

    }

}