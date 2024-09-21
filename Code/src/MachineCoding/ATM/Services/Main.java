package MachineCoding.ATM.Services;

import MachineCoding.ATM.Model.ATMMoneyRequestHandler;
import MachineCoding.ATM.Model.Rs2000RequestHandler;
import MachineCoding.ATM.Model.Rs500RequestHandler;

public class Main {
    public static void main(String[] args) {
        ATMMoneyRequestHandler atm1 = new Rs2000RequestHandler(4, new Rs500RequestHandler(5, null));
//        System.out.println(atm1.getCurrencyNotesLeft());
        System.out.println("Transaction 1");
        atm1.handleRequest(11000);

        System.out.println("Transaction 2");
        atm1.handleRequest(500);
    }
}
