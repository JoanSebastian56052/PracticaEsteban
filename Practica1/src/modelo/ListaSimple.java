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
        cabeza = null;
    }
    
    public boolean esVacia() {
        return primero == null;
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
        return x  == null;
    }
    public Nodo CrearCabeza(int exponente){
        cabeza = new Nodo(0, exponente);
        return cabeza;
    }
    public double evalua(double v) {
        Nodo p = primerNodo();
        
        Nodo q = ultimoNodo();
        //System.out.println(p.getLiga() + " " + p.getExponente() + " " + p.getCoeficiente() + " " + q.getLiga() + " " + q.getExponente() + " " + q.getCoeficiente());
        while(!finRecorrido(p) || (primerNodo() == ultimoNodo())){ 
            evaluar = p.getCoeficiente();
            System.out.println("con coeficiente: " + evaluar);
            evaluar = evaluar * (double)Math.pow(v, p.getExponente());
            System.out.println("al ser elevado y multiplicado: " + evaluar);
            total = total + evaluar;
            p = p.getLiga();
            
        }
        return (total);
    }
    
    public ListaSimple sumaPolinomios(ListaSimple p, ListaSimple q) {
        a = p.primerNodo();
        b= q.primerNodo();
        ListaSimple suma = new ListaSimple();
        
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
    
    public void insertarNodo(int c, int e){
        Nodo nuevo = new Nodo(c,e);
        if(this.esVacia()){
            cabeza =  CrearCabeza(e);
            this.primero = nuevo;
            this.cabeza.setLiga(primero);
            this.ultimo = nuevo;
        }else{
            auxiliar = this.ultimoNodo();              
            auxiliar.setLiga(nuevo);
            this.ultimo = nuevo;
        } 
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
    
    public String mostrar(){
        Nodo cambielo = this.primerNodo();
        
        String paraMostrar = "";
        while(!finRecorrido(cambielo)){
            System.out.println(cambielo.getCoeficiente() + "x" + cambielo.getExponente());
            paraMostrar = paraMostrar + cambielo.getCoeficiente() + "x" + cambielo.getExponente();
            cambielo = cambielo.getLiga();
        }
         System.out.println(paraMostrar);
        return paraMostrar;
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
    
    public void borrar(Nodo x, Nodo y) {
        if (x == null) {
            return;
        }
        desconectar(x, y);
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
    
}
