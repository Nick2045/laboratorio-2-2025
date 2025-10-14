package ar.edu.unlu.poo.labo2.estrategias;

import ar.edu.unlu.poo.labo2.artefactos.Artefacto;

public class EscribaArcano implements EstrategiaDeMejora {

    public EscribaArcano() {
    }

    @Override
    public void mejorar(Artefacto artefacto) {
        if(artefacto.getTipo().equals("Pergamino")){
            int poderActual = artefacto.getNivelDePoder();
            if (poderActual < 30){
                artefacto.setPoder(poderActual+25);
            } else {
                artefacto.setPoder(poderActual-10);
            }
        }
    }
}
