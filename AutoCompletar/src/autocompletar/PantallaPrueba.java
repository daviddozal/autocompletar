/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocompletar;

import autocompletar.logica.AutoCompletar;
import autocompletar.logica.DesplegableJPopUPMenu;
import autocompletar.logica.ModeloAutoCompletarDefault;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author diego
 */
public class PantallaPrueba extends JFrame {

    /**
     * Creates new form PantallaPrueba
     */
    public PantallaPrueba() {
        initComponents();
        
        
        
        ((AutoCompletar)txtCampo).setDesplegable(new DesplegableJPopUPMenu(txtCampo));
        
        ModeloAutoCompletarDefault modelo = new ModeloAutoCompletarDefault();
        
        ((AutoCompletar)txtCampo).setModelo(modelo);
        ((AutoCompletar)txtCampo).getDesplegable().setForeground(new Color(102,153,255));
        
        setLocationRelativeTo(null);
      
    }
    
    public void iniciar(){
        String listaPantalla = "";
        for (Object object : ((AutoCompletar)txtCampo).getModelo().getListaElementos()) {
            listaPantalla+="\n"+object;
        }
        jtextAreaLista.setText(listaPantalla);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCampo = new autocompletar.logica.AutoCompletar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtextAreaLista = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        cabecera = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Prueba Autocompletar");

        jLabel1.setText("Filtro");

        jtextAreaLista.setColumns(20);
        jtextAreaLista.setRows(5);
        jScrollPane1.setViewportView(jtextAreaLista);

        jLabel3.setText("La lista de prueba tiene estas palabras:");

        cabecera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autocompletar/imgs/cabecera.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCampo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addComponent(cabecera, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(cabecera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cabecera;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea jtextAreaLista;
    private javax.swing.JTextField txtCampo;
    // End of variables declaration//GEN-END:variables
}