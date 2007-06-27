
package org.ai.pattern;

import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author yannart
 */
public class Regiones extends Tratamiento{
    
    private int pasadas = 4;
    
    public Regiones(Filtrable parent){
        super(parent);
    }
    
    @Override
    void tratamientoImagen() {
        BufferedImage bufferedImage = imagen.getImagen();
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        int[] rgbs = new int[w*h];
        bufferedImage.getRGB(0,0,w,h,rgbs,0,w);
        
        int colores = 1;
        int pixel;
        int r, s, t, u;
        
        /* Posicion de los pixeles:
         *      s  r  u
         *      t  P  x
         *      x  x  x
         */
        for(int y = 0; y < h; y++){
            for(int x =0; x < w; x++){
                
                if(x > 0){
                    t = rgbs[y * w + (x - 1)] & 0x00FFFFFF;
                    if(y > 0){
                        s = rgbs[(y - 1)* w + (x - 1)] & 0x00FFFFFF;
                    }else{
                        s = 0;
                    }
                }else{
                    s = 0;
                    t = 0;
                }
                
                if(y > 0){
                    r = rgbs[(y - 1)* w + x] & 0x00FFFFFF;
                    if(x != w - 1){
                        u = rgbs[(y - 1)* w + (x + 1)] & 0x00FFFFFF;
                    }else{
                        u = 0;
                    }
                }else{
                    r = 0;
                    u = 0;
                }
                pixel = bufferedImage.getRGB(x,y) & 0x00FFFFFF;
                
                if(pixel != 0){
                    if(s != 0){
                        pixel = s;
                    }else if(r != 0){
                        pixel = r;
                    }else if(u != 0){
                        pixel = u;
                    }else if(t != 0){
                        pixel = t;
                    }else{
                        pixel = colores;
                        colores++;
                    }
                }
                rgbs[y * w + x] = pixel;
            }
        }
        
        //Pasadas intermedias:
        /* Posicion de los pixeles:
         *      x  x  x
         *      x  P  t
         *      x  x  x
         */
        Random generator = new Random();
        int pintado[] = new int [colores];
        
        for(int p = 0; p < pasadas - 1; p++){
            colores = 1;
            
            for(int y = 0; y < h; y++){
                for(int x = 0; x < w; x++){
                    
                    if(x != w - 1){
                        t = rgbs[y * w + (x + 1)];
                    }else{
                        t = 0;
                    }
                    pixel = rgbs[y * w + x];
                    if(pixel != 0){
                        if(pintado[t] != 0 && pixel != t){
                            pintado[pixel] = pintado[t];
                        }else{
                            if(pintado[pixel] == 0){
                                pintado[pixel] = colores;
                                colores++;
                            }
                        }
                    }
                }
            }
            
            for(int y = 0; y < h; y++){
                for(int x = 0; x < w; x++){
                    pixel = rgbs[y * w + x];
                    rgbs[y * w + x] = pintado[pixel];
                }
            }
            
            for(int i = 0; i < pintado.length; i++){
                pintado[i] = 0;
            }
        }
        
        //Ultima pasada
        Map <Integer, Region> regiones = new HashMap <Integer, Region> ();
        Region region;
        int color = 0;
        for(int y = 0; y < h; y++){
            for(int x = 0; x < w; x++){
                pixel = rgbs[y * w + x];
                if(pixel != 0){
                    if(pintado[pixel] == 0){
                        do{
                            color = generator.nextInt(16777215) + 1;
                        }while(regiones.containsKey(color));
                        pintado[pixel] = color;
                        rgbs[y * w + x] = color;
                        region = new Region();
                        region.setColor(color);
                        region.setMaxx(x);
                        region.setMaxy(y);
                        region.setMinx(x);
                        region.setMiny(y);
                        regiones.put(color, region);
                    }else{
                        region = regiones.get(pintado[pixel]);
                        assert region != null: "La region debe de existir";
                        region.incrementaArea();
                        
                        if(x < region.getMinx()){
                            region.setMinx(x);
                        }else if(x > region.getMaxx()){
                            region.setMaxx(x);
                        }
                        if(y < region.getMiny()){
                            region.setMiny(y);
                        }else if(y > region.getMaxy()){
                            region.setMaxy(y);
                        }
                        
                        if(x != 0 && rgbs[x - 1 + y * w] == 0)
                            region.incrementaPerimetro();
                        else if (y != 0 && rgbs[x + (y - 1) * w] == 0)
                            region.incrementaPerimetro();
                        else if (x != w - 1 && rgbs[x + 1 + y * w] == 0)
                            region.incrementaPerimetro();
                        else if (y != h - 1 && rgbs[x + (y + 1) * w] == 0)
                            region.incrementaPerimetro();
                        else if(x != 0 && y != 0 && rgbs[x - 1 + (y - 1) * w] == 0)
                            region.incrementaPerimetro();
                        else if(x != 0 && y != h - 1 && rgbs[x - 1 + (y + 1) * w] == 0)
                            region.incrementaPerimetro();
                        else if(x != w - 1 && y != 0 && rgbs[x + 1 + (y - 1) * w] == 0)
                            region.incrementaPerimetro();
                        else if(x != w - 1 && y != h - 1 && rgbs[x + 1 + (y + 1) * w] == 0)
                            region.incrementaPerimetro();
                        
                        rgbs[y * w + x] = pintado[pixel];
                    }
                }
            }
        }
        
        bufferedImage.setRGB(0, 0, w, h, rgbs, 0, w);
        buscaRasgos(regiones.values(), bufferedImage);
        imagen.setRegiones(regiones);
    }
    
    void buscaRasgos(Collection <Region> regiones, BufferedImage imagen){
        for(Region region: regiones){
            Momentos m = new Momentos(region.getMinx(),
                    region.getMiny(),
                    region.getMaxx(),
                    region.getMaxy(),
                    region.getColor(),
                    imagen);
            region.setMomentos(m);
        }
    }
    
    
    @Override
    String getMensajeExito() {
        return "Regiones detectadas en";
    }
    
    public void setPasadas(int pasadas) {
        this.pasadas = pasadas;
    }
}

