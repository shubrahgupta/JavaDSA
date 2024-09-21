package MachineCoding.ATM.Model;

public abstract class ATMMoneyRequestHandler {
    ATMMoneyRequestHandler nextRequestHandler;
    int amountLeftFromRequest;
    int currencyNotesLeft;

    public ATMMoneyRequestHandler(ATMMoneyRequestHandler nextRequestHandler, int amountLeftFromRequest, int currencyNotesLeft) {
        this.nextRequestHandler = nextRequestHandler;
        this.amountLeftFromRequest = amountLeftFromRequest;
        this.currencyNotesLeft = currencyNotesLeft;
    }

    public ATMMoneyRequestHandler(int currencyNotesLeft, ATMMoneyRequestHandler nextRequestHandler) {
        this.nextRequestHandler = nextRequestHandler;
        this.currencyNotesLeft = currencyNotesLeft;
    }

    public int getAmountLeftFromRequest() {
        return amountLeftFromRequest;
    }

    public void setAmountLeftFromRequest(int amountLeftFromRequest) {
        this.amountLeftFromRequest = amountLeftFromRequest;
    }

    public int getCurrencyNotesLeft() {
        return currencyNotesLeft;
    }

    public void setCurrencyNotesLeft(int currencyNotesLeft) {
        this.currencyNotesLeft = currencyNotesLeft;
    }

    public void handleRequest(int amount) {
        if (nextRequestHandler != null) {
            nextRequestHandler.handleRequest(amount);
        }
        else {
            if (amount > 0)
                System.out.println("Cannot dispatch the amount");
        }
    }



}
