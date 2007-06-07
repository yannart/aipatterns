/*
 * Utilities.java
 *
 * Created on 7/06/2007, 05:12:13 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.ai.pattern.util;

import java.awt.Dimension;

import java.awt.Window;

/**
 *
 * @author armando
 */
public class Utilities {
    public static void setCentered(Window window){
        Dimension screenDimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int screenw = (int)screenDimension.getWidth();
        int screenh = (int)screenDimension.getHeight();
        
        Dimension frameDimension = window.getSize();
        int framew = (int)frameDimension.getWidth();
        int frameh = (int)frameDimension.getHeight();
        
        // centra la ventana actual
        window.setLocation((screenw-framew)/2,(screenh-frameh)/2);
    }
}
