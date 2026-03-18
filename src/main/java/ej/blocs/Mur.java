package ej.blocs;

import ej.exceptions.IllegalBlocException;

public class Mur extends Bloc {

  private boolean porteur;

  public Mur(final int largeur, final int longueur, final int hauteur, final boolean porteur)
      throws IllegalBlocException {
    super(largeur, longueur, hauteur);
    this.porteur = porteur;
    setCouleur(Couleur.GRIS);
  }

  public boolean estTraversable() {
    return !porteur;
  }
}
