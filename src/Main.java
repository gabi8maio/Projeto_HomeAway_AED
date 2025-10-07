import homeaway.*;
import dataStructures.Iterator;
import java.util.Scanner;

public class Main {

    // Constants for output messages
    private static final String CMD_NOT_EXIST = "Unknown command. Type help to see available commands.";
    private static final String END = "Bye!";
    private static final String SYSTEM_BOUNDS_NOT_DEFINED = "System bounds not defined.";
    private static final String BOUNDS_ALREADY_EXISTS = "Bounds already exists. Please load it!";
    private static final String INVALID_BOUNDS = "Invalid bounds.";
    private static final String BOUNDS_CREATED = "%s created.";
    private static final String BOUNDS_SAVED = "%s saved.";
    private static final String BOUNDS_LOADED = "%s loaded.";
    private static final String BOUNDS_NOT_EXISTS = "Bounds %s does not exists.";

    // Service related constants
    private static final String INVALID_SERVICE_TYPE = "Invalid service type!";
    private static final String INVALID_LOCATION = "Invalid location!";
    private static final String INVALID_MENU_PRICE = "Invalid menu price!";
    private static final String INVALID_ROOM_PRICE = "Invalid room price!";
    private static final String INVALID_TICKET_PRICE = "Invalid ticket price!";
    private static final String INVALID_DISCOUNT = "Invalid discount price!";
    private static final String INVALID_CAPACITY = "Invalid capacity!";
    private static final String SERVICE_ALREADY_EXISTS = "%s already exists!";
    private static final String SERVICE_ADDED = "%s %s added.";

    // Student related constants
    private static final String INVALID_STUDENT_TYPE = "Invalid student type!";
    private static final String LODGING_NOT_EXISTS = "lodging %s does not exist!";
    private static final String LODGING_FULL = "lodging %s is full!";
    private static final String STUDENT_ALREADY_EXISTS = "%s already exists!";
    private static final String STUDENT_ADDED = "%s added.";
    private static final String STUDENT_LEFT = "%s has left.";
    private static final String STUDENT_NOT_EXISTS = "%s does not exist.";

    // Other command constants
    private static final String NO_SERVICES = "No services yet!";
    private static final String NO_STUDENTS = "No students yet!";
    private static final String NO_STUDENTS_FROM = "No students from %s!";
    private static final String ALREADY_THERE = "Already there!";
    private static final String SERVICE_NOT_VALID = "%s is not a valid service!";
    private static final String EATING_FULL = "eating %s is full!";
    private static final String STUDENT_DISTRACTED = "%s is distracted!";
    private static final String STUDENT_NOW_AT = "%s is now at %s.";
    private static final String MOVE_HOME = "lodging %s is now %s's home. %s is at home.";
    private static final String ALREADY_HOME = "That is %s's home!";
    private static final String MOVE_NOT_ACCEPTABLE = "Move is not acceptable for %s!";
    private static final String INVALID_ORDER = "This order does not exist!";
    private static final String NO_CONTROL_ENTRY_EXIT = "%s does not control student entry and exit!";
    private static final String NO_STUDENTS_ON = "No students on %s!";
    private static final String WHERE_FORMAT = "%s is at %s %s (%d, %d).";
    private static final String STUDENT_THRIFTY = "%s is thrifty!";
    private static final String NO_VISITED_LOCATIONS = "%s has not visited any locations!";
    private static final String INVALID_EVALUATION = "Invalid evaluation!";
    private static final String EVALUATION_REGISTERED = "Your evaluation has been registered!";
    private static final String NO_SERVICES_IN_SYSTEM = "No services in the system.";
    private static final String SERVICES_SORTED_HEADER = "Services sorted in descending order";
    private static final String INVALID_STARS = "Invalid stars!";
    private static final String NO_SERVICES_TYPE = "No %s services!";
    private static final String NO_SERVICES_AVERAGE = "No %s services with average!";
    private static final String NO_SERVICES_TAG = "There are no services with this tag!";

    private static Command getCommand(Scanner input) {
        try {
            String comm = input.next().toUpperCase();
            return Command.valueOf(comm);
        } catch (IllegalArgumentException e) {
            return Command.UNKNOWN;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HomeAwaySystem system = new HomeAwaySystemClass();
        Command cmd;
        do {
            cmd = getCommand(in);
            switch (cmd) {
                case HELP -> { executeHelp(); in.nextLine(); }
                case EXIT -> { executeExit(system); System.out.println(END); }
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

    // Command execution methods
    private static void executeBounds(Scanner in, HomeAwaySystem system) {
        // Implementation for bounds command
        in.nextLine(); // Consume remaining input
    }

    private static void executeSave(Scanner in, HomeAwaySystem system) {
        // Implementation for save command
        in.nextLine(); // Consume remaining input
    }

    private static void executeLoad(Scanner in, HomeAwaySystem system) {
        // Implementation for load command
        in.nextLine(); // Consume remaining input
    }

    private static void executeService(Scanner in, HomeAwaySystem system) {
        // Implementation for service command
        in.nextLine(); // Consume remaining input
    }

    private static void executeServices(Scanner in, HomeAwaySystem system) {
        // Implementation for services command
        in.nextLine(); // Consume remaining input
    }

    private static void executeStudent(Scanner in, HomeAwaySystem system) {
        // Implementation for student command
        in.nextLine(); // Consume remaining input
    }

    private static void executeStudents(Scanner in, HomeAwaySystem system) {
        // Implementation for students command
        in.nextLine(); // Consume remaining input
    }

    private static void executeLeave(Scanner in, HomeAwaySystem system) {
        // Implementation for leave command
        in.nextLine(); // Consume remaining input
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
        // Implementation for exit command - save current area if exists
    }

    private static void executeHelp() {
        Command[] help = Command.values();
        for (int i = 0; i < help.length - 1; i++) {
            System.out.println(help[i].getMsg());
        }
    }
}