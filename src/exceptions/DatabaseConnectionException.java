package exceptions;

/**
 * Custom exception class for handling database connection errors.
 */
public class DatabaseConnectionException extends Exception {
    
    /**
     * Constructs a new DatabaseConnectionException with the specified detail message.
     *
     * @param message The detail message.
     */
    public DatabaseConnectionException(String message) {
        super(message);
    }

    /**
     * Constructs a new DatabaseConnectionException with the specified detail message and cause.
     *
     * @param message The detail message.
     * @param cause   The cause of the exception.
     */
    public DatabaseConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
