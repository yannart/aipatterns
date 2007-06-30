/*
 * ElementNoGeneratedException.java
 *
 * Created on 15 March 2007, 01:22
 *
 */

package razonamientos;

/**
 * Clase exception que es generada cuando un elemento de una
 * premisa no es generado por ninguna regla
 * @author MeSofI
 */
public class ElementNoGeneratedException extends java.lang.Exception {
    private String valueNotGenerated; // elemento no generado

    /**
     * Creates a new instance of <code>ElementNoGeneratedException</code> without detail message.
     */
    public ElementNoGeneratedException() {
    }


    /**
     * Constructs an instance of <code>ElementNoGeneratedException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ElementNoGeneratedException(String msg) {
        super(msg);
    }

    /**
     * Metodo que obtiene el valor no generado
     * @return Elemento de una regla que no es generado por nadie
     */
    public String getValueNotGenerated() {
        return valueNotGenerated;
    }

    /**
     * Metodo que pone un valor que no es generado por ninguna regla
     * @param valueNotGenerated elemento no generado por ninguna regla
     */
    public void setValueNotGenerated(String valueNotGenerated) {
        this.valueNotGenerated = valueNotGenerated;
    }
}
