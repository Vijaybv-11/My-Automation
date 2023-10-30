package Faker;

import com.github.javafaker.Faker;

public class RandomNameGenerator {

    public static void main(String[] args) {

        Faker faker = new Faker();

        int numNames = 10;

        String[] randomNames = new String[numNames];

        for (int i = 0; i < numNames; i++) {
            randomNames[i] = faker.name().username();
        }

        System.out.println("Random Names:");
        for (String name : randomNames) {
            System.out.print("" + name + "" + ",");
        }
    }
}