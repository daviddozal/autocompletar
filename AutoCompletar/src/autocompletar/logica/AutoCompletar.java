/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocompletar.logica;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author diego
 */
public class AutoCompletar extends JTextField {

    private String texto = "";
    private ModeloAutoCompletar modelo;
    private DesplegableJPopUPMenu desplegable;
    private Object SelectedItem;

    public AutoCompletar() {

        desplegable = new DesplegableJPopUPMenu(this);

        /**
         * evento de tecla para empezar el autocompletado
         */
        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() < 65 || e.getKeyCode() > 90) {//si no es un caracter
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        desplegable.ocultar();
                        
                        setSelectionStart(getText().length());

                    } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {//ver si si se esta borrando un caracter
                        texto = borrarUltimoCaracter(texto);
                        desplegable.mostrarElentosSimilares(texto);
                    }
                } else {
                    texto = texto + e.getKeyChar();
                    
                    for(int i=0;i<modelo.getListaElementos().size();i++){
                        String elemento = modelo.getElemento(i);
                        boolean cumplePatron = Pattern.matches(texto.toUpperCase() + ".*", elemento.toUpperCase());
                        if (cumplePatron) {
                            setText(texto + autoCompletar(texto.toLowerCase(), elemento.toLowerCase()));
                            desplegable.mostrarElentosSimilares(texto);
                            break;
                        }
                    }
                    setSelectionStart(texto.length());
                }
            }
        });
    }

    public DesplegableJPopUPMenu getDesplegable() {
        return desplegable;
    }

    public void setDesplegable(DesplegableJPopUPMenu desplegable) {
        this.desplegable = desplegable;
    }

    public ModeloAutoCompletar getModelo() {
        return modelo;
    }

    public void setModelo(ModeloAutoCompletar modelo) {
        this.modelo = modelo;
    }

    public void setDespelgable(DesplegableJPopUPMenu despl) {
        desplegable = despl;
    }

    /**
     * este metodo lo utiliza el item cuando se selecciona.
     *
     * @param texto
     */
    public void setTexto(String texto) {
        this.texto = texto;
        setText(texto);
    }

    public String getTexto() {
        return texto;
    }

    public Object getSelectedItem() {
        return SelectedItem;
    }

    public void setSelectedItem(Object SelectedItem) {
        this.SelectedItem = SelectedItem;
    }
    
    public void setSelectedItem(int index) {
        if(modelo.getListaElementos()!=null){
            SelectedItem = modelo.getElemento(index);
        }
    }
    
    /**
     * devuelve la cadena ingresada en "cadena" sin el texto ingresado en
     * "quitarTexto"
     *
     * @param quitarTexto
     * @param cadena
     * @return Si cadena="Hola" y quitarTexto="H" devuelve "ola"
     */
    private String autoCompletar(String quitarTexto, String cadena) {
        return cadena.substring(quitarTexto.length());
    }

    private String borrarUltimoCaracter(String cadena) {
        if (getText().length() == 0) {
            return "";
        } else if (getText().length() == cadena.length()) {//el texto en el TextField es igual al escrito, no se ha borrado nada (solo texto seleccionado)
            return cadena;
        } else if (cadena.length() > 0) {
            cadena = cadena.substring(0, cadena.length() - 1);
        }

        return cadena;
    }
}
