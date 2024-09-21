package MachineCoding.LoggerSystem;

public class Main {
    public static void main(String[] args) {
        LogRequestHandler logger = (new InfoLogRequestHandler(new DebugLogRequestHandler(new ErrorLogRequestHandler(null))));

        logger.handleRequest(LogRequestHandler.INFO, "Application has started");
        logger.handleRequest(LogRequestHandler.DEBUG, "Unnecessary warning");
        logger.handleRequest(LogRequestHandler.ERROR, "Internal Server Error: 500");


    }

}
