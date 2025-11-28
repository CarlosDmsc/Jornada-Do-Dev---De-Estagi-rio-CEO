package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Carreira {

    private Desenvolvedor dev;
    private ArrayList<Projeto> projetos;

    private static HashMap<String, Integer> progresso = new HashMap<>();

    public Carreira(Desenvolvedor dev) {
        this.dev = dev;
        projetos = new ArrayList<>();
        gerarProjetosBase();
    }

    public static void registrarProgresso(String cargo, int dias) {
        progresso.put(cargo, dias);
    }

    public static void mostrarRelatorioFinal() {
        System.out.println("\nRelatorio final da carreira:");
        progresso.forEach((cargo, dia) -> {
            System.out.println(cargo + " alcançado em " + dia + " dias.");
        });
    }

    private void gerarProjetosBase() {
        projetos.add(new ProjetoWeb());
        projetos.add(new ProjetoMobile());
        projetos.add(new ProjetoIA());
    }

    public Projeto gerarProjetoAleatorio() {
        Random r = new Random();
        return projetos.get(r.nextInt(projetos.size()));
    }
}
