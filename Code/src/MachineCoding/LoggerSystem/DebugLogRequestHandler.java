package MachineCoding.LoggerSystem;

public class DebugLogRequestHandler extends LogRequestHandler{

    public DebugLogRequestHandler(LogRequestHandler nextLogRequestHandler) {
        super(nextLogRequestHandler);
    }
    public void handleRequest(int logLevel, String message) {
        if (logLevel == LogRequestHandler.DEBUG) {
            System.out.println("DEBUG: " + message);
        }
        else {
            nextLogRequestHandler.handleRequest(logLevel, message);
        }

    }
}
