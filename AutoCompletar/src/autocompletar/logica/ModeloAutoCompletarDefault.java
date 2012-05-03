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
        
        listaElementos.add("Andorra");
        listaElementos.add("Nacionalidad Argentina");
        listaElementos.add("Australia");
        listaElementos.add("Rumania");
        listaElementos.add("Noruega");
        listaElementos.add("Italia");
        listaElementos.add("Croacia");
        listaElementos.add("Hungria");
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
