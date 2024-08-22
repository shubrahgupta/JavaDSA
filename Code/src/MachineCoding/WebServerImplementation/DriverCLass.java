package MachineCoding.WebServerImplementation;
import java.io.*;
import java.util.*;
import java.net.*;


public class DriverCLass {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server up and running at port:" + port);
            while(true) {
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
                String request = in.readLine();
                if (request != null && request.startsWith("GET")) {
                    System.out.println(request);
                    out.println("HTTP/1.1 200 OK");
                    out.println("Content-Type: text/html; charset=UTF-8");
                    out.println("Connection: close");
                    out.println();

                    // Send HTTP response body
                    out.println("<html><body><h1>Welcome to Simple Web Server!</h1></body></html>");

                    System.out.println("Received on 8080: Status 200 OK");
                }
                else {
                    out.println("HTTP/1.1 405 Method Not Allowed");
                    out.println("Allow: GET");
                    out.println("Connection: close");
                    System.out.println("Received on 8080: Status 405");

                }

                clientSocket.close();
                in.close();
                out.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
