/*
 * SubKnowledgeBase.java
 *
 * Created on 15 March 2007, 01:07
 *
 */

package razonamientos;

import razonamientos.StatementRepeatedException;

import java.util.Iterator;


/**
 *
 * @author MeSofI
 */
public class SubKnowledgeBase extends KnowledgeBase {

    /** Creates a new instance of SubKnowledgeBase */
    public SubKnowledgeBase(String... element) throws StatementRepeatedException {
        super(element);
    }

    /**
     * Metodo que devuelve la representacion de la base en forma de cadena
     * @return Cadena de la subbase
     */
    public String toString() {
        String fullString = "C.S. = {";

        for (Iterator it = bc.iterator(); it.hasNext(); ) {
            String elem = (String)it.next();
            fullString += elem + ", ";
        }
        fullString = fullString.substring(0, fullString.length() - 2);
        fullString += "}";
        return fullString;
    }
}
