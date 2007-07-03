/*
 * Region.java
 *
 * Created on 16 juin 2007, 14:59:12
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.ai.pattern;

/**
 *
 * @author yannart
 */
public class Region {
    private int perimetro = 1;
    private long area = 1;
    private int color;
    private int minx, miny, maxx, maxy;
    private int terminal;
    private int puntoInterno;
    private int puntoCruce;
    private int triada;
    private String nombre;
    private Momentos momentos;
    private BaseConocimientoNumeros numero;

    public BaseConocimientoNumeros getNumero() {
        return numero;
    }

    public void setNumero(BaseConocimientoNumeros numero) {
        this.numero = numero;
    }
    
    public int getTerminal() {
        return terminal;
    }
    
    public void setTerminal(int terminal) {
        this.terminal = terminal;
    }
    
    public int getPuntoInterno() {
        return puntoInterno;
    }
    
    public void setPuntoInterno(int puntoInterno) {
        this.puntoInterno = puntoInterno;
    }
    
    public int getPuntoCruce() {
        return puntoCruce;
    }
    
    public void setPuntoCruce(int puntoCruce) {
        this.puntoCruce = puntoCruce;
    }
    
    public int getTriada() {
        return triada;
    }
    
    public void setTriada(int triada) {
        this.triada = triada;
    }
    
    public int getHoyos() {
        return (triada - terminal) / 2 + 1;
    }
    
    public Momentos getMomentos(){
        return momentos;
    }
    
    public void setMomentos(Momentos momentos){
        this.momentos = momentos;
    }
    
    public int getPerimetro() {
        return perimetro;
    }
    
    public void setPerimetro(int perimetro) {
        this.perimetro = perimetro;
    }
    
    public long getArea() {
        return area;
    }
    
    public void setArea(long area) {
        this.area = area;
    }
    
    public float getCompactacion(){
        return (float) (4 * Math.PI * area / Math.pow(perimetro, 2));
    }
    
    public float getDensidad(){
        return (float) (Math.pow(perimetro, 2) / area);
    }
    
    public int getColor() {
        return color;
    }
    
    public void setColor(int color) {
        this.color = color & 0x00FFFFFF;
    }
    
    public int getMinx() {
        return minx;
    }
    
    public void setMinx(int minx) {
        this.minx = minx;
    }
    
    public int getMiny() {
        return miny;
    }
    
    public void setMiny(int miny) {
        this.miny = miny;
    }
    
    public int getMaxx() {
        return maxx;
    }
    
    public void setMaxx(int maxx) {
        this.maxx = maxx;
    }
    
    public int getMaxy() {
        return maxy;
    }
    
    public void setMaxy(int maxy) {
        this.maxy = maxy;
    }
    
    public void incrementaPerimetro(){
        perimetro++;
    }
    
    public void incrementaArea(){
        area++;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
