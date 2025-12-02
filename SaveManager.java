package models;

import java.io.*;

public class SaveManager {

    private static final String SAVE_FILE = "save.dat";

    public static void salvarJogo(Desenvolvedor dev) {
        try {
            FileOutputStream fos = new FileOutputStream(SAVE_FILE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(dev);

            oos.close();
            fos.close();

            System.out.println("Progresso salvo com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    public static Desenvolvedor carregarJogo() {
        try {
            FileInputStream fis = new FileInputStream(SAVE_FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Desenvolvedor dev = (Desenvolvedor) ois.readObject();

            ois.close();
            fis.close();

            return dev;

        } catch (Exception e) {
            return null; // nenhum save encontrado
        }
    }
}
