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

public class Server {

    public static void main(String[] args) throws IOException {
        // Creazione del socket server sulla porta 5000
        DatagramSocket serverSocket = new DatagramSocket(5000);

        // Buffer per la ricezione dei dati
        byte[] buffer = new byte[256];

        // Ciclo di ricezione messaggi
        while (true) {
            // Ricezione datagramma
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
            serverSocket.receive(datagramPacket);

            // Estrazione del messaggio
            String messaggio = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println("Ricevuto messaggio: " + messaggio);

            // Invio di una risposta
            String risposta = "Messaggio ricevuto correttamente";
            byte[] rispostaBytes = risposta.getBytes();
            DatagramPacket rispostaPacket = new DatagramPacket(rispostaBytes, rispostaBytes.length,
                    datagramPacket.getAddress(), datagramPacket.getPort());
            serverSocket.send(rispostaPacket);
        }
    }
}

