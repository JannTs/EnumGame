package homework48;
import java.util.Scanner;

public class DayOfWeekResolver {
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            String inputDay = readInput();
            if (inputDay.equalsIgnoreCase("exit")) {
                break;
            }
            DayOfWeek day = convertToDayOfWeek(inputDay);
            if (day != null) {
                boolean isWeekend = isWeekend(day);
                System.out.println("Is it holiday? " + isWeekend);
            } else {
                System.out.println("Invalid day of week. Please, enter day of the week in English.");
            }
        }
        scanner.close();
    }

    private String readInput() {
        System.out.print("Enter the day of the week (or Exit):");
        return scanner.nextLine().toUpperCase();
    }

    private DayOfWeek convertToDayOfWeek(String input) {
        try {
            return DayOfWeek.valueOf(input);
        } catch (IllegalArgumentException e) {
            DayOfWeek day;
            switch (input) {
                case "1", "mo", "mon":
                    day = DayOfWeek.MONDAY;
                    break;
                case "2", "tu", "tue":
                    day = DayOfWeek.TUESDAY;
                    break;
                case "3", "we", "wed":
                    day = DayOfWeek.WEDNESDAY;
                    break;
                case "4", "th", "thu":
                    day = DayOfWeek.THURSDAY;
                    break;
                case "5", "fr", "fri":
                    day = DayOfWeek.FRIDAY;
                    break;
                case "6", "sa", "sat":
                    day = DayOfWeek.SATURDAY;
                    break;
                case "7", "su", "sun":
                    day = DayOfWeek.SUNDAY;
                    break;
                default:
                    day = null;
                    break;
            }
            return day;
        }
        //return null;
    }


        private boolean isWeekend (DayOfWeek day){
            return day.isWeekend();
        }
}

