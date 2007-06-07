/*
 * Cronometro.java
 * 
 * Created on 7 juin 2007, 12:32:05
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.ai.pattern;

import java.util.Date;

/**
 *
 * @author yannart
 */
public class Cronometro {
    long horainicio;
    long tiempo;
    
    public void start(){
        horainicio = new Date().getTime();
    }
    
    public long stop(){
        long ahora = new Date().getTime();
        tiempo = ahora - horainicio;
        return tiempo;
    }
    
    public int getTiempo(){
        return (int) (tiempo);
    }
    
    public int getTiempoSegundos(){
        return (int) (tiempo / 1000);
    }
}
