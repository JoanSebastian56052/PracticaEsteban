/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author joan.morales
 */
public class Nodo {
    
    
    private Nodo liga;
    private int exp;
    private int coe;
    private int signo;
    
    
    public Nodo(int s, int c, int e) {
        signo = s;
        coe = c;
        exp = e;
        liga = null;
    }
    
    public int retornaExponente() {
        return exp;
    }
    
    public int retornaCoeficiente() {
        return coe;
    }
    
    public int retornaSigno() {
        return signo;
    }
    
    public Nodo retornaLiga() {
        return liga;
    }
    
    public void asignaExponente(int e) {
        exp = e;
    }
    
    public void asignaCoeficiente(int c) {
        coe = c;
    }
    
    public void asignaSigno(int s) {
        signo = s;
    }
    
    public void asignaLiga(Nodo x) {
        liga = x;
    }
}
