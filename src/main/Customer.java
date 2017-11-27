package main;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = this.rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";

        while (rentals.hasMoreElements()) {
            Rental rental = (Rental) rentals.nextElement();

            frequentRenterPoints = getFrequentRenterPoints(frequentRenterPoints, rental);

            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
            totalAmount += rental.getCharge();
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return result;
    }

    private int getFrequentRenterPoints(int frequentRenterPoints, Rental rental) {
        // add frequent renter points
        frequentRenterPoints++;

        // add bonus for a two day new release rental
        if((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                rental.getDaysRented() > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

    private double amountFor(Rental aRental) {
        return aRental.getCharge();
    }

    public void addRental(Rental arg) {
        this.rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }
}
