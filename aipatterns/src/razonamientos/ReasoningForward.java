/*
 * ReasoningForward.java
 *
 * Created on 15 March 2007, 01:54
 *
 */

package razonamientos;





import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;


/**
 * Clase que se encarga de hacer el razonamiento hacia adelante
 * @author MeSofI
 */
public class ReasoningForward extends Reasoning implements ReasoningInterface, 
                                                           Enumeration {
    private int matrix[][];

    /**
     * Creates a new instance of ReasoningForward
     * @param rules Lista de reglas para aplicar a la base
     * @param base Base de conocimiento
     * @param objetive Objetivo meta a probar
     */
    public ReasoningForward(List<Rule> rules, KnowledgeBase base, 
                            String objetive) {
        super(rules, base, objetive);
        createProcessForward();
    }

    private void createProcessForward() {
        // Metodo que crea un razonamiento hacia adelante
        getBase().setPositionInBase(1);
        String element = getBase().getElementAtCurrentPosition();
        traceProcess += getBase().toString() + "\n";
        buildMatrix(element);
    }

    /**
     * Metodo que prueba que haya mas reglas que aplicar antes de
     * llegar a la meta final
     * @return true, si hay mas reglas que aplicar
     * false, si se ha llegado a la meta final
     */
    public boolean hasMoreElements() {
        traceProcess += "\n" + getBase().toString() + "\n";
        if (testTarget()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Metodo que regresa la siguiente regla a aplicar
     * @return La siguiente regla para aplicar
     */
    public Object nextElement() {
        return getRuleToApply();
    }

    /**
     * Metodo que regresa la regla que se tiene que aplicar a la base
     * @return Regla para aplicar a la base
     */
    public Rule getRuleToApply() {
        int min = 1000;
        int i = 0, current = 0;
        for (i = 0; i < getRules().size(); i++) {
            current = matrix[1][i];
            if (current == 0) {
                break;
            }
            min = getMinimumValue(current, min);
        }
        // cuando las prioridades son las mismas, vuelve a recorrer la lista
        // para asegurarse de tomar el primero que encuentre
        int j = 0, unknown = -1;
        for (j = 0; j < getRules().size(); j++) {
            current = matrix[1][j];
            if (current == min) {
                unknown = 
                        getRules().get(matrix[0][j] - 1).getUnKnownElementOnBase(getBase());
                if (unknown == 0) {
                    break;
                }
            }
        }


        traceProcess += 
                "Aplicando la regla: " + "R" + (getRules().get(matrix[0][j] - 1)).getNumberRule() + 
                "-->" + (getRules().get(matrix[0][j] - 1)).toString() + "\n";
        return getRules().get(matrix[0][j] - 1);
    }

    /**
     * Metodo que aplica una regla determinada a la base
     * @param rule Regla a aplicar a la base
     * @throws exceptions.StatementRepeatedException Es lanzada si algun elmento de la base se repite despues de
     * haber aplicado una regla determinada
     */
    public void applyRuleOnBase(Rule rule) throws StatementRepeatedException {
        getBase().addNewElement(rule.getResult());
        traceProcess += getBase().toString() + "\n";
        traceProcess += 
                "---------------------------------------------------------------\n\n";
        getBase().setPositionInBase(getBase().getPositionInBase());
        String element = getBase().getElementAtCurrentPosition();
        buildMatrix(element);
    }

    private void buildMatrix(String element) {
        // metodo que construye una matriz con los elementos
        // de las reglas y su prioridad
        int matrix[][] = new int[2][getRules().size()];
        int i = 0;
        for (Iterator it = getRules().iterator(); it.hasNext(); ) {
            Rule rule = (Rule)it.next();
            if (rule.containsElement(element)) {

                System.out.print(rule.getNumberRule());
                System.out.println(" (" + rule.getNumberPrevious(element) + 
                                   ") ");

                matrix[0][i] = rule.getNumberRule();
                matrix[1][i] = rule.getNumberPrevious(element);

                traceProcess += 
                        "\t" + element + " esta en: R" + rule.getNumberRule() + 
                        ", prioridad (" + rule.getNumberPrevious(element) + 
                        ")\n ";
                i++;
            }
        }
        this.matrix = matrix;
    }

    /**
     * Metodo que devuelve en un matriz, las prioridades y antecedentes
     * segun se apliquen las reglas, ejem:
     * 
     * 6 2
     * 8 1
     * 9 4
     * La primer columna corresponde a la reglas
     * y la segunda columa corresponde al numero de antecedentes
     * @return la matriz con la prioridad
     */
    public int[][] getMatrix() {
        return matrix;
    }

    /**
     * Metodo que devuelve el proceso para llegar al objetivo
     * usando razonamiento hacia adelante
     * @return Descripcion detallada del proceso para alcanzar el objetivo
     */
    public String getTraceProcess() {
        return this.traceProcess;
    }


}
