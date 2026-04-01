import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        class Bogie {
            private String name;
            private int capacity;

            public Bogie(String name, int capacity) {
                this.name = name;
                this.capacity = capacity;
            }

            public String getName() {
                return name;
            }

            public int getCapacity() {
                return capacity;
            }
        }

        //===== UC1 =====
        System.out.println("=== Train Consist Management App ===");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train consist initialized.");
        System.out.println("Initial bogie count: " + trainConsist.size());

        //===== UC2 =====
        List<String> passengerBogies = new ArrayList<>();
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("\nPassenger Bogies after addition:");
        System.out.println(passengerBogies);

        passengerBogies.remove("AC Chair");

        System.out.println("\nAfter removing AC Chair:");
        System.out.println(passengerBogies);

        if (passengerBogies.contains("Sleeper")) {
            System.out.println("\nSleeper bogie exists in the train.");
        }

        System.out.println("\nFinal Passenger Bogie List:");
        System.out.println(passengerBogies);

        //===== UC3 =====
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101");
        bogieIds.add("BG102");

        System.out.println("\nBogie IDs (duplicates automatically removed):");
        System.out.println(bogieIds);

        //===== UC4 =====
        System.out.println("\n=== UC4: Train Consist Using LinkedList ===");
        LinkedList<String> consist = new LinkedList<>();
        consist.add("Engine");
        consist.add("Sleeper");
        consist.add("AC");
        consist.add("Cargo");
        consist.add("Guard");

        System.out.println("\nInitial Train Consist:");
        System.out.println(consist);

        consist.add(2, "Pantry Car");

        System.out.println("\nAfter inserting Pantry Car at position 2:");
        System.out.println(consist);

        consist.removeFirst();
        consist.removeLast();

        System.out.println("\nAfter removing first and last bogie:");
        System.out.println(consist);

        System.out.println("\nFinal Ordered Train Consist:");
        System.out.println(consist);

        //===== UC5 =====
        System.out.println("\n=== UC5: Train Formation Using LinkedHashSet ===");
        LinkedHashSet<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");

        System.out.println("\nFinal Train Formation (Insertion Order Preserved, No Duplicates):");
        System.out.println(formation);

        //===== UC6 =====
        System.out.println("\n=== UC6: Bogie Capacity Mapping Using HashMap ===");
        HashMap<String, Integer> bogieCapacity = new HashMap<>();
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 60);
        bogieCapacity.put("First Class", 24);

        System.out.println("\nBogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " -> Capacity: " + entry.getValue());
        }

        //===== UC7 =====
        System.out.println("\n=== UC7: Sort Bogies by Capacity (Comparator) ===");
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));

        bogies.sort(java.util.Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("\nBogies sorted by capacity (Ascending):");
        for (Bogie b : bogies) {
            System.out.println(b.getName() + " -> Capacity: " + b.getCapacity());
        }

        //===== UC8 =====
        System.out.println("\n=== UC8: Filter Passenger Bogies Using Streams ===");

        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .toList();

        System.out.println("\nFiltered Bogies (Capacity > 60):");

        if (filteredBogies.isEmpty()) {
            System.out.println("No bogies match the criteria.");
        } else {
            for (Bogie b : filteredBogies) {
                System.out.println(b.getName() + " -> Capacity: " + b.getCapacity());
            }    }



//===== UC9 =====
System.out.println("\n=== UC9: Group Bogies by Type (Collectors.groupingBy) ===");

Map<String, List<Bogie>> groupedBogies = bogies.stream()
        .collect(java.util.stream.Collectors.groupingBy(Bogie::getName));

System.out.println("\nGrouped Bogies:");

if (groupedBogies.isEmpty()) {
        System.out.println("No bogies available for grouping.");
} else {
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
        System.out.println("\nType: " + entry.getKey());
        for (Bogie b : entry.getValue()) {
        System.out.println("  " + b.getName() + " -> Capacity: " + b.getCapacity());
        }
        }
        }

        //===== UC10 =====
        System.out.println("\n=== UC10: Count Total Seats in Train (reduce) ===");

        int totalSeats = bogies.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        System.out.println("\nTotal Seating Capacity of Train: " + totalSeats);


//===== UC11 =====
        System.out.println("\n=== UC11: Validate Train ID & Cargo Codes (Regex) ===");

        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        java.util.regex.Pattern trainPattern = java.util.regex.Pattern.compile("TRN-\\d{4}");
        java.util.regex.Pattern cargoPattern = java.util.regex.Pattern.compile("PET-[A-Z]{2}");

        java.util.regex.Matcher trainMatcher = trainPattern.matcher(trainId);
        java.util.regex.Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        if (trainMatcher.matches()) {
            System.out.println("Train ID is valid: " + trainId);
        } else {
            System.out.println("Invalid Train ID: " + trainId);
        }

        if (cargoMatcher.matches()) {
            System.out.println("Cargo Code is valid: " + cargoCode);
        } else {
            System.out.println("Invalid Cargo Code: " + cargoCode);
        }

//===== UC12 =====
        System.out.println("\n=== UC12: Safety Compliance Check for Goods Bogies ===");

        class GoodsBogie {
            private String type;
            private String cargo;

            public GoodsBogie(String type, String cargo) {
                this.type = type;
                this.cargo = cargo;
            }

            public String getType() {
                return type;
            }

            public String getCargo() {
                return cargo;
            }
        }

        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));

        boolean isSafe = goodsBogies.stream()
                .allMatch(g -> !g.getType().equalsIgnoreCase("Cylindrical")
                        || g.getCargo().equalsIgnoreCase("Petroleum"));

        if (isSafe) {
            System.out.println("Train is SAFETY COMPLIANT.");
        } else {
            System.out.println("Train is NOT SAFE. Invalid cargo detected.");
        }
    }}