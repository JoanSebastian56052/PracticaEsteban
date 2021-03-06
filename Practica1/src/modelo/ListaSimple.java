/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class ListaSimple {
    private Nodo cabeza;
    private Nodo primero;
    private Nodo ultimo;
    private double evaluar;
    private double total = 0;
    private ListaSimple aux;
    private Nodo auxiliar;
    private Nodo a;
    private Nodo b;
    
    public ListaSimple() {
        primero = null;
        ultimo = null;
        cabeza.setLiga(primero);
    }
    
    public boolean esVacia() {
        if (primero == null) {
            return true;
        }
        return false;
    }
    public Nodo cabeza(){
        return cabeza;
    }    
    public Nodo primerNodo() {
        return primero;
    }
    
    public Nodo ultimoNodo() {
        return ultimo;
    }
    
    public boolean finRecorrido(Nodo x) {
        if(x == null) {
            return true;
        }
        return false;
    }
    
    public double recorre(double v) {
        Nodo p;
        p = primerNodo();
        
        while(!finRecorrido(p)) {
            evaluar = p.getCoeficiente();
            evaluar = evaluar * (double)Math.pow(v, p.getExponente());
            total = total + evaluar;
            p = p.getLiga();
        }
        return (total);
    }
    
    public ListaSimple sumaPolinomios(ListaSimple p, ListaSimple q) {
        a = p.primerNodo();
        b= q.primerNodo();
        
        while ((a.getExponente() != 0) || (b.getExponente() != 0)) {
            if(a.getExponente() == b.getExponente()) {
                auxiliar.setCoeficiente(a.getCoeficiente()+a.getCoeficiente());
                auxiliar.setExponente(a.getExponente());
                aux.insertar(auxiliar.getCoeficiente(),auxiliar.getExponente(), aux.buscaInsertar(auxiliar.getCoeficiente(), auxiliar.getExponente()));
            } else if(a.getExponente() > b.getExponente()) {
                aux.insertar(a.getCoeficiente(), a.getExponente(), aux.buscaInsertar(a.getCoeficiente(), a.getExponente()));
                a = a.getLiga();
            } else {
                aux.insertar(b.getCoeficiente(), b.getExponente(), aux.buscaInsertar(b.getCoeficiente(), b.getExponente()));
                b = b.getLiga();
            }
        }
        return aux;
    }
    
    Nodo buscaInsertar(int c, int e) {
        Nodo p;
        Nodo q;
        p= primerNodo();
        q = anterior(p);
        
        while(!finRecorrido(p) && p.getExponente() < e) {
            q = p;
            p = p.getLiga();
        }
        
        return q;
    }
    
    public void insertar(int c, int e, Nodo y) {
        Nodo x;
        x = new Nodo( c, e);
        conectar(x,y);
    }


    private void conectar(Nodo x, Nodo y) {
        if (y != null) {
            x.setLiga(y.getLiga());
            y.setLiga(x);
            if( y == ultimo) {
                ultimo = x;
            }
        } else {
            x.setLiga(primero);
            if(primero == null) {
                ultimo = x;
            }
            primero = x;
        }
    }
    
    public Nodo buscarDato(int c, int e, Nodo y) {
        Nodo x = primerNodo();
        y = anterior(x);
        while (!finRecorrido(x) && x.getExponente() != e) {
            y = x;
            x = x.getLiga();
        }
        return x;
    }
    
    public void borrar(Nodo x, Nodo y) {
        if (x == null) {
            return;
        }
        desconectar(x, y);
    }

    private void desconectar(Nodo x, Nodo y) {
        if (x != primero) {
            y.setLiga(x.getLiga());
            if(x == ultimo) {
                ultimo = y;
            }
        } else {
            primero = primero.getLiga();
            if(primero == null) {
                ultimo = null;
            }
        }
    }
    
    public Nodo anterior(Nodo x) {
        Nodo p;
        Nodo q;
        p = primerNodo();
        q = null;
        
        while(p != x) {
            q = p;
            p = p.getLiga();
        }
        return q;
    }
}
