import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;

public class Server {

    public static int PORT = 8080;

    public static String ADMIN_USERNAME = "admin";
    public static String ADMIN_PASSWORD = "admin123";

    public static void main(String[] args) throws IOException, InterruptedException {

        Log.PREFIX = "S";

        Log.log("Starting");
        Log.log("Server port opening " + PORT);

        ServerSocket serverSocket = new ServerSocket(PORT);

        Log.log("Server port opened " + PORT);
        Log.log("Server listening and accepting incoming connections " + PORT);

        Socket clientSocket = serverSocket.accept();
        Log.log("Client connected " + clientSocket.getInetAddress().getHostAddress() + ":" + clientSocket.getPort());

        InputStream inStream = clientSocket.getInputStream();
        InputStreamReader isr = new InputStreamReader(inStream);
        BufferedReader br = new BufferedReader(isr);
        OutputStream outStream = clientSocket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(outStream);
        BufferedWriter bw = new BufferedWriter(osw);

        Log.log("Application logic");

        String line;
        String authenticationHeader = null;
        while ((line = br.readLine()) != null) {
            Log.log(line);
            if (line.startsWith("Authorization: Basic")) authenticationHeader = line;
            if (line.isEmpty()) break;
        }

        if (authenticationHeader != null) {
            String base64Creds = authenticationHeader.substring("Authorization: Basic ".length()).trim();
            String decodedCreds = new String(Base64.getDecoder().decode(base64Creds));

            String [] userCreds = decodedCreds.split(":");
            String userUsername = userCreds[0];
            String userPassword = userCreds[1];

            if (ADMIN_USERNAME.equals(userUsername) && ADMIN_PASSWORD.equals(userPassword)) {
                Log.log("Authorized");
            } else {
                Log.log("Unauthorized");
                bw.write("HTTP/1.1 401 Unauthorized\r\n");
                bw.write("Content-Type: text/plain\r\n");
                bw.write("\r\n");
                bw.write("Unauthorized");
                bw.flush();
                clientSocket.close();
                return;
            }
        } else {
            Log.log("No authorization header found");
            bw.write("HTTP/1.1 401 Unauthorized\r\n");
            bw.write("Content-Type: text/plain\r\n");
            bw.write("\r\n");
            bw.write("Unauthorized");
            bw.flush();
            clientSocket.close();
            return;
        }

        bw.write("HTTP/1.1 200 OK\r\n");
        bw.write("Content-Type: text/html; charset=UTF-8\r\n");
        bw.write("\r\n");
        bw.write("<html><body>Congratulations</body></html>");
        bw.flush();

        Log.log("Client port closing " + PORT);
        clientSocket.close();
        Log.log("Client port closed " + PORT);

        Log.log("Server port closing " + PORT);
        serverSocket.close();
        Log.log("Server port closed " + PORT);
        Log.log("Finalizing");
    }
}