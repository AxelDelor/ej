package ej;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ej.blocs.IBloc;
import ej.blocs.Porte;
import ej.exceptions.IllegalBlocException;
import ej.kits.Kit;

public class Main {

  private static Logger logger = LogManager.getLogger(Main.class);

  public static void main(String[] args) throws IOException {
    logger.info("Lancement d'Epicrafter's Journey");
    try {
      Kit kitDeDemarrage = new Kit();
      System.out.println("Vous disposez d'un kit de démarrage");

      boolean continuer = true;
      while (continuer) {

        System.out.println(
            "Que souhaitez-vous afficher ?"
                + "\n 1 - Les idées de construction"
                + "\n 2 - Les différents blocs de chaque type et leur nombre"
                + "\n 3 - Essayer de forcer la serrure de la porte"
                + "\n 4 - Quitter");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String reponse = reader.readLine();
        if (reponse.equals("1")) {
          for (String construction : kitDeDemarrage.getMotCles()) {
            System.out.println(construction);
          }
        } else if (reponse.equals("2")) {
          Map<String, Integer> compteur = new HashMap<>();
          for (IBloc bloc : kitDeDemarrage.getBlocs()) {
            String type = bloc.getClass().getSimpleName();
            compteur.put(type, compteur.getOrDefault(type, 0) + 1);
          }
          for (Map.Entry<String, Integer> entry : compteur.entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());
        } else if (reponse.equals("3")) {
          System.out.println("Entrez le code");
          var porteTest = new Porte(1, 1, 1, true);
          String codeSaisi = reader.readLine();
          porteTest.forcerSerrure(cle -> cle.equals(codeSaisi));
          if (porteTest.isVerrouillee()) {
            System.out.println("Echec");
          } else {
            System.out.println("Bravo, vous avez déverrouillé la porte !");
          }
        } else if (reponse.equals("4")) {
          continuer = false;
        } else {
          System.out.println("Ce choix n'est pas reconnu, tapez 1 ou 2");
        }

      }
    } catch (IllegalBlocException e) {
      System.out.println("Impossible de construire le kit de démarrage");
    } catch (IOException e) {
      System.out.println("Impossible de récupérer la saisie de l'utilisateur");
    }
    logger.info("Arrêt d'Epicrafter's Journey");
  }
}
