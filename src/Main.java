import dataStructures.Iterator;
import dataStructures.TwoWayDoublyIterator;
import dataStructures.TwoWayIterator;
import homeaway.*;
import homeaway.Exeptions.*;

import java.util.Scanner;

public class Main {

    // Constants for output messages
    private static final String CMD_NOT_EXIST = "Unknown command. Type help to see available commands.";
    private static final String END = "Bye!";
    private static final String SYSTEM_BOUNDS_NOT_DEFINED = "System bounds not defined.";
    private static final String BOUNDS_ALREADY_EXISTS = "Bounds already exists. Please load it!\n";
    private static final String INVALID_BOUNDS = "Invalid bounds.\n";
    private static final String BOUNDS_CREATED = "%s created.\n";
    private static final String BOUNDS_SAVED = "%s saved.\n";
    private static final String BOUNDS_LOADED = "%s loaded.\n";
    private static final String BOUNDS_NOT_EXISTS = "Bounds %s does not exists.\n";

    // Service related constants
    private static final String INVALID_SERVICE_TYPE = "Invalid service type!\n";
    private static final String INVALID_LOCATION = "Invalid location!\n";
    private static final String INVALID_MENU_PRICE = "Invalid menu price!\n";
    private static final String INVALID_ROOM_PRICE = "Invalid room price!\n";
    private static final String INVALID_TICKET_PRICE = "Invalid ticket price!\n";
    private static final String INVALID_DISCOUNT = "Invalid discount price!\n";
    private static final String INVALID_CAPACITY = "Invalid capacity!\n";
    private static final String SERVICE_ALREADY_EXISTS = "%s already exists!\n";
    private static final String SERVICE_ADDED = "%s %s added.\n";

    // Student related constants
    private static final String INVALID_STUDENT_TYPE = "Invalid student type!\n";
    private static final String LODGING_NOT_EXISTS = "lodging %s does not exist!\n";
    private static final String LODGING_FULL = "lodging %s is full!\n";
    private static final String STUDENT_ALREADY_EXISTS = "%s already exists!\n";
    private static final String STUDENT_ADDED = "%s added.\n";
    private static final String STUDENT_LEFT = "%s has left.\n";
    private static final String STUDENT_NOT_EXISTS = "%s does not exist!\n";

    // Other command constants
    private static final String NO_SERVICES = "No services yet!\n";
    private static final String NO_STUDENTS = "No students yet!\n";
    private static final String NO_STUDENTS_FROM = "No students from %s!\n";
    private static final String ALREADY_THERE = "Already there!\n";
    private static final String SERVICE_NOT_VALID = "%s is not a valid service!\n";
    private static final String EATING_FULL = "eating %s is full!\n";
    private static final String STUDENT_DISTRACTED = "%s is now at %s. %s is distracted!\n";
    private static final String STUDENT_NOW_AT = "%s is now at %s.\n";
    private static final String MOVE_HOME = "lodging %s is now %s's home. %s is at home.\n";
    private static final String ALREADY_HOME = "That is %s's home!\n";
    private static final String MOVE_NOT_ACCEPTABLE = "Move is not acceptable for %s!\n";
    private static final String INVALID_ORDER = "This order does not exist!\n";
    private static final String NO_CONTROL_ENTRY_EXIT = "%s does not control student entry and exit!\n";
    private static final String NO_STUDENTS_ON = "No students on %s!\n";
    private static final String WHERE_FORMAT = "%s is at %s %s (%d, %d).\n";
    private static final String STUDENT_THRIFTY = "%s is thrifty!\n";
    private static final String NO_VISITED_LOCATIONS = "%s has not visited any locations!\n";
    private static final String INVALID_EVALUATION = "Invalid evaluation!\n";
    private static final String EVALUATION_REGISTERED = "Your evaluation has been registered!";
    private static final String NO_SERVICES_IN_SYSTEM = "No services in the system.\n";
    private static final String SERVICES_SORTED_HEADER = "Services sorted in descending order";
    private static final String INVALID_STARS = "Invalid stars!\n";
    private static final String NO_SERVICES_TYPE = "No %s services!\n";
    private static final String NO_SERVICES_AVERAGE = "No %s services with average!\n";
    private static final String NO_SERVICES_TAG = "There are no services with this tag!\n";
    private static final String SERVICES_COMMAND = "%s: %s (%d, %d).\n";
    private static final String STUDENTS_COMMAND = "%s: %s at %s.\n";

