package MachineCoding.LoggerSystem;

public abstract class LogRequestHandler {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;
    public LogRequestHandler nextLogRequestHandler;

    public LogRequestHandler(LogRequestHandler nextLogRequestHandler) {
        this.nextLogRequestHandler = nextLogRequestHandler;
    }

    public void handleRequest(int logLevel, String message) {
        if (nextLogRequestHandler != null) {
            nextLogRequestHandler.handleRequest(logLevel, message);
        }
    }
}
