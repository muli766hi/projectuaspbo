/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project.View;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Buat server socket yang mendengarkan port tertentu (misalnya, port 5000)
            ServerSocket serverSocket = new ServerSocket(5000);
            
            System.out.println("Server listening on port 5000...");

            while (true) {
                // Terima koneksi dari client
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket);

                // Buat buffered reader untuk membaca data dari client
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // Buat print writer untuk mengirim data balik ke client
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                // Baca permintaan dari client
                String request = input.readLine();
                System.out.println("Request from client: " + request);

                // Proses permintaan dari client (di sini hanya menanggapi permintaan 'contactRequest')
                if ("contactRequest".equals(request)) {
                    // Kirim respons ke client
                    output.println("Hubungi admin +62 812-8329-9787 (Lia)");
                }

                // Tutup socket setelah selesai
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

