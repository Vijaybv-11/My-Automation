package Faker;

import com.github.javafaker.Faker;
import com.github.javafaker.Internet;

public class GenerateRandomthings {

    public static void main(String[] args) {

        Faker faker = new Faker();
        // Random Phone Number
        String phoneNumber = faker.phoneNumber().phoneNumber();

        // Random Cell Number
        String cellNumber = faker.phoneNumber().cellPhone();

        // Random Email Address
        String email = faker.internet().emailAddress();
        //Random safe email addresss
        String safeEmail = faker.internet().safeEmailAddress();

        // Random Username
        String username = faker.name().username();
        //Random Password
        String Password = faker.internet().password();
        //Random password with link
        String password = faker.internet().password(5, 9);

        String domainName = faker.internet().domainName();
        String ipv4Address = faker.internet().ipV4Address();
        String ipv6Address = faker.internet().ipV6Address();
        String userAgent = faker.internet().userAgent(Internet.UserAgent.CHROME);
        String macAddress = faker.internet().macAddress();

        System.out.println("Safe Email Address" + safeEmail);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Cell Number :" + cellNumber);
        System.out.println("Email: " + email);
        System.out.println("Username: " + username);
        System.out.println("Password: " + Password);
        System.out.println("Password: " + password);
        System.out.println("domainName: " + domainName);
        System.out.println("ipv4Address: " + ipv4Address);
        System.out.println("ipv6Address: " + ipv6Address);
        System.out.println("userAgent: " + userAgent);
        System.out.println("macAddress: " + macAddress);

    }
}
