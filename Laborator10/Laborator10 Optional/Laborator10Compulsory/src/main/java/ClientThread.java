import Management.BuildGraph;
import Management.EntityManagement;
import Models.*;
import Repositories.UserRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

class ClientThread extends Thread {
    private Socket socket = null;
    private ServerSocket serverSocket = null;
    private UserRepository userRepository = new UserRepository();
    private Login loginCommand = new Login();
    private Register registerCommand = new Register();
    private Friendship friendship = new Friendship();
    private SendMessage sendMessage = new SendMessage();
    private ReadMessage readMessage = new ReadMessage();
    private String loggedInUser = null;
    private final BuildGraph buildGraph = new BuildGraph();

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
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                // Get the request from the input stream: client → server
                socket.setSoTimeout(120000);//2 minutes
//                LocalTime before = LocalTime.now();
                String request = "";
                BufferedReader in = null;
                try {
                     in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    request = in.readLine();
                }
                catch (SocketTimeoutException e)
                {
                    System.out.println("client " + this.getName() + " took to long to type a command so it has been disconnected");
                    raspuns = "you took to long to type a command so you have been disconnected";
                    out.println(raspuns);
                    out.flush();
                    out.close();
                    in.close();
                    socket.close();
                    break;
                }
//                LocalTime after = LocalTime.now();
//                if (before.until(after, ChronoUnit.SECONDS) > 10) {
//                    System.out.println("client " + this.getName() + " took to long to type a command so it has been disconnected");
//                    raspuns = "you took to long to type a command so you have been disconnected";
//                    out.println(raspuns);
//                    out.flush();
//                    in.close();
//                    out.close();
//                    socket.close();
//                    break;
//                } else
                    if (request == null) {
                    System.out.println("client " + this.getName() + " disconnected");
                    socket.close();
                    break;
                } else {
                    // Send the response to the oputput stream: server → client

                    if (request.equalsIgnoreCase("stop")) {
                        raspuns = "Server stopped";
                        out.println(raspuns);
                        out.flush();
                        in.close();
                        out.close();
                        socket.close();
                        System.exit(0);
                        serverSocket.close();
                        entityManager.close();
                        EntityManagement.closeEntityManagerFactory();
                        serverSocket.close();
                        break;
                    } else if (request.contains("register")) {
                        raspuns = registerCommand.register(request.substring(9));
                    } else if (request.contains("login")) {
                        raspuns = loginCommand.login(request.substring(6));
                        loggedInUser = request.substring(6);
                    } else if (request.contains("friend")) {
                        List<String> friends = new ArrayList<>();
                        int namePosition = 7;
                        if (request.substring(namePosition).contains(",")) {
                            while (request.substring(namePosition).contains(",")) {
//                                System.out.println(request.substring(namePosition, request.indexOf(",")));
                                friends.add(request.substring(namePosition, request.substring(namePosition).indexOf(",") + namePosition));
                                namePosition = request.indexOf(",") + 2;
                            }
//                            System.out.println(request.substring(namePosition));
                            friends.add(request.substring(namePosition));
                        } else friends.add(request.substring(namePosition));

                        raspuns = friendship.addFriends(friends, loggedInUser);
                        Graph<String, DefaultEdge> stringGraph = buildGraph.createStringGraph();
                        System.out.println(stringGraph);
//                        entityManager.getTransaction().commit();
                    } else if (request.contains("send")) {
                        raspuns = sendMessage.sendMessage(loggedInUser, request.substring(5));
//                        entityManager.getTransaction().commit();
                    } else if (request.equalsIgnoreCase("read")) {
                        raspuns = readMessage.readMessage(loggedInUser);
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


}