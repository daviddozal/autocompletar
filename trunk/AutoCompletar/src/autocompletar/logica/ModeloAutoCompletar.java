/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocompletar.logica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class ModeloAutoCompletar {
    List<Object> listaElementos;
    
    public String getElemento(int index){
        return listaElementos.get(index).toString();
    }

    public List<Object> getListaElementos() {
        return listaElementos;
    }

    public void setListaElementos(List<Object> listaElementos) {
        this.listaElementos = listaElementos;
    }
    
    public void añadirElemento(Object elemento){
        if(listaElementos==null){
            listaElementos = new ArrayList<>();
        }
        listaElementos.add(elemento);
    }
}
