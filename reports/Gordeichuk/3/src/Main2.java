import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// Класс, представляющий информацию о поезде
class Train {
    String trainNumber;
    String destinationStation;
    Date departureTime;
    int availableSeats;

    public Train(String trainNumber, String destinationStation, Date departureTime, int availableSeats) {
        this.trainNumber = trainNumber;
        this.destinationStation = destinationStation;
        this.departureTime = departureTime;
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainNumber='" + trainNumber + '\'' +
                ", destinationStation='" + destinationStation + '\'' +
                ", departureTime=" + departureTime +
                ", availableSeats=" + availableSeats +
                '}';
    }
}

// Класс, представляющий узел бинарного дерева
class TreeNode {
    Train train;
    TreeNode left;
    TreeNode right;

    public TreeNode(Train train) {
        this.train = train;
        left = null;
        right = null;
    }
}

// Класс, представляющий расписание и операции с ним
class TrainSchedule {
    TreeNode root;

    public void addTrain(Train train) {
        root = addRecursive(root, train);
    }

    private TreeNode addRecursive(TreeNode current, Train train) {
        if (current == null) {
            return new TreeNode(train);
        }

        if (train.departureTime.compareTo(current.train.departureTime) < 0) {
            current.left = addRecursive(current.left, train);
        } else if (train.departureTime.compareTo(current.train.departureTime) > 0) {
            current.right = addRecursive(current.right, train);
        }

        return current;
    }

    public void printSchedule() {
        printInOrder(root);
    }

    private void printInOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.train);
            printInOrder(node.right);
        }
    }

    public Train findTrainByNumber(String trainNumber) {
        return findTrainByNumber(root, trainNumber);
    }

    private Train findTrainByNumber(TreeNode node, String trainNumber) {
        if (node == null) {
            return null;
        }

        if (trainNumber.equals(node.train.trainNumber)) {
            return node.train;
        } else if (trainNumber.compareTo(node.train.trainNumber) < 0) {
            return findTrainByNumber(node.left, trainNumber);
        } else {
            return findTrainByNumber(node.right, trainNumber);
        }
    }

    public List<Train> getTrainsToDestinationAfterTime(String destination, Date time) {
        List<Train> trains = new ArrayList<>();
        getTrainsToDestinationAfterTime(root, destination, time, trains);
        return trains;
    }

    private void getTrainsToDestinationAfterTime(TreeNode node, String destination, Date time, List<Train> result) {
        if (node == null) {
            return;
        }

        getTrainsToDestinationAfterTime(node.left, destination, time, result);

        if (node.train.destinationStation.equals(destination) && node.train.departureTime.after(time)) {
            result.add(node.train);
        }

        getTrainsToDestinationAfterTime(node.right, destination, time, result);
    }

    public List<Train> getTrainsToDestination(String destination) {
        List<Train> trains = new ArrayList<>();
        getTrainsToDestination(root, destination, trains);
        return trains;
    }

    private void getTrainsToDestination(TreeNode node, String destination, List<Train> result) {
        if (node == null) {
            return;
        }

        getTrainsToDestination(node.left, destination, result);

        if (node.train.destinationStation.equals(destination)) {
            result.add(node.train);
        }

        getTrainsToDestination(node.right, destination, result);
    }

    public List<Train> getTrainsToDestinationWithSeats(String destination, int seats) {
        List<Train> trains = new ArrayList<>();
        getTrainsToDestinationWithSeats(root, destination, seats, trains);
        return trains;
    }

    private void getTrainsToDestinationWithSeats(TreeNode node, String destination, int seats, List<Train> result) {
        if (node == null) {
            return;
        }

        getTrainsToDestinationWithSeats(node.left, destination, seats, result);

        if (node.train.destinationStation.equals(destination) && node.train.availableSeats >= seats) {
            result.add(node.train);
        }

        getTrainsToDestinationWithSeats(node.right, destination, seats, result);
    }

    public void showDepartureMessage() {
        showDepartureMessage(root);
    }

    private void showDepartureMessage(TreeNode node) {
        if (node == null) {
            return;
        }

        showDepartureMessage(node.left);

        long currentTimeMillis = System.currentTimeMillis();
        long timeDifference = node.train.departureTime.getTime() - currentTimeMillis;
        long minutesDifference = timeDifference / (1000 * 60);

        if (minutesDifference == 10 || minutesDifference == 5 || minutesDifference == 3) {
            System.out.println("Train " + node.train.trainNumber + " to " + node.train.destinationStation +
                    " will depart in " + minutesDifference + " minutes.");
        }

        showDepartureMessage(node.right);
    }
}

public class Main {
    public static void main(String[] args) {
        TrainSchedule schedule = new TrainSchedule();

        // Загрузка данных из файла
        loadScheduleFromFile(schedule, "schedule.txt");

        // Меню действий
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n*** Train Schedule Menu ***");
            System.out.println("1. Print schedule");
            System.out.println("2. Find train by number");
            System.out.println("3. Find trains to destination after time");
            System.out.println("4. Find trains to destination");
            System.out.println("5. Find trains to destination with seats");
            System.out.println("6. Show departure message");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nTrain Schedule:");
                    schedule.printSchedule();
                    break;
                case 2:
                    System.out.print("Enter train number: ");
                    String trainNumber = scanner.nextLine();
                    Train train = schedule.findTrainByNumber(trainNumber);
                    if (train != null) {
                        System.out.println("Train found: " + train);
                    } else {
                        System.out.println("Train not found");
                    }
                    break;
                case 3:
                    System.out.print("Enter destination station: ");
                    String destination = scanner.nextLine();
                    System.out.print("Enter time (yyyy-MM-dd HH:mm): ");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    try {
                        Date time = sdf.parse(scanner.nextLine());
                        List<Train> trains = schedule.getTrainsToDestinationAfterTime(destination, time);
                        System.out.println("\nTrains to " + destination + " after " + sdf.format(time) + ":");
                        for (Train t : trains) {
                            System.out.println(t);
                        }
                    } catch (ParseException e) {
                        System.out.println("Invalid date format");
                    }
                    break;
                case 4:
                    System.out.print("Enter destination station: ");
                    String destStation = scanner.nextLine();
                    List<Train> trainsToDestination = schedule.getTrainsToDestination(destStation);
                    System.out.println("\nTrains to " + destStation + ":");
                    for (Train t : trainsToDestination) {
                        System.out.println(t);
                    }
                    break;
                case 5:
                    System.out.print("Enter destination station: ");
                    String dest = scanner.nextLine();
                    System.out.print("Enter number of seats: ");
                    int seats = scanner.nextInt();
                    List<Train> trainsWithSeats = schedule.getTrainsToDestinationWithSeats(dest, seats);
                    System.out.println("\nTrains to " + dest + " with at least " + seats + " seats:");
                    for (Train t : trainsWithSeats) {
                        System.out.println(t);
                    }
                    break;
                case 6:
                    System.out.println("\nDeparture Messages:");
                    schedule.showDepartureMessage();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        } while (choice != 7);
    }

    public static void loadScheduleFromFile(TrainSchedule schedule, String fileName) {
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date departureTime = sdf.parse(parts[2]);
                Train train = new Train(parts[0], parts[1], departureTime, Integer.parseInt(parts[3]));
                schedule.addTrain(train);
            }
            scanner.close();
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }
    }
}
