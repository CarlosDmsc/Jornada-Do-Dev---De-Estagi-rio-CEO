package models;

public class Desafio {

    private String descricao;
    private int impactoXP;
    private int impactoCansaco;
    private int impactoDias;

    public Desafio(String descricao, int impactoXP, int impactoCansaco, int impactoDias) {
        this.descricao = descricao;
        this.impactoXP = impactoXP;
        this.impactoCansaco = impactoCansaco;
        this.impactoDias = impactoDias;
    }

    public void aplicarConsequencia(Desenvolvedor dev) {
        System.out.println("Um desafio ocorreu: " + descricao);
        
        dev.adicionarXP(-impactoXP);
        dev.forcarAumentoCansaco(impactoCansaco);
        dev.forcarAumentoDias(impactoDias);

        System.out.println("Perdeu " + impactoXP + " XP.");
        System.out.println("Ganhou " + impactoCansaco + " de cansaço.");
        System.out.println("Dias avançaram " + impactoDias + ".");
    }
}
