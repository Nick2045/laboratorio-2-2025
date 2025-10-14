package ar.edu.unlu.poo.labo2.artefactos;

import ar.edu.unlu.poo.labo2.estrategias.EstrategiaDeMejora;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CatalogoArtefactos {

    Set<Artefacto> artefactos;
    private EstrategiaDeMejora estrategia;

    public CatalogoArtefactos(){

    }

    public CatalogoArtefactos(EstrategiaDeMejora estrategiaDeMejora) {
        this.artefactos = new HashSet<>();
        this.estrategia = estrategiaDeMejora;
    }

    void aplicarMejoras(){
        for(Artefacto a: artefactos){
           estrategia.mejorar(a);
        }
    }

    public void agregarArtefacto(Artefacto item){
        artefactos.add(item);
    }

    public Set<Artefacto> obtenerArtefactosUnicos() {
        return artefactos;
    }

    public List buscarArtefactosPorTipo(String tipo){
        List<Artefacto> lista = new ArrayList<>();
        for (Artefacto item : artefactos){
            if (item.getTipo().equalsIgnoreCase(tipo)){
                lista.add(item);
            }
        }

        int i, j, longitud = lista.size();
        Artefacto aux;
        for (i = 0; i < longitud-1; i++){
            for  (j = i+1; j < longitud; j++) {
                if(lista.get(i).getNivelDePoder()< lista.get(j).getNivelDePoder()) {
                    aux = lista.get(i); //Para hacer este de mejor manera puedo usar sort(), collections() o API de Streams.
                    lista.set(i,lista.get(j));
                    lista.set(j, aux);
                }
            }

        }

        return lista;
    }

    public Map<String, Integer> contarArtefactosPorTipo(){
        Map <String, Integer> tabla = new HashMap<>();
        for(Artefacto item : artefactos){
            Integer valor = tabla.putIfAbsent(item.getTipo(),1);
            if (valor != null){
                Integer nuevoValor = tabla.get(item.getTipo());
                tabla.put(item.getTipo(), nuevoValor+1);//Para hacer esto de mejor manera usar el merge() o el computer()
            }
        }
        return tabla;
    }

    public Artefacto obtenerArtefactoMasPoderoso(){
        if (artefactos.isEmpty()){
            return null;
        }

        Artefacto artefacto = null;
        int max = -1;
        for(Artefacto item : artefactos){
            if (item.getNivelDePoder() > max){
                artefacto = item;
                max = item.getNivelDePoder();
            }
        }
        /*
        Artefacto artefactoMasPoderoso = artefactos.get(0);

        for (int i = 1; i < artefactos.size(); i++) {
            Artefacto artefactoActual = artefactos.get(i);
            if (artefactoActual.getPoder() > artefactoMasPoderoso.getPoder()) {
                artefactoMasPoderoso = artefactoActual;
            }
        }
        return artefactoMasPoderoso;
        * */

        return artefacto;
    }
}
