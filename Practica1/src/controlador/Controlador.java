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
        ListaSimple pol = new ListaSimple(); 
        String auxC=""; //auxiliar coeficiente para detectar el coeficiente correspondiente a cada monomio
        String auxE="0"; //auxiliar exponente para detectar el coeficiente correspondiente a cada monomio
        
        //variable coe y exp para saber si el numero es un coeficiente o exponente
        boolean coe = true; 
        boolean exp = false;
        //recorremos todo el polinomio 
        for(int i = 0; i < polinomio.length(); i++) {
            System.out.println(polinomio.charAt(i));
            //Detectaremos los posibles caracteres que se encontrará, dependiendo de cada caracter,
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
                case '.':
                    if(coe) {
                        auxC=auxC+polinomio.charAt(i);
                    } else if (exp) {
                        auxE = auxE + polinomio.charAt(i);
                    }
                    if(polinomio.charAt(i) == '.' && polinomio.charAt(i-1) == '.'){
                       auxE = auxE;
                    }
                    break;
                case 'x':
                    if(i > 0 ){
                        if( polinomio.charAt(i-1) == '-' || polinomio.charAt(i-1) == '+') {
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
                        pol.insertarNodo(Float.parseFloat(auxC), Integer.parseInt(auxE));
                        System.out.println(auxC);
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
                default:
                    auxE="";
                    auxC="";        
                    break;
            }
            
        }
        if(auxE != "" && auxC != ""){
            pol.insertarNodo(Float.parseFloat(auxC), Integer.parseInt(auxE));
        }
        pol.ordenar();
        
        System.out.println("mi lista es: "+ pol.mostrar());
        System.out.println("el primer nodo tiene expo:"+ pol.primerNodo().getExponente()  + " mi cabeza tiene de liga: "+pol.cabeza().getLiga()+ "con exponente: "+pol.cabeza().getLiga().getExponente());
        return pol;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        String aux1 = sinEspacios(vistaPoli.txtPol1.getText());
        ListaSimple list = toList(aux1);

        if(e.getSource() == vistaPoli.cbOpciones){
            if(list.cabeza().getLiga() == null){
                  vistaPoli.txtPol1.setText("");
                  //oe = true;
                  vistaPoli.cbOpciones.setSelectedIndex(0);
                  JOptionPane.showMessageDialog(null, "Polinomio incorrecto, por favor digitar polinomio válido, revise los requisitos");
            }
            switch (vistaPoli.cbOpciones.getSelectedIndex()) {
                //evaluar Polinomio
                case 1:
                    //Restablecer las variables por si el usuario quiere realizar otra operación
                    
                    //------------------------------
                    vistaPoli.PoliUser.setVisible(true);
                    vistaPoli.PoliUser.setText("Polinomio ingresado: "+aux1);
                    vistaPoli.txtPol2.setVisible(true);
                    vistaPoli.jLabelPoli2.setText("Ingrese c");
                    vistaPoli.jLabelPoli2.setVisible(true);
                    vistaPoli.btnAccion.setText("Determinar");
                    vistaPoli.btnAccion.setVisible(true);
                    vistaPoli.ResultadoFin.setVisible(false);
                    vistaPoli.Resultado.setVisible(false);


                break;

                //Sumar Polinomios
                case 2:
                    //Restablecer las variables por si el usuario quiere realizar otra operación
                    
                    //------------------------------
                    vistaPoli.PoliUser.setVisible(true);
                    vistaPoli.PoliUser.setText("Polinomio ingresado: "+aux1);
                    vistaPoli.txtPol2.setVisible(true);
                    vistaPoli.jLabelPoli2.setText("Ingrese segundo polinomio");
                    vistaPoli.jLabelPoli2.setVisible(true);
                    vistaPoli.btnAccion.setText("Sumar");
                    vistaPoli.btnAccion.setVisible(true);
                    vistaPoli.ResultadoFin.setVisible(false);
                    vistaPoli.Resultado.setVisible(false);

                break;

                //Multiplicar Polinomios 
                case 3:
                    //Restablecer las variables por si el usuario quiere realizar otra operación
                    
                    //------------------------------
                    vistaPoli.PoliUser.setVisible(true);
                    vistaPoli.PoliUser.setText("Polinomio ingresado: "+aux1);
                    vistaPoli.txtPol2.setVisible(true);
                    vistaPoli.jLabelPoli2.setText("Ingrese segundo polinomio");
                    vistaPoli.jLabelPoli2.setVisible(true);
                    vistaPoli.btnAccion.setText("Multiplicar");
                    vistaPoli.btnAccion.setVisible(true);
                    vistaPoli.ResultadoFin.setVisible(false);
                    vistaPoli.Resultado.setVisible(false);

                break;

                //Determinar (x-c) es factor de P(X)
                case 4:
                    //Restablecer las variables por si el usuario quiere realizar otra operación
                    
                    //------------------------------
                    vistaPoli.PoliUser.setVisible(true);
                    vistaPoli.PoliUser.setText("Polinomio ingresado: "+aux1);
                    vistaPoli.txtPol2.setVisible(true);
                    vistaPoli.jLabelPoli2.setText("Ingrese un valor C para determinar si el (x - c) es factor de P(x) ");
                    vistaPoli.jLabelPoli2.setVisible(true);
                    vistaPoli.btnAccion.setText("Determinar");
                    vistaPoli.btnAccion.setVisible(true);
                    vistaPoli.ResultadoFin.setVisible(false);
                    vistaPoli.Resultado.setVisible(false);

                break;

                //Primera derivada
                case 5:
                    //Restablecer las variables por si el usuario quiere realizar otra operación
                   
                    //------------------------------
                    vistaPoli.PoliUser.setVisible(true);
                    vistaPoli.PoliUser.setText("Polinomio ingresado: "+aux1);
                    vistaPoli.jLabelPoli2.setVisible(false);
                    vistaPoli.txtPol2.setVisible(false);
                    vistaPoli.txtPol2.setEditable(false);
                    vistaPoli.btnAccion.setText("Primera derivada");
                    vistaPoli.btnAccion.setVisible(true);
                    vistaPoli.ResultadoFin.setVisible(false);
                    vistaPoli.Resultado.setVisible(false);
                    //Inicio código o implemenacion de métodos

                break;

                //n-ésima derivada
                case 6:
                    //Restablecer las variables por si el usuario quiere realizar otra operación
                    
                    //------------------------------
                    vistaPoli.PoliUser.setVisible(true);
                    vistaPoli.PoliUser.setText("Polinomio ingresado: "+aux1);
                    vistaPoli.jLabelPoli2.setVisible(false);
                    vistaPoli.txtPol2.setVisible(false);
                    vistaPoli.txtPol2.setEditable(false);
                    vistaPoli.btnAccion.setText("Enésima derivada");
                    vistaPoli.btnAccion.setVisible(true);
                    vistaPoli.ResultadoFin.setVisible(false);
                    vistaPoli.Resultado.setVisible(false);
                break;

                //Antiderivada
                case 7:
                    //Restablecer las variables por si el usuario quiere realizar otra operación
                    
                    //------------------------------
                    vistaPoli.PoliUser.setVisible(true);
                    vistaPoli.PoliUser.setText("Polinomio ingresado: "+aux1);
                    vistaPoli.txtPol2.setVisible(false);
                    vistaPoli.txtPol2.setEditable(false);
                    vistaPoli.btnAccion.setText("Antiderivada");
                    vistaPoli.btnAccion.setVisible(true);
                    vistaPoli.ResultadoFin.setVisible(false);
                    vistaPoli.Resultado.setVisible(false);
                break;

                //Integral definida
                case 8:
                    //Restablecer las variables por si el usuario quiere realizar otra operación
                    
                    //------------------------------
                    vistaPoli.PoliUser.setVisible(true);
                    vistaPoli.PoliUser.setText("Polinomio ingresado: "+aux1);
                    vistaPoli.txtPol2.setVisible(true);
                    vistaPoli.txtPolAux.setVisible(true);
                    vistaPoli.jLabelPoli2.setText("Ingrese a");
                    vistaPoli.jLabelPoli2.setVisible(true);
                    vistaPoli.jLabelPoliAux.setText("Ingrese b");
                    vistaPoli.jLabelPoliAux.setVisible(true);
                    vistaPoli.btnAccion.setText("Integrar");
                    vistaPoli.btnAccion.setVisible(true);
                    vistaPoli.ResultadoFin.setVisible(false);
                    vistaPoli.Resultado.setVisible(false);
                break;
            }
        }
            
        if(e.getSource()== vistaPoli.btnAccion){
            vistaPoli.btnAccion.setVisible(false);
            vistaPoli.PoliUser.setVisible(false);
            vistaPoli.txtPolAux.setVisible(false);
            vistaPoli.jLabelPoliAux.setVisible(false);
            vistaPoli.jLabelPoli2.setVisible(true);
            vistaPoli.ResultadoFin.setVisible(true);
            vistaPoli.Resultado.setVisible(true);
            vistaPoli.jLabelPoli2.setVisible(false);
            vistaPoli.txtPol2.setVisible(false);
            
            
            
            
            //segun la opcion seleccionada evaluará y mostrará el resultado de lo que se desea:
            switch(vistaPoli.cbOpciones.getSelectedIndex()){
                
                //evaluar
                case 1:
                    float a = Float.parseFloat(vistaPoli.txtPol2.getText());
                    Float sumResult = list.evalua(a);
                    vistaPoli.Resultado.setText(sumResult.toString());
                    ;//resultado según el case
                    break;
                //Suma entre dos listas
                case 2:
                    String auxSum = sinEspacios(vistaPoli.txtPol2.getText());
                    ListaSimple listToSum = toList(auxSum);
                    vistaPoli.Resultado.setText(list.sumaPolinomios(listToSum).mostrar());
                    break;
                //Multiplicacion entre dos listas
                case 3:
                    String auxMult = sinEspacios(vistaPoli.txtPol2.getText());
//                    ListaSimple listMult = toList(auxMult);
//                    vistaPoli.Resultado.setText(list.sumaPolinomios(listMult).mostrar());
//                    break;
                //Determinar (x-c) es factor de P(X)
                case 4:
                    float c = Float.parseFloat(vistaPoli.txtPol2.getText());
                    if(list.detFactor(c) == true){
                        vistaPoli.Resultado.setText("(x - "+c+") es factor de P(x)");
                    }else{
                        vistaPoli.Resultado.setText("(x - "+c+") no es factor de P(x)");
                    }
                    break;
                //Primera derivada
                case 5:
                    vistaPoli.Resultado.setText(list.derivar().mostrar());
                    break;
                //n-ésima derivada
                case 6:
                    float n = Float.parseFloat(vistaPoli.txtPol2.getText());
                    vistaPoli.Resultado.setText(list.nDerivada(Math.round(n)).mostrar());
                    break;
                //Antiderivada
                case 7:
                    vistaPoli.Resultado.setText(list.integral().mostrar());
                    break;
                //Integral definida
                case 8:
                    float d = Float.parseFloat(vistaPoli.txtPol2.getText());
                    float b = Float.parseFloat(vistaPoli.txtPolAux.getText());
                    vistaPoli.Resultado.setText(Float.toString(list.integralDef(d,b)));
                    break;
                    
            }
            
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
