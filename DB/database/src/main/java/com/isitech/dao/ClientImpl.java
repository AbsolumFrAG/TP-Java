package com.isitech.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.isitech.entities.Client;

import java.sql.Connection;

public class ClientImpl {
    DB database = new DB();

    public void InsererClient(Client client) throws Exception {
        try (Connection connection = database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(IClient.InsererClientQuery());) {
            preparedStatement.setString(1, client.getPrenom());
            preparedStatement.setString(2, client.getNom());
            preparedStatement.setString(3, client.getTel());

            int row = preparedStatement.executeUpdate();

            if (row > 0) {
                System.out.println("La requête a bien été exécutée");
            } else {
                System.out.println("Echec de l'insertion");
            }
        }
    }

    public void afficherClient() throws Exception {
        try (Connection connection = database.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultset = statement.executeQuery(IClient.afficherQuery());) {
            while (resultset.next()) {
                affichage(new Client(resultset.getInt("id"), resultset.getString("prenom"), resultset.getString("nom"),
                        resultset.getString("tel")));
            }
        }
    }

    public void affichage(Client client) {
        System.out.println("Id: " + client.getId() + "| Prénom : " + client.getPrenom() + " | Nom : " + client.getNom()
                + "| Téléphone : " + client.getTel());
    }

    public Boolean afficherClientById(int id) throws Exception {
        boolean isFound = false;
        try (Connection connection = database.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultset = statement.executeQuery(IClient.afficherQueryById(id))) {
            if (resultset.next()) {
                isFound = true;
                affichage(new Client(resultset.getInt("id"), resultset.getString("prenom"), resultset.getString("nom"),
                        resultset.getString("tel")));
            } else {
                System.out.println("L'identifiant que vous cherchez n'existe pas");
            }
        }
        return isFound;
    }

    public void supprimerClient(int id) throws Exception {
        try (Connection connection = database.getConnection();
                Statement statement = connection.createStatement();) {
            int rows = statement.executeUpdate(IClient.supprimer(id));
            if (rows > 0) {
                System.out.println("Client supprimé avec succès");
            } else {
                System.out.println("Echec de la suppression");
            }
        }
    }

    public void modifierClient(Client client) throws Exception {
        try (Connection connection = database.getConnection();
                PreparedStatement prepared = connection.prepareStatement(IClient.updateClient(client.getId()));) {
            prepared.setString(1, client.getPrenom());
            prepared.setString(2, client.getNom());
            prepared.setString(3, client.getTel());

            int rows = prepared.executeUpdate();

            if (rows > 0) {
                System.out.println("La modification a bien été effectuée");
            } else {
                System.out.println("Echec de la modification");
            }
        }
    }
}
