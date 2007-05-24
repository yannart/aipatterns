/*«Copyright 2006, 2007 Yann Arthur Nicolas»
 *www.merlinsource.com
 *yannart@gmail.com
 *
 * This file is part of Patterns.
 *
 * Patterns is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * Patterns is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

package org.ai.pattern;

import java.awt.EventQueue;
import org.ai.pattern.gui.MainFrame;

public class Application {
    
    public Application() {
        
    }
    
    public static void main(String [] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new MainFrame()).setVisible(true);
            }
        });
    }
    
}
