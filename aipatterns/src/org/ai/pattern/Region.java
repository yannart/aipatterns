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
    int perimetro = 1;
    long area = 1;
    int color;
    int minx, miny, maxx, maxy;
    
    public Region(){
        
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
}
