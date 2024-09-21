package MachineCoding.LoggerSystem;

public class InfoLogRequestHandler extends LogRequestHandler{

    public InfoLogRequestHandler(LogRequestHandler nextLogRequestHandler) {
        super(nextLogRequestHandler);
    }
    public void handleRequest(int logLevel, String message) {
        if (logLevel == LogRequestHandler.INFO) {
            System.out.println("INFO: " + message);
        }
        else {
            nextLogRequestHandler.handleRequest(logLevel, message);
        }

    }
}
