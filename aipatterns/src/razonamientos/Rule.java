/*
 * Rule.java
 *
 * Created on 15 March 2007, 01:54
 *
 */

package razonamientos;





import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Esta clase crea las reglas para que sean aplicadas
 * @author MeSofI
 */
public class Rule {
    /**
     * Variable que lleva la cuenta del numero de reglas que existen
     */
    public static int numberStaticRule = 0;
    // Lista que contiene los elementos de una regla
    private List<String> statement = new ArrayList();
    // variable que contiene el resultado de una regla
    private String result;
    // variable que contiene el tipo de operador a aplicar
    private OperatorType operatorType;
    // variable que contiene el numero de regla
    private int numberRule;

    /**
     * Crea un objeto del tipo Regla, iniciandolo con el operador especificado
     * en el constructor
     * @param operatorType Tipo de operador a aplicar en la regla
     */
    public Rule(OperatorType operatorType) {
        this.operatorType = operatorType;
        numberStaticRule++;
        this.numberRule = numberStaticRule;
    }

    /**
     * Metodo que dice si un elemento existe en la premisa del lado izquierdo
     * @param element Elemento a buscar
     * @return true, si el elemento existe
     * false, si el elemento no existe
     */
    public boolean containsElement(String element) {
        List myList = getStatement();
        for (Iterator it = myList.iterator(); it.hasNext(); ) {
            String elem = (String)it.next();
            if (elem.equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que pone el elemento resultado a la premisa
     * @param result Nuevo elemento a aplicar a la premisa
     * @throws exceptions.StatementRepeatedException Lanza una exception si el elemtno ya se repite en la premisa
     */
    public void setResult(String result) throws StatementRepeatedException {
        result = result.toUpperCase();
        if (statement.contains(result)) {
            throw new StatementRepeatedException("El resultado " + result + 
                                                 " ya existe en la premisas");
        }
        this.result = result;
    }

    /**
     * Metodo que pone un nuevo elemento a la premisa, este no debe
     * ser repetido
     * @param newStatement Nuevo elemento a la premisa, para construirla
     * ejemplo de elementos: h1, h3, h4... etc
     * @throws exceptions.StatementRepeatedException Lanza una exception si el nuevo elemento ya existe en
     * la premisa que se esta construyendo
     */
    public void setStatement(String newStatement) throws StatementRepeatedException {
        newStatement = newStatement.toUpperCase();
        if (this.statement.contains(newStatement)) {
            throw new StatementRepeatedException("No puede haber declaraciones repetidas");
        }
        this.statement.add(newStatement);
    }

    /**
     * Metodo que devuelve el elemento resultado de la premisa en la
     * regla actual
     * @return El elemento resultado
     */
    public String getResult() {
        return result;
    }

    /**
     * Metodo que regresa una lista de elementos que constituyen una regla
     * @return Lista de elementos
     */
    public List<String> getStatement() {
        return statement;
    }

    /**
     * Metodo que devuelve el numero de regla
     * @return Numero de la regla actual
     */
    public int getNumberRule() {
        return numberRule;
    }

    /**
     * Metodo que devuelve el tipo de operator, este puede ser
     * AND, OR, XOR etc.
     * @return Regresa el tipo de operador
     */
    public OperatorType getOpratorType() {
        return operatorType;
    }

    /**
     * Metodo que devuelve en una cadena la premisa
     * @return La premisa
     */
    public String toString() {
        int len = operatorType.toString().length();
        String fullString = "Si ";
        for (Iterator it = statement.iterator(); it.hasNext(); ) {
            String elem = (String)it.next();
            fullString += elem + " ";
            fullString += operatorType + " ";
        }
        fullString = fullString.substring(0, fullString.length() - len - 1);
        fullString += "entonces ";
        fullString += getResult();
        return fullString;
    }

    /**
     * Metodo que cuenta el numero de antecedentes en la regla actual
     * @param element elemento para buscar sus antecedentes en esta regla
     * @return numero de antecedentes
     */
    public int getNumberPrevious(String element) {
        int count = 0;
        for (Iterator it = statement.iterator(); it.hasNext(); ) {
            String elem = (String)it.next();
            if (elem.equals(element)) {
                continue;
            }
            count++;
        }
        if (!result.equals(element)) {
            count++;
        }
        return count;
    }

    /**
     * Metodo que cuenta el numero de elementos desconocidos de esta regla
     * en la base pasada como parametro
     * @param base Base en la cual se va a probar si existe algun elemento
     * desconocido
     * @return Numero de elementos desconocidos en la regla
     */
    public int getUnKnownElementOnBase(KnowledgeBase base) {
        int unKnown = 0;
        boolean found = false;
        for (Iterator it = statement.iterator(); it.hasNext(); ) {
            String elem = (String)it.next();
            List<String> elemBase = base.getBc();
            for (int i = 0; i < elemBase.size(); i++) {
                String b = elemBase.get(i);
                if (elem.equals(b)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                unKnown++;
            }
        }
        return unKnown;
    }
}
