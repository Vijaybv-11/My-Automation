package Faker;

import com.github.javafaker.Faker;

public class GenerateRandomJobRelated {


    public static void main(String[] args) {

        Faker faker = new Faker();

        // Generating random job-related information
        String jobTitle = faker.job().title();
        String companyName = faker.company().name();
        String catchPhrase = faker.company().catchPhrase();


        System.out.println("Job Title: " + jobTitle);
        System.out.println("Company Name: " + companyName);
        System.out.println("Catch Phrase: " + catchPhrase);


    }
}
