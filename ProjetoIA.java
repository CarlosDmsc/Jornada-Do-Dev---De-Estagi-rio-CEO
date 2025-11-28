package models;

public class ProjetoIA extends Projeto {

    public ProjetoIA() {
        super("Projeto IA", 4, 100);
    }

    @Override
    public void concluirProjeto(Desenvolvedor dev) {
        dev.adicionarXP(recompensaXP);
        System.out.println("Projeto de Inteligencia Artificial concluido. +" + recompensaXP + " XP");
    }
}
