package homework48;
import java.util.Scanner;


public class DayOfWeekResolver {
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            String inputDay = readInput();
            if (inputDay.equalsIgnoreCase("exit") || inputDay.equalsIgnoreCase("x"))
            {
                break;
            }
            DayOfWeek day = convertToDayOfWeek(inputDay);
            if (day != null) {
                boolean isWeekend = isWeekend(day);
                System.out.println("It's a day off? Of course it's " + isWeekend + "!");
            } else {
                System.out.println("Invalid day of week. Correct example -> 5, Fr, Fri, or ПТ or Friday");
            }
        }
        scanner.close();
    }

    private String readInput() {
        System.out.print("Enter the day of the week (x or Exit):");
        return scanner.nextLine().trim().toUpperCase();
    }

    private DayOfWeek convertToDayOfWeek(String input) {
        DayOfWeek day;
        try {
            return DayOfWeek.valueOf(input);
        } catch (IllegalArgumentException e) {
            day = resolveDayAbbr(input);
        }
        return day;
    }

    private boolean isWeekend (DayOfWeek day){
            return day.isWeekend();
        }

    private DayOfWeek resolveDayAbbr (String input) throws IllegalArgumentException {
        switch (input.toLowerCase()) {
            case "1", "mo", "mon", "пн":
                return DayOfWeek.MONDAY;
            case "2", "tu", "tue", "вт":
                return DayOfWeek.TUESDAY;
            case "3", "we", "wed", "ср":
                return DayOfWeek.WEDNESDAY;
            case "4", "th", "thu", "чт":
                return DayOfWeek.THURSDAY;
            case "5", "fr", "fri", "пт":
                return DayOfWeek.FRIDAY;
            case "6", "sa", "sat", "сб":
                return DayOfWeek.SATURDAY;
            case "7", "su", "sun", "вс":
                return DayOfWeek.SUNDAY;
            default:
                return null;//throw new IllegalArgumentException("Invalid day of the week (from resolveDayAbbr): " + input);
        }
    }
}

