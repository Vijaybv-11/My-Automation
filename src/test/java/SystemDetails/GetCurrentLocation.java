package SystemDetails;

import java.util.Locale;
import java.util.TimeZone;

public class GetCurrentLocation {
    public static void main(String[] args) {
        // Get the system's default time zone
        TimeZone timeZone = TimeZone.getDefault();

        // Get the country and region codes from the time zone ID
        String[] timeZoneParts = timeZone.getID().split("/");
        String countryCode = timeZoneParts[0];

        // Get the country and region names based on the codes
        Locale locale = new Locale("", countryCode);
        String countryName = locale.getDisplayCountry();


        String regionName = timeZone.getDisplayName(false, TimeZone.SHORT);

        // Print the location information
        System.out.println("Country: " + countryName);
        System.out.println("Region: " + regionName);
    }
}

