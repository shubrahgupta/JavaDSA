package MachineCoding.LoggerSystem;

public class ErrorLogRequestHandler extends LogRequestHandler{

    public ErrorLogRequestHandler(LogRequestHandler nextLogRequestHandler) {
        super(nextLogRequestHandler);
    }
    public void handleRequest(int logLevel, String message) {
        if (logLevel == LogRequestHandler.ERROR) {
            System.out.println("ERROR: " + message);
        }
        else {
            nextLogRequestHandler.handleRequest(logLevel, message);
        }

    }
}
