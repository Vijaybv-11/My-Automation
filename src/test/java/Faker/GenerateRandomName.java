package Faker;

import com.github.javafaker.Faker;

public class GenerateRandomName {

    public static void main(String[] args) {


        // Generate Name of a Person
        Faker faker = new Faker();
        for (int i = 0; i <= 10; i++) {
            // String fullName = faker.name().fullName();
            String firstName = faker.name().firstName();
            System.out.println(firstName);
        }
        // System.out.println("FullName is :" + fullName);
        //String MiddleName = faker.name().nameWithMiddle();
        // String LastName = faker.name().lastName();


        // System.out.println("MiddleName is :" +MiddleName);
        //System.out.println("LastName is :" +LastName);


    }
}
