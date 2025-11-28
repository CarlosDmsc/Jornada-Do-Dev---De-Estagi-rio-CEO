package models;

public class Desafio {

    private String descricao;
    private int impactoXP;

    public Desafio(String descricao, int impactoXP) {
        this.descricao = descricao;
        this.impactoXP = impactoXP;
    }

    public void aplicarConsequencia(Desenvolvedor dev) {
        dev.adicionarXP(-impactoXP);
        System.out.println("⚠️ Desafio enfrentado: " + descricao + " | -" + impactoXP + " XP");
    }
}
