/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocompletar.logica;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author diego
 */
public class AutoCompletar extends JTextField {

    private String texto = "";
    private ModeloAutoCompletar modelo;
    private DesplegableJPopUPMenu desplegable = new DesplegableJPopUPMenu(this);
    private Object SelectedItem;

    public AutoCompletar() {
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

                    for (int i = 0; i < modelo.getListaElementos().size(); i++) {
                        String elemento = modelo.getElementoString(i);
                        if (verificaPatron(texto, elemento)) {
                            setText(texto + autoCompletar(texto.toLowerCase(), elemento.toLowerCase()));
                            desplegable.mostrarElentosSimilares(texto);
                            break;
                        } else {
                            desplegable.ocultar();
                        }
                    }
                    setSelectionStart(texto.length());
                }
            }
        });
    }

    /**
     * verifica que el texto ingresado concuerde con el elemento seleccionado de
     * la lista
     *
     * @param elemento
     * @return
     */
    public boolean verificaPatron(String texto, String elemento) {

        boolean cumplePatron = false;

        for (String string : elemento.split(" ")) {
            cumplePatron = string.toUpperCase().startsWith(texto.toUpperCase());
            if (cumplePatron) {
                break;
            }
        }

        return cumplePatron;
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

    public void setSelectedItem(String nombreItem) {
        for (int i = 0; i < modelo.getListaElementos().size(); i++) {
            if (modelo.getElementoString(i).equals(nombreItem)) {
                this.SelectedItem = modelo.getListaElementos().get(i);
                texto = modelo.getElementoString(i);
                setText(texto);
                break;
            }
        }
    }

    public void setSelectedItem(int index) {
        if (modelo.getListaElementos() != null) {
            SelectedItem = modelo.getListaElementos().get(index);
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
        String retorno = "";
        if (cadena.split(" ").length > 1) {
            if (cadena.split(" ")[0].toUpperCase().startsWith(quitarTexto.toUpperCase())) {
                retorno = cadena.substring(quitarTexto.length());
            }
        } else {
            retorno = cadena.substring(quitarTexto.length());
        }
        return retorno;
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
