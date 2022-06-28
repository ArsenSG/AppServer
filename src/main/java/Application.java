import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Application {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8080;

        try (Socket clientsocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientsocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()))){
            out.println("GET / HTTP/1.1\n" + "Host: localhost\n\n\n");

            String resp = in.readLine();
            System.out.println(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

