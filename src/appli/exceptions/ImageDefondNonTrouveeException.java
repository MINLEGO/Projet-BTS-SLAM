package appli.exceptions;

/**
 *
 * @author btssio
 */
public class ImageDefondNonTrouveeException extends Exception {

    /**
     * Creates a new instance of <code>ImageDefondNonTrouveeException</code>
     * without detail message.
     */
    public ImageDefondNonTrouveeException() {
    }

    /**
     * Constructs an instance of <code>ImageDefondNonTrouveeException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ImageDefondNonTrouveeException(String msg) {
        super(msg);
    }
}
