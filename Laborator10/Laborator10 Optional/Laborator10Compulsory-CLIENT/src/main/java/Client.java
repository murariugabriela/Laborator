import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 2729; // The server's port
        Socket socket = new Socket(serverAddress, PORT);

        try (
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))) {
            // Send a request to the server
            while(true) {

                Scanner console;
                console = new Scanner(System.in);
                String request = console.nextLine();
                if (request.equalsIgnoreCase("exit")) {
                    System.out.println("Client stopped");
                    socket.close();
                    break;
                } else {
                    out.println(request);
                    String response;
                    try{
                    response = in.readLine();}
                    catch (SocketException e){
                        System.out.println("you took to long to type a command so you have been disconnected");
                        break;
                    }
                    System.out.println(response);
                    if (response.equalsIgnoreCase("Server stopped")) {
                        socket.close();
                        break;
                    } else if (response.equalsIgnoreCase("you took to long to type a command so you have been disconnected")) {
                        socket.close();
                        break;
                    }
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}