/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocompletar.componente;

import autocompletar.logica.AutoCompletar;
import autocompletar.logica.DesplegableJPopUPMenu;
import autocompletar.logica.ModeloAutoCompletar;

/**
 *
 * @author diego
 */
public class AutoCompletarTextField extends javax.swing.JPanel {

    /**
     * Creates new form AutoCompletarTextField
     */
    public AutoCompletarTextField() {
        initComponents();
        ((AutoCompletar)txtBuscar).setDesplegable(new DesplegableJPopUPMenu(txtBuscar));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new javax.swing.JLabel();
        txtBuscar = new AutoCompletar();

        label.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    /**
     * Cambia el valor del label del JPanel
     * @param label 
     */
    public void setLabel(String texto){
        label.setText(texto);
    }
    /**
     * Setea la lista de elementos donde se realiza la busqueda
     * @param nuevaLista 
     */
    public void setModelo(ModeloAutoCompletar modelo){
        ((AutoCompletar)txtBuscar).setModelo(modelo);
    }
    
    public void añadirElementoLista(Object elemento){
        ((AutoCompletar)txtBuscar).getModelo().añadirElemento(elemento);
    }
    
    public Object getItemSeleccionado(){
        return ((AutoCompletar)txtBuscar).getSelectedItem();
    }
}