    private static Command getCommand(Scanner input) {
        try {
            String comm = input.next().toUpperCase();
            return Command.valueOf(comm);
        } catch (IllegalArgumentException e) {
            return Command.UNKNOWN;
        }
    }

    //TODO: Colocar a mensagem de erro de comando como uma excepção
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HomeAwaySystem system = new HomeAwaySystemClass();
        Command cmd;
        do {
            cmd = getCommand(in);
            switch (cmd) {
                case HELP -> {
                    executeHelp();
                    in.nextLine();
                }
                case EXIT -> {
                    executeExit(system);
                    System.out.println(END);
                }
                case BOUNDS -> executeBounds(in, system);
                case SAVE -> executeSave(in, system);
                case LOAD -> executeLoad(in, system);
                default -> {
                    // Verificar se o sistema tem bounds definidos para os outros comandos
                    if (!system.hasBounds()) {
                        System.out.println("System bounds not defined.");
                        in.nextLine(); // consumir a linha restante
                    } else {
                        switch (cmd) {
                            case SERVICE -> executeService(in, system);
                            case SERVICES -> executeServices(in, system);
                            case STUDENT -> executeStudent(in, system);
                            case STUDENTS -> executeStudents(in, system);
                            case LEAVE -> executeLeave(in, system);
                            case GO -> executeGo(in, system);
                            case MOVE -> executeMove(in, system);
                            case USERS -> executeUsers(in, system);
                            case WHERE -> executeWhere(in, system);
                            case VISITED -> executeVisited(in, system);
                            case STAR -> executeStar(in, system);
                            case RANKING -> executeRanking(in, system);
                            case RANKED -> executeRanked(in, system);
                            case TAG -> executeTag(in, system);
                            case FIND -> executeFind(in, system);
                            case UNKNOWN -> {
                                System.out.println(CMD_NOT_EXIST);
                                in.nextLine();
                            }
                        }
                    }
                }
            }
        } while (!cmd.equals(Command.EXIT));
        in.close();
    }

    //exceptions feitas
    private static void executeBounds(Scanner in, HomeAwaySystem system) {
        String name;
        try {
            long topLatitude = in.nextLong();
            long leftLongitude = in.nextLong();
            long bottomLatitude = in.nextLong();
            long rightLongitude = in.nextLong();
            name = in.nextLine().trim();
            system.addTemporaryArea(name, topLatitude, bottomLatitude, leftLongitude, rightLongitude);
            System.out.printf(BOUNDS_CREATED, name);
        } catch (BoundsAlreadyExistException | InvalidBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    //excpetions adicionadas
    private static void executeSave(Scanner in, HomeAwaySystem system) {
        try {
            String areaName = system.saveArea();
            System.out.printf(BOUNDS_SAVED, areaName);
        } catch (SystemBoundsNotDefinedException e) {
            System.out.println(e.getMessage());
        }
    }

    //excpetions adicionadas
    private static void executeLoad(Scanner in, HomeAwaySystem system) {
        String areaName = null;
        String realAreaName = null; // Porque nos outputs vem o nome da area guardada
        try {
            areaName = in.nextLine().trim();
            realAreaName = system.loadArea(areaName);
            System.out.printf(BOUNDS_LOADED, realAreaName);
        } catch (BoundsDoesNotExistException e) {
            System.out.printf(e.getMessage(), realAreaName);
        }
    }

    //exceptions added
    private static void executeService(Scanner in, HomeAwaySystem system) {
        String serviceType = in.next().toUpperCase().trim();
        long latitude = in.nextLong();
        long longitude = in.nextLong();
        double price = in.nextDouble();
        int value = in.nextInt();
        String serviceName = in.nextLine().trim();

        try{
            system.addService(serviceType, latitude, longitude, price, value, serviceName);
            System.out.printf(SERVICE_ADDED, serviceType.toLowerCase(), serviceName);

        } catch(InvalidServiceTypeException | InvalidLocationException | InvalidPriceMenuException | InvalidRoomPriceException |
            InvalidTicketPriceException | InvalidDiscountException | InvalidCapacityException e) {
            System.out.println(e.getMessage());
        } catch ( ServiceAlreadyExistsException e){
            System.out.print(e.getMessage());
        }
    }

    //no exceptions needed
    private static void executeServices(Scanner in, HomeAwaySystem system) {
        Iterator<Services> serviceIterator = system.getServiceIterator();

        if (!serviceIterator.hasNext()) {
            System.out.println("No services yet!");
            return;
        }

        while (serviceIterator.hasNext()) {
            Services service = serviceIterator.next();
            System.out.printf(SERVICES_COMMAND ,service.getServiceName(),
                    service.getServiceType().toLowerCase(),
                    service.getLatitude(),
                    service.getLongitude());
        }
    }

    //exceptions added
    private static void executeStudent(Scanner in, HomeAwaySystem system) {
        // Implementation for student command
        String studentType = in.nextLine().toLowerCase().trim();
        String name = in.nextLine().trim();
        String country = in.nextLine().trim();
        String lodging = in.nextLine().trim();

        try{
            system.addStudent(studentType, name, country, lodging);
            System.out.printf(STUDENT_ADDED, name);

        }catch (InvalidStudentTypeException | LodgingNotExistsException | LodgingIsFullException |
                StudentAlreadyExistsException e){
            System.out.println(e.getMessage());
        }
    }

    //exceptions added
    private static void executeStudents(Scanner in, HomeAwaySystem system) {
        String argument = in.nextLine().trim();

        try {

            Iterator <Students> it = system.getStudents(argument);

            while (it.hasNext()) {
                Students student = it.next();
                System.out.printf(STUDENTS_COMMAND,
                    student.getName(),
                    student.getType().toLowerCase(),
                    student.getPlaceNow().getServiceName());
            }


        } catch (NoStudentsException e) {
            System.out.println(e.getMessage());
        } catch  (NoStudentsFromCountryException e) {
            System.out.printf(e.getMessage(), argument);
        }
    }

    //exceptions added
    private static void executeLeave(Scanner in, HomeAwaySystem system) {
        String name = in.nextLine().trim();
        try {
            system.removeStudent(name);
            System.out.printf(STUDENT_LEFT, name);

        } catch (StudentDoesNotExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    //exceptions added
    private static void executeGo(Scanner in, HomeAwaySystem system) {
        String studentName = in.nextLine().trim();
        String locationName = in.nextLine().trim();

        try {
            // go Student
            Students studentNameReal = system.goStudentToLocation(studentName, locationName);

            if(system.isServiceMoreExpensiveForThrifty(studentName, locationName))
                System.out.printf(STUDENT_DISTRACTED,studentNameReal.getName(),studentNameReal.getPlaceNow().getServiceName(),studentNameReal.getName());
            else
                System.out.printf(STUDENT_NOW_AT,studentNameReal.getName(),studentNameReal.getPlaceNow().getServiceName());

        } catch (StudentAlreadyThereException | StudentAlreadyExistsException | InvalidServiceException |
                 StudentDoesNotExistsException e) {
            System.out.println(e.getMessage());
        } catch (UnknownLocationException | EatingIsFullException e){
            System.out.printf(e.getMessage(), locationName);
        }
    }

    private static void executeMove(Scanner in, HomeAwaySystem system) {
        String studentName = in.nextLine().trim();
        String locationName = in.nextLine().trim();

        try {
            // move Student
            Students student = system.moveStudentToLocation(studentName, locationName);
            System.out.printf(MOVE_HOME,student.getPlaceHome().getServiceName(),student.getName(),student.getName());
        } catch (LodgingNotExistsException | StudentDoesNotExistsException | StudentHomeException | LodgingIsFullException | MoveNotAcceptableException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void executeUsers(Scanner in, HomeAwaySystem system) {
        String order = in.next().trim();
        String serviceName = in.nextLine().trim();

        try {
            TwoWayIterator<Students> studentIterator = system.usersCommand(order, serviceName);

            if(order.equals("<")) {
                studentIterator.fullForward();
                while (studentIterator.hasPrevious()) {


                    Students student = studentIterator.previous();
                    System.out.printf("%s: %s\n",
                            student.getName(),
                            student.getType().toLowerCase());
                }
            }else{
                while (studentIterator.hasNext()) {
                 Students student = studentIterator.next();
                      System.out.printf("%s: %s\n",
                        student.getName(),
                        student.getType().toLowerCase());
                }
            }
        }catch(NoStudentsOnServiceException | OrderNotExistsException | ServiceDoesNotExistException | ServiceNotControlEntryExitException e){
            System.out.println(e.getMessage());
        }

    }

    private static void executeWhere(Scanner in, HomeAwaySystem system) {
        String studentName = in.nextLine().trim();

        try {

            Students student = system.getStudentLocationInfo(studentName);
            Services place = student.getPlaceNow();
            System.out.printf(WHERE_FORMAT, student.getName(), place.getServiceName(),place.getServiceType().toLowerCase(),place.getLatitude(),place.getLongitude());

        } catch (StudentDoesNotExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void executeVisited(Scanner in, HomeAwaySystem system) {
        String studentName = in.nextLine().trim();
        try {
            Iterator<Services> visitedIterator = system.getVisitedLocationsIterator(studentName);
            if (!visitedIterator.hasNext()) System.out.printf(NO_VISITED_LOCATIONS, studentName);
            else {
                while (visitedIterator.hasNext()) {
                    Services service = visitedIterator.next();
                    System.out.println(service.getServiceName());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void executeStar(Scanner in, HomeAwaySystem system) {
        try {
            int stars = in.nextInt();
            String serviceName = in.nextLine().trim();
            String description = in.nextLine().trim();

            system.starCommand(stars, serviceName, description);
            System.out.println(EVALUATION_REGISTERED);

        } catch (InvalidEvaluationException | ServiceDoesNotExistException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void executeRanking(Scanner in, HomeAwaySystem system) {
        try {
            Iterator<Services> rankingIterator = system.getServicesByRankingIterator();
            System.out.println(SERVICES_SORTED_HEADER);
            while (rankingIterator.hasNext()) {
                Services service = rankingIterator.next();
                    System.out.printf("%s: %d\n", service.getServiceName(), service.getAverageStars());
            }
        } catch (NoServicesInSystemException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void executeRanked(Scanner in, HomeAwaySystem system) {
        try {
            String type = in.next().trim();
            int stars = in.nextInt();
            String studentName = in.nextLine().trim();

            Iterator<Services> rankedIterator = system.getRankedServicesIterator(stars, type, studentName);

            System.out.printf("%s services closer with %d average%n", type, stars);
            while (rankedIterator.hasNext()) {
                Services service = rankedIterator.next();
                System.out.println(service.getServiceName());
            }

        } catch (InvalidStarsException | StudentDoesNotExistsException | InvalidServiceTypeException | NoTypeServicesException | NoServicesWithAverage e) {
            System.out.println(e.getMessage());
        }
    }

    private static void executeTag(Scanner in, HomeAwaySystem system) {
        String tag = in.nextLine().trim();
        try {
            Iterator<Services> tagIterator = system.getServicesByTagIterator(tag);


            while (tagIterator.hasNext()) {
                Services service = tagIterator.next();
                System.out.printf("%s %s\n", service.getServiceType().toLowerCase(), service.getServiceName());
            }

        } catch (NoServicesWithTagException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void executeFind(Scanner in, HomeAwaySystem system) {
        try {
            String studentName = in.nextLine().trim();
            String serviceType = in.nextLine().trim();

            Services service = system.findMostRelevantService(studentName, serviceType);
            System.out.println(service);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void executeExit(HomeAwaySystem system) {
        system.saveArea();
    }

    private static void executeHelp() {
        Command[] help = Command.values();
        for (int i = 0; i < help.length - 1; i++) {
            System.out.println(help[i].getMsg());
        }
    }
}