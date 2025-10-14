package ar.edu.unlu.poo.labo2.estrategias;

import ar.edu.unlu.poo.labo2.artefactos.Artefacto;

public class JoyeroElfico implements EstrategiaDeMejora {

    public JoyeroElfico() {

    }

    @Override
    public void mejorar(Artefacto artefacto) {
        if(artefacto.getTipo().equals("Amuleto")){
            int poderActual = artefacto.getNivelDePoder();
            if (poderActual < 50){
                artefacto.setPoder(poderActual*2);
            } else {
                artefacto.setPoder((int) (poderActual*1.25));
            }
        }
    }
}
