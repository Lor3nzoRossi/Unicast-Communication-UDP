/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lorir
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

    public static void main(String[] args) throws IOException {
        // Creazione del socket client
        DatagramSocket clientSocket = new DatagramSocket();

        // Indirizzo IP del server
        InetAddress serverAddress = InetAddress.getByName("localhost");

        // Messaggio da inviare
        String messaggio = "Ciao server!";
        byte[] messaggioBytes = messaggio.getBytes();

        // Creazione del datagramma
        DatagramPacket datagramPacket = new DatagramPacket(messaggioBytes, messaggioBytes.length, serverAddress, 5000);

        // Invio del datagramma
        clientSocket.send(datagramPacket);

        // Ricezione della risposta
        byte[] buffer = new byte[256];
        DatagramPacket rispostaPacket = new DatagramPacket(buffer, buffer.length);
        clientSocket.receive(rispostaPacket);

        // Stampa della risposta
        String risposta = new String(rispostaPacket.getData(), 0, rispostaPacket.getLength());
        System.out.println("Risposta dal server: " + risposta);

        // Chiusura del socket
        clientSocket.close();
    }
}

