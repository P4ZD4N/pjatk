import java.io.*;
import java.net.Socket;
import java.util.Base64;

public class Client {

    public static int PORT = 8080;

    public static String HOST = "localhost";
    public static String USERNAME = "admin";
    public static String PASSWORD = "admin123";
    public static String CREDS = USERNAME + ":" + PASSWORD;
    public static String ENCODED_CREDS = Base64.getEncoder().encodeToString(CREDS.getBytes());

    public static void main(String[] args) throws IOException, InterruptedException {

        Log.PREFIX = "C";

        Log.log("Starting");
        Log.log("Client port opening " + PORT);

        Socket clientSocket = new Socket(HOST, PORT);

        Log.log("Client port opened " + PORT);

        Log.log("Streams collecting");
        InputStream inStream = clientSocket.getInputStream();
        OutputStream outStream = clientSocket.getOutputStream();
        InputStreamReader isr = new InputStreamReader(inStream);
        OutputStreamWriter osw = new OutputStreamWriter(outStream);
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(osw);
        Log.log("Streams collected");
        Log.log("Application logic");

        bw.write("GET / HTTP/1.1\r\n");
        bw.write("Host: " + HOST + "\r\n");
        bw.write("Authorization: Basic " + ENCODED_CREDS + "\r\n");
        bw.write("\r\n");
        bw.flush();

        String line;
        while ((line = br.readLine()) != null) {
            Log.log(line);
        }

        Log.log("Client port closing " + PORT);
        clientSocket.close();
        Log.log("Client port closed " + PORT);
        Log.log("Finalizing");
    }
}