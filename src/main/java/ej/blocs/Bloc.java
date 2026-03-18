package ej.blocs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ej.exceptions.IllegalBlocException;
import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Bloc implements IBloc {
  private int largeur;
  private int longueur;
  private int hauteur;
  @Setter private Couleur couleur;

  private static Logger logger = LogManager.getLogger(Bloc.class);

  public Bloc(final int largeur, final int longueur, final int hauteur) throws IllegalBlocException {
    if (largeur < MIN_LARGEUR || longueur < MIN_LONGUEUR || hauteur < MIN_HAUTEUR) {
      throw new IllegalBlocException();
    }
    this.largeur = largeur;
    this.longueur = longueur;
    this.hauteur = hauteur;

logger.info("Un bloc de type " + this.getClass().getSimpleName() + " a été construit");
  }
}
