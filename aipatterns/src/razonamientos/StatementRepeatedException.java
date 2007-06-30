/*
 * StatementRepeatedException.java
 *
 * Created on 15 March 2007, 01:32
 *
 */

package razonamientos;

/**
 * Clase exception que es lanzada cuando un elmento esta repetido
 * @author MeSofI
 */
public class StatementRepeatedException extends java.lang.Exception {

    /**
     * Creates a new instance of <code>StatementRepeatedException</code> without detail message.
     */
    public StatementRepeatedException() {
    }


    /**
     * Constructs an instance of <code>StatementRepeatedException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public StatementRepeatedException(String msg) {
        super(msg);
    }
}
