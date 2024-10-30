import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static int PORT = 8080;

    public static void main(String[] args) throws IOException, InterruptedException {
        Log.PREFIX = "S";
        Log.log("Starting");
        Log.log("Server port opening " + PORT);
        ServerSocket serverSocket = new ServerSocket(PORT);
        Log.log("Server port opened " + PORT);
        //Thread.sleep(1000000);
        Log.log("Server listening and accepting incoming connections " + PORT);
        Socket ckientSocket = serverSocket.accept();
        Log.log("Client connected " + ckientSocket.getInetAddress().getHostAddress() + ":" + ckientSocket.getPort());
        //tcp : strumieniowa
        Log.log("Streams collecting");
        InputStream inStream = ckientSocket.getInputStream();
        OutputStream outStream = ckientSocket.getOutputStream();
        InputStreamReader isr = new InputStreamReader(inStream);
        OutputStreamWriter osw = new OutputStreamWriter(outStream);
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(osw);
        Log.log("Streams collected");
        Log.log("Application logic");

        String line = br.readLine();
        Log.log(line);
        line = br.readLine();
        Log.log(line);
        line = br.readLine();
        Log.log(line);
        line = br.readLine();
        Log.log(line);
        bw.write("<html><body>Congratulations</body></html>");
        bw.newLine();
        bw.flush();


        Log.log("Client port closing" + PORT);
        ckientSocket.close();
        Log.log("Client port closed" + PORT);

        Log.log("Server port closing" + PORT);
        serverSocket.close();
        Log.log("Server port closed" + PORT);
        Log.log("Finalizing");
    }
}