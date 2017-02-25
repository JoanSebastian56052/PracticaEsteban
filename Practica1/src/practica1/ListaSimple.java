/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

public class ListaSimple {
    
    private Nodo primero;
    private Nodo ultimo;
    
    public ListaSimple() {
        primero = null;
        ultimo = null;
    }
    
    public boolean esVacia() {
        if (primero == null) {
            return true;
        }
        return false;
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
    
    public void recorre() {
        Nodo p;
        p = primerNodo();
        
        while(!finRecorrido(p)) {
            p = p.retornaLiga();
        }
    }
    
    Nodo buscaInsertar(int s, int c, int e) {
        Nodo p;
        Nodo q;
        p= primerNodo();
        q = anterior(p);
        
        while(!finRecorrido(p) && p.retornaExponente() < e) {
            q = p;
            p = p.retornaLiga();
        }
        
        return q;
    }
    
    public void insertar(int s, int c, int e, Nodo y) {
        Nodo x;
        x = new Nodo(s, c, e);
        conectar(x,y);
    }


    private void conectar(Nodo x, Nodo y) {
        if (y != null) {
            x.asignaLiga(y.retornaLiga());
            y.asignaLiga(x);
            if( y == ultimo) {
                ultimo = x;
            }
        } else {
            x.asignaLiga(primero);
            if(primero == null) {
                ultimo = x;
            }
            primero = x;
        }
    }
    
    public Nodo buscarDato(int s, int c, int e, Nodo y) {
        Nodo x = primerNodo();
        y = anterior(x);
        while (!finRecorrido(x) && x.retornaExponente() != e) {
            y = x;
            x = x.retornaLiga();
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
            y.asignaLiga(x.retornaLiga());
            if(x == ultimo) {
                ultimo = y;
            }
        } else {
            primero = primero.retornaLiga();
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
            p = p.retornaLiga();
        }
        return q;
    }

}
