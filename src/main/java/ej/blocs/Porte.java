package ej.blocs;

import ej.exceptions.IllegalBlocException;
import ej.exceptions.PorteVerrouilleException;

public class Porte extends Bloc {

  private boolean verrouillee;

  public Porte(final int largeur, final int longueur, final int hauteur, final boolean verrouillee) throws IllegalBlocException {
    super(largeur, longueur, hauteur);
    this.verrouillee = verrouillee;
    setCouleur(Couleur.BLEU);
  }

  public boolean estVerrouillee() {
    return verrouillee;
  }

  public void verrouiller() throws PorteVerrouilleException {
    if (verrouillee) {
      throw new PorteVerrouilleException();
    } else {
      verrouillee = true;
    }
  }
}
