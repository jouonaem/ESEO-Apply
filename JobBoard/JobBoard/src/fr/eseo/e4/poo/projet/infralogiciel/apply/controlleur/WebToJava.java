package fr.eseo.e4.poo.projet.infralogiciel.apply.controlleur;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import javax.swing.JFrame;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import fr.eseo.e4.poo.projet.infralogiciel.apply.vue.SignInDialog;

public class WebToJava {
	public static void main(String[] args) throws IOException {
        // Créer un serveur HTTP
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Ajouter un gestionnaire pour le chemin /open-window
        server.createContext("/open-window", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                    // Ouvrir la fenêtre Java
                	openSignInDialog();

                    // Répondre à la requête
                    String response = "Fenêtre ouverte avec succès.";
                    exchange.sendResponseHeaders(200, response.getBytes().length);
                    OutputStream os = exchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                } else {
                    // Méthode non autorisée
                    exchange.sendResponseHeaders(405, -1); // 405 Method Not Allowed
                }
            }
        });

        // Démarrer le serveur
        server.start();
        System.out.println("Serveur démarré sur le port 8080...");
    }
	
	public static void openSignInDialog() {
      //Afficher la fenêtre SignInDialog
      		SignInDialog sgD = new SignInDialog();  
      		JFrame frame = new JFrame("Inscription");
      		frame.getContentPane().add(sgD);
      		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      		frame.setLocationRelativeTo(null);
      		frame.pack();
      		frame.setVisible(true);
    }
}
