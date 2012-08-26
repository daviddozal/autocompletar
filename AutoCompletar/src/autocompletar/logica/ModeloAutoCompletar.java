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
    
    /**
     * Devuelve un string, representa al elemento seleccionado, con este valor compara con los demas elementos
     * @param index
     * @return 
     */
    public abstract String getElementoString(int index);

    public abstract List getListaElementos();

    public abstract void setListaElementos(List listaElementos);
    
    public abstract void añadirElemento(Object elemento);
}
