package Faker;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class GenerateRandomCreditCardDetails {

    public static void main(String[] args) {


        Faker faker = new Faker();
        // Generating random credit card details

        String creditCardNumber = faker.finance().creditCard();
        String VisaCard = faker.finance().creditCard(CreditCardType.VISA);
        String AmericanExpress = faker.finance().creditCard(CreditCardType.AMERICAN_EXPRESS);
        String DINERS_CLUB = faker.finance().creditCard(CreditCardType.DINERS_CLUB);
        String MASTERCARD = faker.finance().creditCard(CreditCardType.MASTERCARD);
        String DANKORT = faker.finance().creditCard(CreditCardType.DANKORT);
        String DISCOVER = faker.finance().creditCard(CreditCardType.DISCOVER);
        String LASER = faker.finance().creditCard(CreditCardType.LASER);
        String SWITCH = faker.finance().creditCard(CreditCardType.SWITCH);
        String FORBRUGSFORENINGEN = faker.finance().creditCard(CreditCardType.FORBRUGSFORENINGEN);
        String SOLO = faker.finance().creditCard(CreditCardType.SOLO);

        //Card Expiry
        String creditCardExpiry = faker.business().creditCardExpiry();


        System.out.println("Credit Card Number: " + creditCardNumber);
        System.out.println("Credit Card Type: " + VisaCard);
        System.out.println("American Express Credit Card : " + AmericanExpress);
        System.out.println("DINERS_CLUB Card : " + DINERS_CLUB);
        System.out.println("MASTERCARD Card : " + MASTERCARD);
        System.out.println("DANKORT Card : " + DANKORT);
        System.out.println("DISCOVER Card : " + DISCOVER);
        System.out.println("LASER Card : " + LASER);
        System.out.println("SWITCH Card : " + SWITCH);
        System.out.println("FORBRUGSFORENINGEN Card : " + FORBRUGSFORENINGEN);
        System.out.println("SOLO Card : " + SOLO);
        System.out.println("Credit Card Expiry:" + creditCardExpiry);


    }
}
