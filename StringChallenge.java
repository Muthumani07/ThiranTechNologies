public class StringChallenge {
    public static void main(String[] args) {
        // Test the function with example inputs
        System.out.println(minuteDifference("12:30pm-12:00am")); // Output: 690
        System.out.println(minuteDifference("1:23am-1:08am"));   // Output: 1425
        System.out.println(minuteDifference("9:00am-10:00am"));  // Output: 60
        System.out.println(minuteDifference("1:00pm-11:00am"));  // Output: 1320
    }

    public static int minuteDifference(String str) {
        // Split the input string into two time components
        String[] times = str.split("-");
        
        // Parse both times
        int time1 = convertToMinutes(times[0]);
        int time2 = convertToMinutes(times[1]);
        
        // Calculate the difference in minutes
        if (time2 < time1) {
            // If time2 is less than time1, it means time2 is on the next day
            time2 += 1440; // Add 24 hours worth of minutes
        }
        
        return time2 - time1;
    }

    // Function to convert a time string to total minutes
    private static int convertToMinutes(String time) {
        // Extract the hour and minute components
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1].substring(0, 2));
        String period = parts[1].substring(2); // am or pm
        
        // Convert hour to 24-hour format
        if (period.equals("pm") && hour != 12) {
            hour += 12;
        } else if (period.equals("am") && hour == 12) {
            hour = 0;
        }
        
        // Calculate total minutes from midnight
        return hour * 60 + minute;
    }
}