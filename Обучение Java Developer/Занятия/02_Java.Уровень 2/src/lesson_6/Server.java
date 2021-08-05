package lesson_6;

import java.net.*;
import java.io.*;

public class Server {

    private Socket socket = null;
    private DataInputStream in = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    public Server(int port) {

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Сервер запустился");
            System.out.println("Ожидаем клиента...");
            socket = server.accept();
            System.out.println("Клиент присоединился");

            new Thread(() -> {
                try {
                    in = new DataInputStream(socket.getInputStream());
                    String line = "";
                    while (!line.equals("/end")) {
                        try {
                            line = in.readUTF();
                            System.out.println(line);
                        } catch (IOException i) {
                            System.out.println(i);
                        }
                    }

                    in.close();
                    socket.close();
                    System.out.println("Соединение закрыто");

                } catch(IOException i) {
                    System.out.println(i);
                }
            }).start();

            new Thread(() -> {
                try {

                    input = new DataInputStream(System.in);
                    out = new DataOutputStream(socket.getOutputStream());

                    String line = "";

                    while (!line.equals("/end")) {
                        try {
                            line = input.readLine();
                            out.writeUTF(line);
                        } catch (IOException i) {
                            System.out.println(i);
                        }
                    }

                    input.close();
                    out.close();
                    socket.close();
                    System.out.println("Соединение закрыто");

                } catch (Exception e) {
                    System.out.println(e);
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[]) {
        Server server = new Server(5000);
    }

}
