package utils;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Utility class for application-wide logging.
 */
public class LoggerUtil {
    
    private static final Logger LOGGER = Logger.getLogger(LoggerUtil.class.getName());

    static {
        try {
            // Set up File Handler for logging into "logs/app.log"
            FileHandler fileHandler = new FileHandler("logs/app.log", true);
            fileHandler.setFormatter(new SimpleFormatter()); // Format logs in plain text
            LOGGER.addHandler(fileHandler);

            // Set console handler for displaying logs in the console
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.ALL);
            LOGGER.addHandler(consoleHandler);

            // Set logging level (INFO, WARNING, SEVERE, etc.)
            LOGGER.setLevel(Level.ALL);
        } catch (IOException e) {
            System.err.println("Failed to initialize logging system: " + e.getMessage());
        }
    }

    /**
     * Returns the application-wide logger instance.
     * @return Logger instance.
     */
    public static Logger getLogger() {
        return LOGGER;
    }
}
