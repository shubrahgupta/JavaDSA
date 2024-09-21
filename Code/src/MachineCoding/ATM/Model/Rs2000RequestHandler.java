package MachineCoding.ATM.Model;

public class Rs2000RequestHandler extends ATMMoneyRequestHandler{

    static int value = 2000;

    public Rs2000RequestHandler(ATMMoneyRequestHandler nextRequestHandler, int amountLeftFromRequest, int currencyNotesLeft) {
        super(nextRequestHandler, amountLeftFromRequest, currencyNotesLeft);
    }

    public Rs2000RequestHandler(int currencyNotesLeft, ATMMoneyRequestHandler nextRequestHandler) {
        super(currencyNotesLeft, nextRequestHandler);
    }

    public int getWorth() {
        return getCurrencyNotesLeft() * value;
    }
    public void handleRequest(int amount) {
        int numOfNotesToDispatch = Math.min(getCurrencyNotesLeft(), (amount/value));
        int amountLeft = amount - numOfNotesToDispatch * value;

        setCurrencyNotesLeft(getCurrencyNotesLeft() - numOfNotesToDispatch);
        System.out.println("Dispatching " + numOfNotesToDispatch + " notes of " + value);

//        System.out.println("Amount left in the transaction: " + amountLeft);
        if (amountLeft > 0 && nextRequestHandler != null) {
            nextRequestHandler.handleRequest(amountLeft);
        }
        else if (amountLeft > 0) {
            // If no handler is left and there's still an amount, it can't be dispatched
            System.out.println("Cannot dispatch the remaining amount: " + amountLeft);
        }


    }
}
