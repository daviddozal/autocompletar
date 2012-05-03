/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocompletar.logica;

import java.awt.Component;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author diego
 */
public class DesplegableJPopUPMenu extends JPopupMenu {

    //private List<String> listaElementos;
    private Component componenteLlamador;
    private int posX, posY;
    private boolean cajaDeTextoEsVacía = false;

    public DesplegableJPopUPMenu(Component nuevoComponenteLLamador) {
        componenteLlamador = nuevoComponenteLLamador;
        posX = 0;
        posY = (int) componenteLlamador.getPreferredSize().getHeight();
    }

//    public List<String> getElementos() {
//        return listaElementos;
//    }
//
//    public void setElementos(List<String> elementos) {
//        this.listaElementos = elementos;
//    }

    public void mostrarElentosSimilares(String texto) {
        if (((JTextField) componenteLlamador).getText().length() == 0) {
            cajaDeTextoEsVacía = true;
            removeAll();
            setVisible(false);
            return;
        }
        cajaDeTextoEsVacía = false;
        removeAll();
        setVisible(false);
        if (texto.length() == 0) {
            componenteLlamador.requestFocus();
        } else {
            for (int i = 0; i < ((AutoCompletar) componenteLlamador).getModelo().getListaElementos().size(); i++) {
                String elemento = ((AutoCompletar) componenteLlamador).getModelo().getElementoString(i);
                if (verificaPatron(texto, elemento)) {
                    JmenuItemDesplegable item = new JmenuItemDesplegable(elemento);
                    item.setIndexItem(i);
                    add(item);
                }
            }
            show(componenteLlamador, posX, posY);
            componenteLlamador.requestFocus();
        }
    }
    
    /**
     * verifica que el texto ingresado concuerde con el elemento seleccionado de
     * la lista
     *
     * @param elemento
     * @return
     */
    private boolean verificaPatron(String textoBuscado,String elemento) {

        boolean cumplePatron = false;

        for (String string : elemento.split(" ")) {
            cumplePatron = Pattern.matches(textoBuscado.toUpperCase() + ".*", string.toUpperCase());
            if (cumplePatron) {
                break;
            }
        }

        return cumplePatron;
    }

    public void ocultar() {
        setVisible(false);
    }

    // clase interna privada para manejar eventos de elemento de menú
    /**
     * Esta clase item sirve para añadir items al menu desplegable y contrlar
     * eventos como por ejemplo cuando se cambia de un item a otro
     */
    private class JmenuItemDesplegable extends JMenuItem {

        private String nombreItem;
        private int indexItem;//permite identificar al elemento seleccionado

        public JmenuItemDesplegable(String text) {
            super(text);
            nombreItem = text;
            /**
             * evento disparado al cambiar de elemento de la lista
             */
            addChangeListener(new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent e) {
                    if (!cajaDeTextoEsVacía) {//si la caja esta vacía, quiere decir que se borró el texto que habia y no hay que setear nada
                        //System.out.println(e.getClass());
                        ((AutoCompletar) componenteLlamador).setTexto(nombreItem);
                        ((AutoCompletar) componenteLlamador).setSelectedItem(indexItem);
                        ((JTextField) componenteLlamador).setSelectionStart(0);
                        componenteLlamador.requestFocus();
                    }
                }
            });


        }

        public int getIndexItem() {
            return indexItem;
        }

        public void setIndexItem(int indexItem) {
            this.indexItem = indexItem;
        }
    } // fin de la clase interna privada ManejadorEventos
}
