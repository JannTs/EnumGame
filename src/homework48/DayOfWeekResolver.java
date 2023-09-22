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
                System.out.println(capitalizeDay(day.toString()) +" - It's a day off ? Of course it's " + Boolean.toString(isWeekend).toUpperCase() + " !");
            } else {
                System.out.println("Invalid day of week. Some examples -> SaTURday,Sa,sat,СБ or 6.");
            }
        }
        scanner.close();
    }

    private String readInput() {
        System.out.printf("%nENUM-GAME:Input the day of the week.%nSome input examples -> fridAy,Fr,fri,ПТ or 5 (x or exit -> to QUIT):");
        return scanner.nextLine().trim().toUpperCase();
    }

    private DayOfWeek convertToDayOfWeek(String input) {
        DayOfWeek day;
        try {
            //System.out.print(DayOfWeek.valueOf(input));
            //+" ( w/o dayAbbrConversion() )"
            return DayOfWeek.valueOf(input);
        } catch (IllegalArgumentException e) {
            day = dayAbbrConversion(input);
        }
        return day;
    }

    private boolean isWeekend (DayOfWeek day){
            return day.isWeekend();
        }

    private DayOfWeek dayAbbrConversion(String input) throws IllegalArgumentException {
        return switch (input.toLowerCase()) {
            case "1", "mo", "mon", "пн" -> DayOfWeek.MONDAY;
            case "2", "tu", "tue", "вт" -> DayOfWeek.TUESDAY;
            case "3", "we", "wed", "ср" -> DayOfWeek.WEDNESDAY;
            case "4", "th", "thu", "чт" -> DayOfWeek.THURSDAY;
            case "5", "fr", "fri", "пт" -> DayOfWeek.FRIDAY;
            case "6", "sa", "sat", "сб" -> DayOfWeek.SATURDAY;
            case "7", "su", "sun", "вс" -> DayOfWeek.SUNDAY;
            default ->
                    null;//throw new IllegalArgumentException("Invalid day of the week (from resolveDayAbbr): " + input);
        };
    }
    public static String capitalizeDay( String str ) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        // first letter capitalize conversion
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}

