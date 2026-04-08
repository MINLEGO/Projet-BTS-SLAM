package appli.exceptions;

/**
 *
 * @author btssio
 */
public class ConnexionBDDException extends Exception {

    /**
     * Creates a new instance of <code>ConnexionBDDException</code> without
     * detail message.
     */
    public ConnexionBDDException() {
    }

    /**
     * Constructs an instance of <code>ConnexionBDDException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ConnexionBDDException(String msg) {
        super(msg);
    }
}
