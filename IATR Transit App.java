// TransitRoute.java
public class TransitRoute {
    private String routeId;
    private String routeName;
    
    public TransitRoute(String routeId, String routeName) {
        this.routeId = routeId;
        this.routeName = routeName;
    }
    
    // Getters and toString method
    public String getRouteId() { return routeId; }
    public String getRouteName() { return routeName; }
    @Override
    public String toString() {
        return "Route ID: " + routeId + ", Name: " + routeName;
    }
}

// TransitStop.java
public class TransitStop {
    private String stopId;
    private String stopName;
    
    public TransitStop(String stopId, String stopName) {
        this.stopId = stopId;
        this.stopName = stopName;
    }
    
    // Getters and toString method
    public String getStopId() { return stopId; }
    public String getStopName() { return stopName; }
    @Override
    public String toString() {
        return "Stop ID: " + stopId + ", Name: " + stopName;
    }
}

// TransitSchedule.java
import java.util.HashMap;
import java.util.Map;

public class TransitSchedule {
    private Map<String, String> scheduleMap; // Key: Stop ID, Value: Arrival Time
    
    public TransitSchedule() {
        scheduleMap = new HashMap<>();
    }
    
    public void addSchedule(String stopId, String arrivalTime) {
        scheduleMap.put(stopId, arrivalTime);
    }
    
    public String getArrivalTime(String stopId) {
        return scheduleMap.getOrDefault(stopId, "No arrival time available");
    }
    
    @Override
    public String toString() {
        return "Schedule: " + scheduleMap.toString();
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransitApp {
    private static List<TransitRoute> routes = new ArrayList<>();
    private static List<TransitStop> stops = new ArrayList<>();
    
    public static void main(String[] args) {
        // Initialize some sample data
        initializeData();
        
        // Simple user interface
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the IATR Transit App!");
        
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. View Routes");
            System.out.println("2. View Stops");
            System.out.println("3. View Schedule");
            System.out.println("4. Exit");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    displayRoutes();
                    break;
                case 2:
                    displayStops();
                    break;
                case 3:
                    displaySchedule();
                    break;
                case 4:
                    System.out.println("Exiting the app.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void initializeData() {
        // Sample Routes
        routes.add(new TransitRoute("R1", "Downtown Loop"));
        routes.add(new TransitRoute("R2", "Uptown Express"));
        
        // Sample Stops
        stops.add(new TransitStop("S1", "Main St & 1st Ave"));
        stops.add(new TransitStop("S2", "2nd Ave & Pine St"));
        stops.add(new TransitStop("S3", "3rd Ave & Broadway"));
    }
    
    private static void displayRoutes() {
        System.out.println("Available Routes:");
        for (TransitRoute route : routes) {
            System.out.println(route);
        }
    }
    
    private static void displayStops() {
        System.out.println("Available Stops:");
        for (TransitStop stop : stops) {
            System.out.println(stop);
        }
    }
    
    private static void displaySchedule() {
        // Sample Schedule for demonstration
        TransitSchedule schedule = new TransitSchedule();
        schedule.addSchedule("S1", "08:30 AM");
        schedule.addSchedule("S2", "08:45 AM");
        schedule.addSchedule("S3", "09:00 AM");
        
        System.out.println("Route R1 Schedule:");
        System.out.println(schedule);
    }
}
