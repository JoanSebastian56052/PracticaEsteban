/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import vista.*;
import modelo.*;

/**
 *
 * @author Santiago
 */
public class Controlador implements ActionListener {
    Polinomios vistaPoli = new Polinomios();
    
    public javax.swing.JTextField txtPol2;
    

    public Controlador(Polinomios vistaPoli) {
        
        this.vistaPoli = vistaPoli;
        this.vistaPoli.btnBorrar.addActionListener(this);
        this.vistaPoli.btnSalir.addActionListener(this);
        this.vistaPoli.cbOpciones.addActionListener(this);
        this.vistaPoli.btnAccion.addActionListener(this);
        
    }
    
    //metodo para quitar los espacios al string ingresado
    public String sinEspacios(String polinomio){
        String aux = "";
        char espacio = ' ';
        for(int i = 0; i < polinomio.length(); i++){
            if(polinomio.charAt(i) != espacio){
                aux = aux + polinomio.charAt(i);
            }
        }
        
        return aux;
    }
    
    //metodo para listar el polinomio 
    public ListaSimple toList(String polinomio){ 
        String auxC=""; //auxiliar coeficiente para detectar el coeficiente correspondiente a cada monomio
        String auxE="0"; //auxiliar exponente para detectar el coeficiente correspondiente a cada monomio
        ListaSimple pol = new ListaSimple(); 
        Nodo aux = new Nodo(0,0);
        aux.setLiga(null);
        //variable coe y exp para saber si el numero es un coeficiente o exponente
        boolean coe = true; 
        boolean exp = false;
        //recorremos todo el polinomio 
        for(int i = 0; i < polinomio.length(); i++) {
            //detectaremos los posibles caracteres que se encontrará, dependiendo de cada caracter,
            //se sabrá si es coeficiente, exponente, variable 'x' y su correspondiente signo
            //al detectar cada monomio se listará.
            switch(polinomio.charAt(i)) {
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '0':
                    if(coe) {
                        auxC=auxC+polinomio.charAt(i);
                    } else if (exp) {
                        auxE = auxE + polinomio.charAt(i);
                    }
                    break;
                case 'x':
                    if(i > 0 ){
                        if(polinomio.charAt(i-1) == '-') {
                            auxC =auxC + "1";
                        }
                        if(i >= polinomio.length()-1) {
                            auxE = auxE + "1";
                        }
                    } else if(i==0) {
                        auxC = auxC + "1";
                        if(i+1 == polinomio.length()) {
                            auxE = auxE + "1";
                        }                       
                    }
                    coe = false;
                    exp = true;
                    break;
                case '+':
                case '-':
                    if(i > 0 ){
                        if(polinomio.charAt(i-1) == 'x') {
                            auxE = "1";
                        }                       
                    }
                    if(exp) {                       
                        pol.insertarNodo(Integer.parseInt(auxC), Integer.parseInt(auxE));
                        System.out.println(auxC);
                        aux.setCoeficiente(Integer.parseInt(auxC));
                        aux.setExponente(Integer.parseInt(auxE));
                        System.out.println(auxC+"x"+auxE);
                        auxC = "";
                        auxC=auxC+polinomio.charAt(i); 
                        auxE = "0";                       
                    } else {
                        auxC=auxC+polinomio.charAt(i);                       
                    }
                    coe = true;
                    exp = false;
                    break;
            }
            
        }        
        pol.insertarNodo(Integer.parseInt(auxC), Integer.parseInt(auxE));
        System.out.println(auxC+"x"+auxE);
        String cualquiera = pol.mostrar();
        System.out.println("mi lista" + cualquiera);
        return pol;
    }

    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vistaPoli.cbOpciones){
            String aux1 = sinEspacios(vistaPoli.txtPol1.getText());
            toList(aux1);
            switch (vistaPoli.cbOpciones.getSelectedIndex()) {
                //Determinar Polinomio
                case 1:
                    //Restablecer las variables por si el usuario quiere realizar otra operación
                    vistaPoli.Resultado.setVisible(false);
                    vistaPoli.txtPol2.setText("");
                    vistaPoli.txtPol2.setEditable(true);
                    //------------------------------
                    vistaPoli.PoliUser.setVisible(true);
                    vistaPoli.PoliUser.setText("Polinomio ingresado: "+aux1);
                    vistaPoli.txtPol2.setVisible(true);
                    vistaPoli.jLabelPoli2.setText("Ingrese c");
                    vistaPoli.jLabelPoli2.setVisible(true);
                    vistaPoli.btnAccion.setText("Determinar");
                    vistaPoli.btnAccion.setVisible(true);
                    
                    
                break;
                
                //Sumar Polinomios
                case 2:
                    //Restablecer las variables por si el usuario quiere realizar otra operación
                    vistaPoli.Resultado.setVisible(false);
                    vistaPoli.txtPol2.setText("");
                    vistaPoli.txtPol2.setEditable(true);
                    //------------------------------
                    vistaPoli.PoliUser.setVisible(true);
                    vistaPoli.PoliUser.setText("Polinomio ingresado: "+vistaPoli.txtPol1.getText());
                    vistaPoli.txtPol2.setVisible(true);
                    vistaPoli.jLabelPoli2.setText("Ingrese segundo polinomio");
                    vistaPoli.jLabelPoli2.setVisible(true);
                    vistaPoli.btnAccion.setText("Sumar");
                    vistaPoli.btnAccion.setVisible(true);
                    
                break;
                
                //Multiplicar Polinomios 
                case 3:
                    //Restablecer las variables por si el usuario quiere realizar otra operación
                    vistaPoli.Resultado.setVisible(false);
                    vistaPoli.txtPol2.setText("");
                    vistaPoli.txtPol2.setEditable(true);
                    //------------------------------
                    vistaPoli.PoliUser.setVisible(true);
                    vistaPoli.PoliUser.setText("Polinomio ingresado: "+vistaPoli.txtPol1.getText());
                    vistaPoli.txtPol2.setVisible(true);
                    vistaPoli.jLabelPoli2.setText("Ingrese segundo polinomio");
                    vistaPoli.jLabelPoli2.setVisible(true);
                    vistaPoli.btnAccion.setText("Multiplicar");
                    vistaPoli.btnAccion.setVisible(true);
                    
                break;
                
                //Determinar P(x)
                case 4:
                    //Restablecer las variables por si el usuario quiere realizar otra operación
                    vistaPoli.Resultado.setVisible(false);
                    vistaPoli.txtPol2.setText("");
                    vistaPoli.txtPol2.setEditable(true);
                    //------------------------------
                    vistaPoli.PoliUser.setVisible(true);
                    vistaPoli.PoliUser.setText("Polinomio ingresado: "+vistaPoli.txtPol1.getText());
                    vistaPoli.txtPol2.setVisible(true);
                    vistaPoli.jLabelPoli2.setText("Ingrese P(x)");
                    vistaPoli.jLabelPoli2.setVisible(true);
                    vistaPoli.btnAccion.setText("Determinar");
                    vistaPoli.btnAccion.setVisible(true);
                    
                break;
                
                //Primera derivada
                case 5:
                    //Restablecer las variables por si el usuario quiere realizar otra operación
                    vistaPoli.Resultado.setVisible(false);
                    vistaPoli.txtPol2.setText("");
                    //------------------------------
                    vistaPoli.PoliUser.setVisible(true);
                    vistaPoli.PoliUser.setText("Polinomio ingresado: "+vistaPoli.txtPol1.getText());
                    vistaPoli.jLabelPoli2.setVisible(false);
                    vistaPoli.txtPol2.setVisible(false);
                    vistaPoli.txtPol2.setEditable(false);
                    vistaPoli.btnAccion.setText("Primera derivada");
                    vistaPoli.btnAccion.setVisible(true);
                    //Inicio código o implemenacion de métodos
                     
                break;
                
                //Enesima derivada
                case 6:
                    //Restablecer las variables por si el usuario quiere realizar otra operación
                    vistaPoli.Resultado.setVisible(false);
                    vistaPoli.txtPol2.setText("");
                    //------------------------------
                    vistaPoli.PoliUser.setVisible(true);
                    vistaPoli.PoliUser.setText("Polinomio ingresado: "+vistaPoli.txtPol1.getText());
                    vistaPoli.jLabelPoli2.setVisible(false);
                    vistaPoli.txtPol2.setVisible(false);
                    vistaPoli.txtPol2.setEditable(false);
                    vistaPoli.btnAccion.setText("Enésima derivada");
                    vistaPoli.btnAccion.setVisible(true);
                break;
                
                //Antiderivada
                case 7:
                    //Restablecer las variables por si el usuario quiere realizar otra operación
                    vistaPoli.Resultado.setVisible(false);
                    vistaPoli.txtPol2.setText("");
                    //------------------------------
                    vistaPoli.PoliUser.setVisible(true);
                    vistaPoli.PoliUser.setText("Polinomio ingresado: "+vistaPoli.txtPol1.getText());
                    vistaPoli.txtPol2.setVisible(false);
                    vistaPoli.txtPol2.setEditable(false);
                    vistaPoli.btnAccion.setText("Antiderivada");
                    vistaPoli.btnAccion.setVisible(true);
                break;
                
                //Integral definida
                case 8:
                    //Restablecer las variables por si el usuario quiere realizar otra operación
                    vistaPoli.Resultado.setVisible(false);
                    vistaPoli.txtPol2.setText("");
                    vistaPoli.txtPol2.setEditable(true);
                    //------------------------------
                    vistaPoli.PoliUser.setVisible(true);
                    vistaPoli.PoliUser.setText("Polinomio ingresado: "+vistaPoli.txtPol1.getText());
                    vistaPoli.txtPol2.setVisible(true);
                    vistaPoli.txtPolAux.setVisible(true);
                    vistaPoli.jLabelPoli2.setText("Ingrese a");
                    vistaPoli.jLabelPoli2.setVisible(true);
                    vistaPoli.jLabelPoliAux.setText("Ingrese b");
                    vistaPoli.jLabelPoliAux.setVisible(true);
                    vistaPoli.btnAccion.setText("Integrar");
                    vistaPoli.btnAccion.setVisible(true);
                break;
                
                

            }
        }
        if(e.getSource()== vistaPoli.btnAccion){
            
           
            vistaPoli.btnAccion.setVisible(false);
            vistaPoli.PoliUser.setVisible(false);
            vistaPoli.txtPolAux.setVisible(false);
            vistaPoli.jLabelPoliAux.setVisible(false);
            vistaPoli.jLabelPoli2.setVisible(false);
            
            vistaPoli.Resultado.setVisible(true);
            vistaPoli.txtPol2.setText("Resultado"); //resultado según el case
            vistaPoli.txtPol2.setEditable(false);
        }
        if(e.getSource() == vistaPoli.btnBorrar){
            
            vistaPoli.txtPol1.setText("");
            JOptionPane.showMessageDialog(null, "Se restalecerá al polinomio 0 = P(c)");
        }
        if(e.getSource() == vistaPoli.btnSalir){
            JOptionPane.showMessageDialog(null, "Hasta luego");
            System.exit(0);
        }
    
//    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    }   
}
