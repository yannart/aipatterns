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
    float[] momentos;

    BaseConocimientoNumeros(int valor, int hoyos, float densidad, float momento1, float momento2, float momento3) {
        this.valor = valor;
        this.hoyos = hoyos;
        this.densidad = densidad;
        momentos = new float[3];
        momentos[0] = momento1;
        momentos[1] = momento2;
        momentos[2] = momento3;
    }

    public static BaseConocimientoNumeros encuentraNumero(int hoyos, float densidad, float momento1, float momento2, float momento3) {
        float[] momentos = {momento1, momento2, momento3};
        BaseConocimientoNumeros solucion = null;
        BaseConocimientoNumeros solucion2 = null;
        int mejorPuntaje = 0;
        double menorDiferencia = Double.MAX_VALUE;

        if (hoyos == 2) {
            return NUM8;
        }

        if (momentos[0] < 0.843f + 0.843f * 0.25f && momentos[0] > 0.843f - 0.843f * 0.25f && momentos[1] < 0.618f + 0.618f * 0.25f && momentos[1] > 0.618f - 0.618f * 0.25f) {
            return NUM4;
        }

        if (momentos[0] < 1.745f + 1.745f * 0.25f && momentos[0] > 1.745f - 1.745f * 0.25f && momentos[1] < 2.98f + 2.98f * 0.25f && momentos[1] > 2.98f - 2.98f * 0.25f) {
            return NUM1;
        }
        
        if (momentos[0] < 1.502f + 1.502f * 0.25f && momentos[0] > 1.502f - 1.502f * 0.25f && momentos[1] < 2.05f + 2.05f * 0.25f && momentos[1] > 2.05f - 2.05f * 0.25f) {
            return NUM2;
        }

        for (BaseConocimientoNumeros numero : BaseConocimientoNumeros.values()) {
            if (numero.hoyos < hoyos) {
                continue;
            }

            int puntaje = 0;
            double diferenciaCuadratica = 0;

            diferenciaCuadratica += Math.sqrt(Math.pow(numero.hoyos - hoyos, 2));

            diferenciaCuadratica += Math.sqrt(Math.pow(numero.densidad - densidad, 2)) / 10;

            for (int j = 0; j < 3; j++) {
                diferenciaCuadratica += Math.sqrt(Math.pow(numero.momentos[j] - momentos[j], 2));
            }

            if (diferenciaCuadratica < menorDiferencia) {
                menorDiferencia = diferenciaCuadratica;
                solucion2 = numero;
            }

//            if (numero.hoyos == hoyos) {
//                puntaje++;
//            }
//
//            for (int j = 0; j < 3; j++) {
//                if (momentos[j] < numero.momentos[j] + numero.momentos[j] * 0.1f
//                        && momentos[j] > numero.momentos[j] - numero.momentos[j] * 0.1f) {
//                    puntaje++;
//                }
//            }
//
//            if (densidad < numero.densidad + numero.densidad * 0.1f
//                    && densidad > numero.densidad - numero.densidad * 0.1f) {
//                puntaje++;
//            }
//
//            if(puntaje > mejorPuntaje){
//                mejorPuntaje = puntaje;
//                solucion = numero;
//            }
        }

        return solucion2;
    }

    @Override
    public String toString() {
        return "" + valor;
    }
}
