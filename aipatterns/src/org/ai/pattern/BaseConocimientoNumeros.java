/*
 * BaseConocimientoHerramientas.java
 *
 * Created on 2 juil. 2007, 17:27:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.ai.pattern;

/**
 *
 * @author yannart
 */
public enum BaseConocimientoNumeros {
    
    NUM1(1, 0,  52f, 0.578f, 0.27f, 0.009f),
    NUM2(2, 0, 106f, 0.59f, 0.149f, 0.018f),
    NUM4(4, 1, 89f, 0.352f, 0.0254f, 0.016f),
    NUM8(8, 2, 136f, 0.376f, 0.0415f, 6E-4f),
    NUM9(9, 1, 95.5f, 0.32f, 0.01f, 0.0025f);
    
    int valor;
    int hoyos;
    float densidad;
    float momento1;
    float momento2;
    float momento3;
    
    BaseConocimientoNumeros(int valor, int hoyos, float densidad, float momento1, float momento2, float momento3){
        this.valor = valor;
        this.hoyos = hoyos;
        this.densidad = densidad;
        this.momento1 = momento1;
        this.momento2 = momento2;
        this.momento3 = momento3;
    }
    
    public static BaseConocimientoNumeros encuentraNumero(int hoyos, float densidad, float momento1, float momento2, float momento3){
        if(hoyos == 2 || densidad > 120){
            return NUM8;
        }else if(hoyos == 0){
            if(densidad < (NUM1.densidad + NUM2.densidad) / 2.0){
                return NUM1;
            }else{
                return NUM2;
            }
        }else if(hoyos == 1) {
            if(densidad < (NUM4.densidad + NUM9.densidad) / 2.0){
                return NUM4;
            }else{
                return NUM9;
            }
        }else{
            return null;
        }
    }
    
    @Override
    public String toString(){
        return "" + valor;
    }
}
