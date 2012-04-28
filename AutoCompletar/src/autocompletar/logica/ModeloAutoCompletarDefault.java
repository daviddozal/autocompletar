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
public class ModeloAutoCompletarDefault implements ModeloAutoCompletar {

    private List<String> listaElementos;

    public ModeloAutoCompletarDefault() {
        listaElementos = new ArrayList<>();
        
        listaElementos.add("Nacionalidad Austria");
        listaElementos.add("Australia");
        listaElementos.add("Austriaca");
        listaElementos.add("Austriaco");
        listaElementos.add("Austriania");
        listaElementos.add("Nacionalidad Italy");
        listaElementos.add("Croatia");
        listaElementos.add("Hungary");
    }

    @Override
    public String getElementoString(int index) {
        return listaElementos.get(index);
    }

    @Override
    public List getListaElementos() {
        return listaElementos;
    }

    @Override
    public void setListaElementos(List listaElementos) {
        this.listaElementos= listaElementos;
    }

    @Override
    public void añadirElemento(Object elemento) {
        listaElementos.add(elemento.toString());
    }
}
