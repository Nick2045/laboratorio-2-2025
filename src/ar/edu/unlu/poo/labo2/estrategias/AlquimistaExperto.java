package ar.edu.unlu.poo.labo2.estrategias;

import ar.edu.unlu.poo.labo2.artefactos.Artefacto;

public class AlquimistaExperto implements EstrategiaDeMejora {

    public AlquimistaExperto() {

    }

    public void mejorar(Artefacto artefacto){
        if(artefacto.getTipo().equals("Poción")){
            int poderActual = artefacto.getNivelDePoder() + 20;
            if (poderActual > 100){
                artefacto.setPoder(100);
            } else {
                artefacto.setPoder(poderActual);
            }
        }
    }
}
