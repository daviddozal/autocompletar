/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocompletar.logica;

import java.util.List;

/**
 *
 * @author diego
 */
public interface ModeloAutoCompletar {
    
    
    public abstract String getElementoString(int index);

    public abstract List getListaElementos();

    public abstract void setListaElementos(List listaElementos);
    
    public abstract void añadirElemento(Object elemento);
}
