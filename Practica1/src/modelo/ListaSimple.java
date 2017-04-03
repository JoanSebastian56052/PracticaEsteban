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

    private Nodo auxiliar;
    private Nodo a;
    private Nodo b;
    
    
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
    
    public ListaSimple sumaPolinomios(ListaSimple q) {
            a=this.primerNodo();
            b=q.primerNodo();
            ListaSimple suma = new ListaSimple();

            while(!finRecorrido(a) || !q.finRecorrido(b)){
                
              if(a.getExponente()>b.getExponente()){
                suma.insertarNodo(a.getCoeficiente(),a.getExponente());
                a=a.getLiga();
              }

              if(a.getExponente()<b.getExponente()){
                suma.insertarNodo(b.getCoeficiente(),b.getExponente() );
                b=b.getLiga();
              }

              if(a.getExponente()==b.getExponente()){
                suma.insertarNodo(a.getCoeficiente()+b.getCoeficiente(),a.getExponente() );
                a=a.getLiga();
                b=b.getLiga();
              }
            }
            while(!finRecorrido(a) ){
                  suma.insertarNodo(a.getCoeficiente(),a.getExponente());
                a=a.getLiga();
            }

            while(!q.finRecorrido(b) ){
                suma.insertarNodo(b.getCoeficiente(),b.getExponente());
                b=b.getLiga();
            }

            return suma;
    }

    public ListaSimple multiplcacion(ListaSimple q){
        a = this.primerNodo();
        b= q.primerNodo();
        ListaSimple aux = new ListaSimple();
        while(!finRecorrido(a)){ 
            while(!q.finRecorrido(b)){
                aux.insertarNodo(a.getCoeficiente()*b.getCoeficiente(), (int)a.getExponente()+ (int) b.getExponente());
                b=b.getLiga();
            }
            a=a.getLiga();
            b= q.primerNodo();
        }
        aux.ordenar();
        return aux;
    }
    public boolean detFactor(float c){
        boolean isfactor = false;
            if(this.evalua(c) == 0){isfactor = true;};
        return isfactor;
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
        float valor = integrarla.evalua(b) - integrarla.evalua(a);
        return valor;
    } 
    
    
    public ListaSimple derivar(){
        
        a= this.primerNodo();
        ListaSimple derivada = new ListaSimple();

        derivada.cabeza = this.cabeza();
        derivada.cabeza.setCoeficiente(0);
        
        while(!finRecorrido(a)){
            int newexp = a.getExponente()-1;
            if(a.getExponente() <= 0){
               newexp = a.getExponente();
            }
            float newcoe = a.getCoeficiente() * a.getExponente();
            derivada.insertarNodo(newcoe, newexp);
            
            a = a.getLiga();
        }
        return derivada;
    }
    
    public ListaSimple nDerivada(int n){
        ListaSimple nDer =  this;
                
        for (int i=1; i <= n ; i++){
            System.out.println("en nº rept de derivada : "+ i);
            System.out.println(nDer.primero.getCoeficiente() + " " + nDer.primero.getExponente());
            nDer = nDer.derivar();
            System.out.println(nDer.mostrar());
        }
        return nDer;
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
    
    public void ordenar(){
        Nodo p;
        Nodo pp ;
        Nodo q;
        Nodo pq;
        Nodo max;
        Nodo pmax;
        
        p = primerNodo();
        pp = null;
        while(p != ultimoNodo()){
            max = p;
            pmax = pp;
            q = p.getLiga();
            pq = p;
            
            while(!finRecorrido(q)){
                if(q.getExponente() > max.getExponente()){
                    max = q;
                    pmax = pq;
                }
                pq = q;
                q = q.getLiga();
            }
            if(max == p){
                pp = p;
                p = p.getLiga();
            }else{
                desconectar(max, pmax);
                conectar(max,pp);
                pp = max;
            } 
        }
    }
    public void insertarNodo(float c, int e){
        Nodo nuevo = new Nodo(c,e);
        if(this.esVacia()){
            cabeza.setExponente(e);
            cabeza.setCoeficiente(cabeza.getCoeficiente()+1);
            primero = nuevo;
            ultimo = nuevo;
            cabeza.setLiga(primero);
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
            cabeza.setLiga(x);
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
            paraMostrar = paraMostrar + cambielo.getCoeficiente() + "x" + cambielo.getExponente() + " ";
            cambielo = cambielo.getLiga();
        }
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
            System.out.println("el nuevo primero es:"+primero.getExponente());
            cabeza.setLiga(primero);
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
