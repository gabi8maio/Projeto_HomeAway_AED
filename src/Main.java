import dataStructures.Iterator;
import homeaway.*;

import java.util.Scanner;

public class Main {

    // Constants for output messages
    private static final String CMD_NOT_EXIST = "Unknown command. Type help to see available commands.";
    private static final String END = "Bye!\n";
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
    private static final String STUDENT_NOT_EXISTS = "%s does not exist.\n";

    // Other command constants
    private static final String NO_SERVICES = "No services yet!\n";
    private static final String NO_STUDENTS = "No students yet!\n";
    private static final String NO_STUDENTS_FROM = "No students from %s!\n";
    private static final String ALREADY_THERE = "Already there!\n";
    private static final String SERVICE_NOT_VALID = "%s is not a valid service!\n";
    private static final String EATING_FULL = "eating %s is full!\n";
    private static final String STUDENT_DISTRACTED = "%s is distracted!\n";
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
    private static final String EVALUATION_REGISTERED = "Your evaluation has been registered!\n";
    private static final String NO_SERVICES_IN_SYSTEM = "No services in the system.\n";
    private static final String SERVICES_SORTED_HEADER = "Services sorted in descending order\n";
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
        } while (!cmd.equals(Command.EXIT));
        in.close();
    }

    private static void executeBounds(Scanner in, HomeAwaySystem system) {
        String name;
        try {
            long topLatitude = in.nextLong();
            long leftLongitude = in.nextLong();
            long bottomLatitude = in.nextLong();
            long rightLongitude = in.nextLong();
            name = in.nextLine().trim();

            if (system.hasArea(name)) {
                System.out.println(BOUNDS_ALREADY_EXISTS);
                return;
            }
            if (topLatitude <= bottomLatitude || rightLongitude <= leftLongitude) {
                System.out.println(INVALID_BOUNDS);
                return;
            }
            system.addTemporaryArea(name, topLatitude, bottomLatitude, leftLongitude, rightLongitude);
            System.out.printf(BOUNDS_CREATED, name);
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }

    private static void executeSave(Scanner in, HomeAwaySystem system) {
        try {
            String areaName = system.saveArea();
            System.out.printf(BOUNDS_SAVED, areaName);
        } catch (Exception e) {
            System.out.println(SYSTEM_BOUNDS_NOT_DEFINED);
        }
    }

    private static void executeLoad(Scanner in, HomeAwaySystem system) {
        String areaName = null;
        try {
            areaName = in.nextLine().trim();
            system.loadArea(areaName);
            System.out.printf(BOUNDS_LOADED, areaName);
        } catch (Exception e) {
            System.out.printf(BOUNDS_NOT_EXISTS, areaName);
        }
    }

    private static void executeService(Scanner in, HomeAwaySystem system) {
        String serviceType = in.next().toUpperCase().trim();
        long latitude = in.nextLong();
        long longitude = in.nextLong();
        double price = in.nextDouble();
        double value = in.nextDouble();
        String serviceName = in.nextLine().trim();

        try{
        TypesOfService serviceTypeEnum = TypesOfService.fromString(serviceType); // Podemos fazer isto?
        if (serviceTypeEnum == null) {
            System.out.println("Invalid service type!\n");
            return;
        }
        if (latitude <= longitude) { // Meti ao calhas
            System.out.println("Invalid location!\n");
            return;
        }

        if (price <= 0) {
            switch (serviceTypeEnum) {
                case EATING:
                    System.out.println(INVALID_MENU_PRICE);
                    return;
                case LODGING:
                    System.out.println(INVALID_ROOM_PRICE);
                    return;
                case LEISURE:
                    System.out.println(INVALID_TICKET_PRICE);
                    return;
            }
        }

        // Validar  value conforme o tipo de serviço
        if (serviceTypeEnum.equals(TypesOfService.LEISURE)) {
            if (value < 0 || value > 100) {
                System.out.println(INVALID_DISCOUNT);
                return;
            }
        } else { // eating ou lodging
            if (value <= 0) {
                System.out.println(INVALID_CAPACITY);
                return;
            }
        }

        // Validar se nome já existe
        if (system.serviceNameExists(serviceName, serviceTypeEnum)) {
            System.out.printf(SERVICE_ALREADY_EXISTS, serviceName);
            return;
        }

        // Adicionar serviço
        system.addService(serviceType, latitude, longitude, price, value, serviceName);
        System.out.printf(SERVICE_ADDED, serviceType.toLowerCase(), serviceName);

    } catch(Exception e)
    {
        System.out.println("Invalid arguments!"); // MUDAR
    }
    }

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

    private static void executeStudent(Scanner in, HomeAwaySystem system) {
        // Implementation for student command
        String studentType = in.nextLine().toLowerCase().trim();
        String name = in.nextLine().trim();
        String country = in.nextLine().trim();
        String lodging = in.nextLine().trim();
        in.nextLine(); // Consume remaining input

        try{
            if (StudentTypes.fromString(studentType) == null) {
                System.out.println("Invalid student type!");
                return;
            } if (!system.lodgingExists(lodging)) {
                System.out.printf(LODGING_NOT_EXISTS, lodging);
                return;
            } if (system.lodgingIsFull(lodging)){
                System.out.printf(LODGING_FULL, lodging);
                return;
            } if (system.studentExists(name)){
                System.out.printf(STUDENT_ALREADY_EXISTS, name);
                return;
            }
            system.addStudent(studentType, name, country, lodging);
            System.out.printf(STUDENT_ADDED, name);

        }catch (Exception e){
            System.out.println("Invalid arguments!");
        }
    }

    private static void executeStudents(Scanner in, HomeAwaySystem system) {
        String argument = in.nextLine().trim();

        try {
            if (argument.equals("all")) {
                Iterator<Students> studentIterator = system.getAllStudentsIterator();

                if (!studentIterator.hasNext()) {
                    System.out.println("No students yet!");
                    return;
                }

                while (studentIterator.hasNext()) {
                    Students student = studentIterator.next();
                    System.out.printf(STUDENTS_COMMAND,
                            student.getName(),
                            student.getType().toLowerCase(),
                            student.getCountry());
                }

            } else {
                // The argument will be the country now
                Iterator<Students> countryStudentIterator = system.getStudentsByCountryIterator(argument);

                if (!countryStudentIterator.hasNext()) {
                    System.out.printf(NO_STUDENTS_FROM, argument);
                    return;
                }

                while (countryStudentIterator.hasNext()) {
                    Students student = countryStudentIterator.next();
                    System.out.printf(STUDENTS_COMMAND,
                            student.getName(),
                            student.getType().toLowerCase(),
                            student.getCountry());
                }
            }

        } catch (Exception e) {
            System.out.println("Invalid arguments!");
        }
    }

    private static void executeLeave(Scanner in, HomeAwaySystem system) {
        String name = in.nextLine().trim();
        try {
            if (!system.studentExists(name)) {
                System.out.printf(STUDENT_NOT_EXISTS, name);
                return;
            }
            system.removeStudent(name);
            System.out.printf(STUDENT_LEFT, name);

        } catch (Exception e) {
            System.out.println("Invalid arguments!");
        }
    }

    private static void executeGo(Scanner in, HomeAwaySystem system) {
        // Implementation for go command
        in.nextLine(); // Consume remaining input
    }

    private static void executeMove(Scanner in, HomeAwaySystem system) {
        // Implementation for move command
        in.nextLine(); // Consume remaining input
    }

    private static void executeUsers(Scanner in, HomeAwaySystem system) {
        // Implementation for users command
        in.nextLine(); // Consume remaining input
    }

    private static void executeWhere(Scanner in, HomeAwaySystem system) {
        // Implementation for where command
        in.nextLine(); // Consume remaining input
    }

    private static void executeVisited(Scanner in, HomeAwaySystem system) {
        // Implementation for visited command
        in.nextLine(); // Consume remaining input
    }

    private static void executeStar(Scanner in, HomeAwaySystem system) {
        // Implementation for star command
        in.nextLine(); // Consume remaining input
    }

    private static void executeRanking(Scanner in, HomeAwaySystem system) {
        // Implementation for ranking command
        in.nextLine(); // Consume remaining input
    }

    private static void executeRanked(Scanner in, HomeAwaySystem system) {
        // Implementation for ranked command
        in.nextLine(); // Consume remaining input
    }

    private static void executeTag(Scanner in, HomeAwaySystem system) {
        // Implementation for tag command
        in.nextLine(); // Consume remaining input
    }

    private static void executeFind(Scanner in, HomeAwaySystem system) {
        // Implementation for find command
        in.nextLine(); // Consume remaining input
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