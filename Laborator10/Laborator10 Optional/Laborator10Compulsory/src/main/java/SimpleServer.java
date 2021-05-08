import Management.EntityManagement;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static final int PORT = 2729;

    public SimpleServer() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println("Waiting for a client ...");

                if (!serverSocket.isClosed()) {
//                    serverSocket.setSoTimeout(10000);
                    Socket socket = serverSocket.accept();
                    System.out.println("New client connected "
                            + socket.getInetAddress()
                            .getHostAddress());
                    // Execute the client's request in a new thread
                    new ClientThread(socket, serverSocket).start();
                }
                else {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            serverSocket.close();
        }

    }

    public static void main(String[] args) throws IOException {
        EntityManagement management = EntityManagement.getManagement();
        EntityManager entityManager = management.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM User").executeUpdate();
        SimpleServer server = new SimpleServer();
    }

}