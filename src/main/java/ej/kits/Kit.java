package ej.kits;

import java.util.LinkedHashSet;
import java.util.Set;

import ej.blocs.IBloc;
import ej.blocs.Mur;
import ej.blocs.Porte;
import ej.exceptions.IllegalBlocException;
import lombok.Getter;

public class Kit {

  @Getter private Set<IBloc> blocs = new LinkedHashSet<IBloc>();
  @Getter private Set<String> motCles = new LinkedHashSet<String>();

  public Kit() throws IllegalBlocException {
    blocs.add(new Mur(1, 1, 1, false));
    blocs.add(new Mur(3, 2, 2, true));
    blocs.add(new Mur(3, 2, 2, true));
    blocs.add(new Mur(2, 1, 2, false));
    blocs.add(new Mur(2, 1, 2, false));
    blocs.add(new Porte(1, 2, 2, true));

    motCles.add("Cabane");
    motCles.add("Muraille");
  }

  public void afficherKit() {
    System.out.println("Nombre de blocs dans le kit : " + blocs.size());
    System.out.println("Liste des mots clés du kit : ");
    motCles.forEach(System.out::println);
  }
}
