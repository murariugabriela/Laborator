import Management.EntityManagement;
import Models.User;
import Repositories.UserRepository;
import org.json.JSONArray;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ClientThread extends Thread {
    private Socket socket = null;
    private ServerSocket serverSocket = null;
    private UserRepository userRepository = new UserRepository();

    public ClientThread(Socket socket, ServerSocket serverSocket) {
        this.socket = socket;
        this.serverSocket = serverSocket;
    }

    public void run() {
        EntityManagement management = EntityManagement.getManagement();
        EntityManager entityManager = management.getEntityManager();

        while (true) {
            try {
                if (!socket.getInetAddress().isReachable(100)) {
                    System.out.println("client " + this.getName() + " stopped the server");
                    break;
                }
                String raspuns;
                // Get the request from the input stream: client → server
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                if (request == null) {
                    System.out.println("client " + this.getName() + " disconnected");
                    socket.close();

                    break;
                } else {
                    // Send the response to the oputput stream: server → client
                    PrintWriter out = new PrintWriter(socket.getOutputStream());
                    if (request.equalsIgnoreCase("stop")) {
                        raspuns = "Server stopped";
                        out.println(raspuns);
                        out.flush();
                        in.close();
                        out.close();
                        socket.close();
                        System.exit(0);
                        serverSocket.close();
                        entityManager.getTransaction().commit();
                        entityManager.close();
                        EntityManagement.closeEntityManagerFactory();
//                        serverSocket.close();
//                        break;
                    } else if (request.contains("register")) {
                        raspuns = register(request.substring(9));
                    } else if (request.contains("login")) {
                        raspuns = login(request.substring(6));
                    } else
                        raspuns = "Server received the request:\t" + request;
                    out.println(raspuns);
                    out.flush();
                }
            } catch (IOException e) {
                System.err.println("Communication error... " + e);
                break;
            }
        }
    }

    private String login(String client) {
        if (userRepository.findByName(client) == null) {
            return "Username " +
                    client +
                    "does not exist in the database: login failed";
        } else
            return client + ": " + "successfully logged in";
    }

    private String register(String client) {
        if (userRepository.findByName(client) == null) {
            User user = new User();
            user.setName(client);
            user.setFriends(new JSONArray().toString());
            userRepository.create(user);
            return "User " +
                    client +
                    " registered with success";
        } else
            return "User " +
                    client +
                    " already exists in the database. Please choose another username";
    }

}