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
    private float evaluar;
    private float total = 0;
    private ListaSimple aux;
    private Nodo auxiliar;
    private Nodo a;
    private Nodo b;
    private Nodo c;
    
    public ListaSimple() {
        primero = null;
        ultimo = null;
        cabeza = new Nodo(0,0);
        cabeza.setLiga(primero);
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
//    public Nodo CrearCabeza(int exponente){
//        cabeza = new Nodo(0, exponente);
//        return cabeza;
//    }
    public float evalua(float v) {
        Nodo p = primerNodo();
        total = 0; evaluar = 0;
        Nodo q = ultimoNodo();
        while(!finRecorrido(p)){ 
            evaluar = p.getCoeficiente();
            evaluar = evaluar * (float)Math.pow(v, p.getExponente());
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
    public ListaSimple integral(){
        a= this.primerNodo();
        
        ListaSimple integrada = new ListaSimple();

        integrada.cabeza = this.cabeza();
        integrada.cabeza.setCoeficiente(0);
        while(!finRecorrido(a)){
            
            int newexp = a.getExponente()+1;
            
            float newcoe = a.getCoeficiente()/newexp;
            integrada.insertarNodo(newcoe,newexp);
            
            a= a.getLiga();
        }
        return integrada;
    }
    
    public float integralDef(float a, float b){
        ListaSimple integrarla = this.integral();
        float valor = integrarla.evalua(a) - integrarla.evalua(b);
        return valor;
    } 
    
    public ListaSimple multiplcacion (ListaSimple p, ListaSimple q){
        a = p.primerNodo();
        b= q.primerNodo();
        ListaSimple aux2 = new ListaSimple();
        
        while(!finRecorrido(a)){ 
            
            while(!finRecorrido(b)){
                c.setCoeficiente(a.getCoeficiente()*b.getCoeficiente());
                c.setExponente(a.getExponente()+b.getExponente());
                aux.insertar(c.getCoeficiente(), c.getExponente(), aux.buscaInsertar(c.getCoeficiente(), c.getExponente()));
                b.getLiga();
            }
            a.getLiga();
            aux2 = sumaPolinomios(aux, aux2);
        }
        return aux2;
    }
    
    public ListaSimple derivada(ListaSimple p){
         a = p.primerNodo();
         b = p.ultimoNodo();
         while(a!=b){
             c.setCoeficiente(a.getCoeficiente()*a.getExponente());
             c.setExponente(a.getExponente()-1);
             aux.insertar(c.getCoeficiente(), c.getExponente(), aux.buscaInsertar(c.getCoeficiente(), c.getExponente()));
             a.getLiga();
         }
         return aux;
    }

    Nodo buscaInsertar(float c, int e) {
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
    
    public void insertarNodo(float c, int e){
        Nodo nuevo = new Nodo(c,e);
        if(this.esVacia()){
            cabeza.setExponente(e);
            cabeza.setCoeficiente(cabeza.getCoeficiente()+1);
            primero = nuevo;
            ultimo = nuevo;
        }else{
            if(cabeza.getExponente() < e){
                cabeza.setExponente(e);
            }
            cabeza.setCoeficiente(cabeza.getCoeficiente()+1);
            auxiliar = this.ultimoNodo();              
            auxiliar.setLiga(nuevo);
            ultimo = nuevo;
        } 
    }
    public void insertar(float c, int e, Nodo y) {
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
            if(cabeza.getExponente() < x.getExponente()){
                cabeza.setExponente(x.getExponente());
            }
            cabeza.setCoeficiente(cabeza.getCoeficiente()+1);
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
        Nodo cabezon = this.cabeza();

        String paraMostrar = "";
        while(!finRecorrido(cambielo)){
            paraMostrar = paraMostrar + cambielo.getCoeficiente() + "x" + cambielo.getExponente() + " ";
            cambielo = cambielo.getLiga();
        }
        System.out.println(paraMostrar + " y mi cabeza es: " + cabezon.getCoeficiente() + " " +  cabezon.getExponente());
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
    
    public Nodo buscarDato(float c, int e, Nodo y) {
        Nodo x = primerNodo();
        y = anterior(x);
        while (!finRecorrido(x) && x.getExponente() != e) {
            y = x;
            x = x.getLiga();
        }
        return x;
    }
    
}
