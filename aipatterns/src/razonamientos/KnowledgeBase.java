/*
 * KnowledgeBase.java
 *
 * Created on 15 March 2007, 01:38
 *
 */

package razonamientos;

import razonamientos.StatementRepeatedException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Clase que crea la base de nuevo conocimiento
 * @author MeSofI
 */
public class KnowledgeBase {
    // lista que contiene los elememntos de la base del conocimiento
    protected List<String> bc = new ArrayList();
    // posicion actual en la base
    private int positionInBase = 0;

    /**
     * Construye un nuevo objeto de la base del conocimiento
     * @param element Valores iniciales en la base
     * @throws exceptions.StatementRepeatedException Si algun valor se repite
     */
    public KnowledgeBase(String... element) throws StatementRepeatedException {
        for (String value: element) {
            newElement(value);
        }
    }

    /**
     * Metodo que obtiene la posicion en la cual en la que esta la base
     * @return La posicion de la base
     */
    public int getPositionInBase() {
        return positionInBase;
    }

    /**
     * Metodo que devuelve en una lista los valores actuales de la base
     * @return Lista de valores de la base
     */
    public List<String> getBc() {
        return bc;
    }

    /**
     * Metodo que agrega un nuevo elemento a la base
     * @param newElement Nuevo elemento a agregar
     * @throws exceptions.StatementRepeatedException Si algun elemento esta repetido
     */
    public void addNewElement(String newElement) throws StatementRepeatedException {
        newElement(newElement);
    }

    /**
     * Metodo que devuelve la representacion de la base en forma de cadena
     * @return Cadena de la base
     */
    public String toString() {
        String fullString = "B.C. = {";
        for (Iterator it = bc.iterator(); it.hasNext(); ) {
            String elem = (String)it.next();
            fullString += elem + ", ";
        }
        fullString = fullString.substring(0, fullString.length() - 2);
        fullString += "}";
        return fullString;
    }

    private void newElement(String value) throws StatementRepeatedException {
        // metodo que agrega a la lista un nuevo elemento
        if (bc.contains(value)) {
            throw new StatementRepeatedException("El elemento " + value + 
                                                 " ya existe");
        }
        bc.add(value.toUpperCase());
        positionInBase++;
    }

    /**
     * Metodo que pone una nueva posicion en la base
     * @param positionInBase Posicion actual de la base
     */
    public void setPositionInBase(int positionInBase) {
        this.positionInBase = positionInBase;
    }

    /**
     * Metodo que devuelve un elemento en la posicion actual
     * @return Elemento de la base en la posicion actual
     */
    public String getElementAtCurrentPosition() {
        return bc.get(getPositionInBase() - 1);
    }

    /**
     * Metodo que prueba si un elemento se encuentra en la base
     * @param objetive Elemento a probar si se encuentra en la base de conocimiento
     * @return true, si el elemento si se encuentra
     * false, si no lo encuentra
     */
    public boolean containsElement(String objetive) {
        return getBc().contains(objetive);
    }
}
