package Faker;

import com.github.javafaker.Faker;

public class GenerateRandomAddress {

    public static void main(String[] args) {

        Faker faker = new Faker();
        String address = faker.address().fullAddress();
        String streetAddress = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String country = faker.address().country();
        String zipCode = faker.address().zipCode();
        String countryCode = faker.address().countryCode();

        System.out.println("Address: " + address);
        System.out.println("Street Address: " + streetAddress);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Country: " + country);
        System.out.println("zipCode: " + zipCode);
        System.out.println("countryCode: " + countryCode);

    }
}
