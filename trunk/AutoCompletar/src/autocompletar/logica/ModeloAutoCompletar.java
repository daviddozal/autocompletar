/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocompletar.logica;

import java.util.List;

/**
 *
 * @author Diego
 */
public class ModeloAutoCompletar {

    private List<ElementoAutoCompletar> elementos;

    public String getElementoString(int index) {
        return elementos.get(index).getNombreElemento();
    }

    public List getListaElementos() {
        return elementos;
    }

    public void setListaElementos(List listaElementos) {
        this.elementos = listaElementos;
    }

    public void añadirElemento(ElementoAutoCompletar elemento) {
        elementos.add(elemento);
    }
}
