/*
 * Reasoning.java
 *
 * Created on 15 March 2007, 01:29
 *
 */

package razonamientos;



import java.util.List;

import razonamientos.Rule;


/**
 * Clase que guarda la lista de Reglas, la base y el objetivo a probar
 * @author MeSofI
 */
public class Reasoning {
    private List<Rule> rules;
    private KnowledgeBase base;
    private String objetive;
    protected String traceProcess = "";

    /**
     * Constructor que inicializa los elementos a utilizar
     * 
     * @param rules Lista de reglas a aplicar
     * @param base Objeto del tipo KnowledgeBase que contiene la base de
     * conocimiento inicial en la cual se buscara el objetivo
     * @param objetive Variable que contiene el objetivo meta
     */
    public Reasoning(List<Rule> rules, KnowledgeBase base, String objetive) {
        this.rules = rules;
        this.base = base;
        this.objetive = objetive.toUpperCase();
    }


    protected int getMinimumValue(int current, int min) {
        // Metodo  que regresa el numero mas pequeño entre
        // dos enteros, actual y minimo
        if (current == 0) {
            return min;
        }
        if (current < min) {
            return current;
        } else {
            return min;
        }
    }


    /**
     * Metodo que prueba si se ha llegado a la meta final o no
     * @return true, si el objetivo se ha cumplido
     * false, si el objetivo aun no se ha cumplido
     */
    public boolean testTarget() {
        return base.containsElement(this.objetive);
    }

    /**
     * Metodo que devuelve la base modificada despues de haber aplicado
     * las reglas
     * @return Base actual
     */
    public KnowledgeBase getBase() {
        return base;
    }

    /**
     * Metodo que devuelve el objetivo
     * @return El objetivo meta a probar
     */
    public String getObjetive() {
        return objetive;
    }

    /**
     * Metodo que devuelve las reglas iniciales que seguir
     * @return Reglas iniciales
     */
    public List<Rule> getRules() {
        return rules;
    }

}
