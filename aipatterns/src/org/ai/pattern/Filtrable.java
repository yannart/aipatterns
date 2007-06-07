/*
 * Filtrable.java
 * 
 * Created on 25 mai 2007, 16:14:22
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.ai.pattern;

import java.awt.image.BufferedImage;

/**
 *
 * @author yannart
 */
public interface Filtrable {
    public void imagenFiltrada(BufferedImage image);
    public void imagenFiltrada(BufferedImage image, String mensaje);
}
