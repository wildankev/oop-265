/**
 * TicketMachine Exercise for OOP-B (Informatics Engineering at ITS)
 *
 * @author A. Wildan Kevin Assyauqi~5025241265
 * @version 2025.09.09
*/

public class TicketMachine
{
    // price of ticket
    private int price;
    // amount of money entered by cust.
    private int balance;
    // amount of money collected by machine.
    private int total;
    
    public TicketMachine(int cost)
    {
        price = cost;
        balance = 0;
        total = 0;
    }
    
    /**
    * Return the price of a ticket.
    */
    public int getPrice()
    {
        return price;
    }

    /**
    * Return the amount of money already inserted for the
    * next ticket.
    */
    public int getBalance()
    {
        return balance;
    }

    /**
    * Receive an amount of money in cents from a customer.
    * Check that the amount is sensible.
    */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        } else {
            System.out.println("Use a positive amount: " + amount);
        }
    }

    /**
    * Print a ticket if enough money has been inserted, and
    * reduce the current balance by the ticket price. Print
    * an error message if more money is required.
    */
    public void printTicket()
    {
        if(balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        } else {
            System.out.println("You must insert at least: " + (price - balance) + " cents.");
        }
    }


    /**
    * Return the money in the balance.
    * The balance is cleared.
    */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}