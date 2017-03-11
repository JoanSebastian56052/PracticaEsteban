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


    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vistaPoli.cbOpciones){
            switch (vistaPoli.cbOpciones.getSelectedIndex()) {
                //Determinar Polinomio
                case 1:
                    //Restablecer las variables por si el usuario quiere realizar otra operación
                    vistaPoli.Resultado.setVisible(false);
                    vistaPoli.txtPol2.setText("");
                    vistaPoli.txtPol2.setEditable(true);
                    //------------------------------
                    vistaPoli.PoliUser.setVisible(true);
                    vistaPoli.PoliUser.setText("Polinomio ingresado: "+vistaPoli.txtPol1.getText());
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
