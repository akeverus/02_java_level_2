package lesson_6;


import java.net.*;
import java.io.*;

public class Client {

    private Socket socket = null;
    private DataInputStream in = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    public Client(String address, int port) {

        try {

            socket = new Socket(address, port);
            System.out.println("Клиент подсоединился");

            new Thread(() -> {

                try {
                    input = new DataInputStream(System.in);
                    out = new DataOutputStream(socket.getOutputStream());
                    String line = "";

                    while (!line.equals("/end")) {
                        try            {
                            line = input.readLine();
                            out.writeUTF(line);
                        }
                        catch(IOException i) {
                            System.out.println(i);
                        }
                    }

                    input.close();
                    out.close();
                    socket.close();
                    System.out.println("Соединение закрыто");

                } catch(IOException u) {
                    System.out.println(u);
                }
            }).start();

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
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client("127.0.0.1", 5000);
    }
}

