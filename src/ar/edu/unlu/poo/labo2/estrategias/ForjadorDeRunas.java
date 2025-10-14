package ar.edu.unlu.poo.labo2.estrategias;

import ar.edu.unlu.poo.labo2.artefactos.Artefacto;

public class ForjadorDeRunas implements EstrategiaDeMejora {

    public ForjadorDeRunas() {

    }

    @Override
    public void mejorar(Artefacto artefacto) {
        if(artefacto.getTipo().equals("Varita")){
            int poderActual = artefacto.getNivelDePoder();
            artefacto.setPoder(poderActual+15);
        }
    }
}
