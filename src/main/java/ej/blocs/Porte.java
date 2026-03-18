package ej.blocs;

import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ej.exceptions.IllegalBlocException;
import ej.exceptions.PorteVerrouilleException;
import lombok.Getter;

public class Porte extends Bloc {

  private static Logger logger = LogManager.getLogger(Porte.class);

  @Getter
  private boolean verrouillee;

  public Porte(final int largeur, final int longueur, final int hauteur, final boolean verrouillee)
      throws IllegalBlocException {
    super(largeur, longueur, hauteur);
    this.verrouillee = verrouillee;
    setCouleur(Couleur.BLEU);
  }

  public void verrouiller() throws PorteVerrouilleException {
    if (verrouillee) {
      logger.info("La porte ne peut pas être verrouillée car c'est déjàle cas");
      throw new PorteVerrouilleException();
    } else {
      verrouillee = true;
    }
  }

  public void forcerSerrure(Predicate<String> fonction) {
    String cleSecrete = "#secret123";
    if (verrouillee) {
      if (fonction.test(cleSecrete)) {
        verrouillee = false;
      }
    }
  }
}
