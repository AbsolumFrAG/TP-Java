package com.isitech;

import java.util.Scanner;

import com.isitech.dao.ClientImpl;
import com.isitech.entities.Client;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {
        boolean enAction = true;
        while (enAction) {
            ClientImpl implementation = new ClientImpl();
            Scanner s = new Scanner(System.in);

            System.out.println("1. Ajouter un client");
            System.out.println("2. Afficher tous les clients");
            System.out.println("3. Sélectionner un client par son ID");
            System.out.println("4. Supprimer un client");
            System.out.println("5. Modifier un client");
            System.out.println("6. Quitter");

            int choix = Integer.parseInt(s.nextLine());

            switch (choix) {
                case 1:
                    System.out.println("Entrer le Prénom, Nom & Téléphone du client");
                    implementation.InsererClient(new Client(s.nextLine(), s.nextLine(), s.nextLine()));
                    break;
                case 2:
                    implementation.afficherClient();
                    break;
                case 3:
                    System.out.println("Entrer l'identifiant du client que vous cherchez");
                    implementation.afficherClientById(s.nextInt());
                    break;
                case 4:
                    System.out.println("Entrer l'identifiant du client à supprimer");
                    implementation.supprimerClient(s.nextInt());
                    break;
                case 5:
                    System.out.println("Entrer l'identifiant du client à mettre à jour");
                    int updateId = Integer.parseInt(s.nextLine());

                    boolean isFound = implementation.afficherClientById(updateId);

                    if (isFound) {
                        System.out.println("Entrer Prénom, Nom, Téléphone du client");
                        Client clt = new Client(updateId, s.nextLine(), s.nextLine(), s.nextLine());
                        implementation.modifierClient(clt);
                    }
                    break;
                case 6:
                    System.out.println("Au revoir");
                    enAction = false;
                    break;
                default:
                    System.out.println("Choix non disponible");
                    break;
            }
            s.close();
        }
    }
}
