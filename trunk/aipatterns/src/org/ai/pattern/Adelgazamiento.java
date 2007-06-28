
package org.ai.pattern;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yannart
 */
public class Adelgazamiento extends Tratamiento{
    
    public Adelgazamiento(Filtrable parent){
        super(parent);
    }
    
    void tratamientoImagen() {
        BufferedImage bufferedImage = imagen.getImagen();
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        Map <Integer, Region> regiones = imagen.getRegiones();
        int[] rgbs = new int[w*h];
        bufferedImage.getRGB(0,0,w,h,rgbs,0,w);
        int [] vecinos = new int[8];
        List <Punto> pixelesBorrar = new ArrayList <Punto> ();
        int color;
        int minx;
        int miny;
        int maxx;
        int maxy;
        long borrados;
        
        for(Region region: regiones.values()){
            color = region.getColor();
            minx = region.getMinx();
            miny = region.getMiny();
            maxx = region.getMaxx();
            maxy = region.getMaxy();
            
            //ITERACIONES
            do{
                borrados = 0;
                
                /*   7   0   1
                 *   6   P   2
                 *   5   4   3
                 */
                //Iteracion 1
                pixelesBorrar.clear();
                for(int y = miny; y <= maxy; y++){
                    for(int x = minx; x <= maxx; x++){
                        int pixel = rgbs[x + y* w];
                        if((pixel & 0x00FFFFFF) != color){
                            continue;
                        }
                        set8Vecinos(vecinos, x, y, w, rgbs, minx, maxx, miny, maxy);
                        if(cumpleCondicionesItera1(pixel, vecinos)){
                            pixelesBorrar.add(new Punto(x, y));
                        }
                    }
                }
                
                borrados += pixelesBorrar.size();
                for(Punto punto: pixelesBorrar){
                    rgbs[punto.x + punto.y* w] = 0;
                }
                
                //Iteracion 2
                pixelesBorrar.clear();
                for(int x = minx; x <= maxx; x++){
                    for(int y = miny; y <= maxy; y++){
                        int pixel = rgbs[x + y* w];
                        if(pixel != (color & 0x00FFFFFF)){
                            continue;
                        }
                        set8Vecinos(vecinos, x, y, w, rgbs, minx, maxx, miny, maxy);
                        if(cumpleCondicionesItera2(pixel, vecinos)){
                            pixelesBorrar.add(new Punto(x, y));
                        }
                    }
                }
                
                borrados += pixelesBorrar.size();
                for(Punto point: pixelesBorrar){
                    rgbs[point.x + point.y* w] = 0;
                }
            } while (borrados > 0);
            
            buscaRasgos(region, rgbs, w);
        }
        bufferedImage.setRGB(0, 0, w, h, rgbs, 0, w);
    }
    
    private void buscaRasgos(Region region, int[] rgbs, int w){
        int terminal = 0;
        int puntoInterno = 0;
        int puntoCruce = 0;
        int triada = 0;
        int color = region.getColor();
        int minx = region.getMinx();
        int miny = region.getMiny();
        int maxx = region.getMaxx();
        int maxy = region.getMaxy();
        int[] vecinos = new int[8];
        int vecinos4;
        int vecinos8;
        for(int y = miny; y <= maxy; y++){
            for(int x = minx; x <= maxx; x++){
                int pixel = rgbs[x + y* w];
                
                if((pixel & 0x00FFFFFF) != color){
                    continue;
                }
                
                vecinos4 = 0;
                vecinos8 = 0;
                set8Vecinos(vecinos, x, y, w, rgbs, minx, maxx, miny, maxy);
                
                for(int i = 0 ; i < vecinos.length ; i++){
                    if((vecinos[i] & 0x00FFFFFF) == color){
                        vecinos8++;
                        if(i % 2 == 0){
                            vecinos4++;
                        }
                    }
                }
                //System.out.println("( " + x + ", " + y + " ) = " + cardinalidad);
                if(vecinos4 == 3){
                    triada++;
                }else if(vecinos4 == 4) {
                    triada+=2;
                }
                
                switch(vecinos8){
                case 0:
                    break;
                case 1:
                    terminal++;
                    break;
                case 2:
                    puntoInterno++;
                    break;
                default:
                    puntoCruce++;
                }
            }
        }
        
        region.setTerminal(terminal);
        region.setPuntoCruce(puntoCruce);
        region.setPuntoInterno(puntoInterno);
        region.setTriada(triada);
    }
    
    private void set8Vecinos(int [] vecinos, int x, int y, int w, int [] rgbs, int minx, int maxx, int miny, int maxy){
        
        /*   7   0   1
         *   6   P   2
         *   5   4   3
         */
        if(x > minx){
            vecinos[6] = rgbs[x - 1 + y * w];
            if(y > miny){
                vecinos[7] = rgbs[x - 1 + (y - 1)* w];
            }else{
                vecinos[7] = 0;
            }
            
            if(y < maxy){
                vecinos[5] = rgbs[x - 1 + (y + 1)* w];
            }else{
                vecinos[5] = 0;
            }
        }else{
            vecinos[5] = 0;
            vecinos[6] = 0;
            vecinos[7] = 0;
        }
        
        if(x < maxx){
            vecinos[2] = rgbs[x + 1 + y * w];
            if(y > miny){
                vecinos[1] = rgbs[x + 1 + (y - 1)* w];
            }else{
                vecinos[1] = 0;
            }
            
            if(y < maxy){
                vecinos[3] = rgbs[x + 1 + (y + 1)* w];
            }else{
                vecinos[3] = 0;
            }
        }else{
            vecinos[1] = 0;
            vecinos[2] = 0;
            vecinos[3] = 0;
        }
        
        if(y > miny){
            vecinos[0] = rgbs[x + (y - 1) * w];
        }else{
            vecinos[0] = 0;
        }
        
        if(y < maxy){
            vecinos[4] = rgbs[x + (y + 1) * w];
        }else{
            vecinos[4] = 0;
        }
    }
    
    private boolean cumpleCondicionesItera1(int color, int [] vecinos){
        if(cumpleCondicionesComunes(color, vecinos)){
            if(vecinos[0] != color || vecinos[2] != color || vecinos[4] != color){
                if(vecinos[2] != color || vecinos[4] != color || vecinos[6] != color){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean cumpleCondicionesItera2(int color, int [] vecinos){
        if(cumpleCondicionesComunes(color, vecinos)){
            if(vecinos[0] != color || vecinos[2] != color || vecinos[6] != color){
                if(vecinos[0] != color || vecinos[4] != color || vecinos[6] != color){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean cumpleCondicionesComunes(int color, int [] vecinos){
        int n = 0; //N(p)
        int s = 0; //S(p)
        
        for(int vecino: vecinos){
            if(vecino == color){
                n++;
            }
        }
        
        for(int i = 1; i<8; i++){
            if(vecinos[i - 1] != color && vecinos[i] == color){
                s++;
            }
        }
        if(vecinos[7] != color && vecinos[0] == color){
            s++;
        }
        
        if(n >= 2 && n <= 6 && s == 1)
            return true;
        return false;
    }
}
