import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    public static int PORT = 8080;
    public static String HOST = "localhost";

    public static void main(String[] args) throws IOException, InterruptedException {
        Log.PREFIX = "C";
        Log.log("Starting");
        Log.log("Client port opening " + PORT);
        Socket ckientSocket = new Socket(HOST, PORT);
        Log.log("Client port opened " + PORT);
        //Thread.sleep(1000000);

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

        bw.write("<html><body>Congratulations</body></html>");
        bw.newLine();
        bw.write("<html><body>Congratulations</body></html>");
        bw.newLine();
        bw.write("<html><body>Congratulations</body></html>");
        bw.newLine();
        bw.write("<html><body>Congratulations</body></html>");
        bw.newLine();
        bw.flush();

        String line = br.readLine();
        Log.log(line);



        Log.log("Client port closing" + PORT);
        ckientSocket.close();
        Log.log("Client port closed" + PORT);


        Log.log("Finalizing");
    }
}