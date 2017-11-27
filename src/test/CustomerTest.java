package test;

import main.Customer;
import main.Movie;
import main.Rental;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CustomerTest {
    @Test
    public void shouldReturnCustomerRentalDetailsWhenMoviePriceCodeIsNewRelease() {
        Movie movie = new Movie("Inception", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 5);
        Customer customer = new Customer("Customer Name");

        customer.addRental(rental);

        Assert.assertEquals("Rental Record for Customer Name\n" +
                "\tInception\t15.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 2 frequent renter points", customer.statement());
    }

    @Test
    public void shouldReturnCustomerRentalDetailsWhenMoviePriceCodeIsChildren() {
        Movie movie = new Movie("Inception", Movie.CHILDRENS);
        Rental rental = new Rental(movie, 5);
        Customer customer = new Customer("Customer Name");

        customer.addRental(rental);

        Assert.assertEquals("Rental Record for Customer Name\n" +
                "\tInception\t4.5\n" +
                "Amount owed is 4.5\n" +
                "You earned 1 frequent renter points", customer.statement());
    }

    @Test
    public void shouldReturnCustomerRentalDetailsWhenMoviePriceCodeIsPegular() {
        Movie movie = new Movie("Inception", Movie.PEGULAR);
        Rental rental = new Rental(movie, 5);
        Customer customer = new Customer("Customer Name");

        customer.addRental(rental);

        Assert.assertEquals("Rental Record for Customer Name\n" +
                "\tInception\t6.5\n" +
                "Amount owed is 6.5\n" +
                "You earned 1 frequent renter points", customer.statement());
    }
}
