import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static int PORT = 15000;
    public static String HOST = "172.21.40.125";

    public static void main(String[] args) throws IOException, InterruptedException {
        Log.PREFIX = "C";
        Log.log("Starting");
        Log.log("Client port opening " + PORT);
        Socket ckientSocket = new Socket(HOST, PORT);
        Log.log("Client port opened " + PORT);

        Log.log("Streams collecting");
        InputStream inStream = ckientSocket.getInputStream();
        OutputStream outStream = ckientSocket.getOutputStream();
        InputStreamReader isr = new InputStreamReader(inStream);
        OutputStreamWriter osw = new OutputStreamWriter(outStream);
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(osw);
        Log.log("Streams collected");
        Log.log("Application logic");

        // login

        bw.write("s30359 DYmeluPe7v\n");
        bw.flush();

        // task 1

        String line1 = br.readLine();
        String[] digits = line1.split(" ");

        String response1 = "";
        for (String digit : digits) response1 += digit;
        bw.write(response1 + "\n");
        bw.flush();

        Log.log(br.readLine());

        // task 2

        String line2;
        String response2 = "";
        for (int i = 0; i <= 3; i++) {
            line2 = br.readLine();
            response2 += line2;
        }

        bw.write(response2 + "\n");
        bw.flush();

        Log.log(br.readLine());

        // task 3

        String line3;
        String response3 = "";
        String[] responses = new String[4];
        for (int i = 1, j = 0; i <= 8; i++) {
            line3 = br.readLine();
            response3 += line3;

            if (i % 2 == 0) {
                responses[j] = response3;
                response3 = "";
                j++;
            }
        }

        bw.write(responses[0] + "\n");
        bw.write(responses[1] + "\n");
        bw.write(responses[2] + "\n");
        bw.write(responses[3] + "\n");
        bw.flush();

        Log.log(br.readLine());

        // task 4

        String kStr = br.readLine();
        int k = Integer.parseInt(kStr);

        String[] firstHalf = new String[k];
        String[] secondHalf = new String[k];

        for (int i = 0; i < k; i++) {
            firstHalf[i] = br.readLine();
        }

        for (int i = 0; i < k; i++) {
            secondHalf[i] = br.readLine();
            String response = firstHalf[i] + secondHalf[i];
            bw.write(response + "\n");
            bw.flush();
        }

        Log.log(br.readLine());

        // task 5

        String[] allNumbers = new String[100000];
        int numCount = 0;

        while (true) {
            String number = br.readLine();
            if (number == null) break;
            allNumbers[numCount++] = number;
        }

        int k5 = numCount / 2;

        String[] firstHalf5 = new String[k5];
        System.arraycopy(allNumbers, 0, firstHalf5, 0, k5);

        String[] secondHalf5 = new String[k5];
        System.arraycopy(allNumbers, k5, secondHalf5, 0, k5);

        for (int i = 0; i < k5; i++) {
            String response = firstHalf5[i] + secondHalf5[i];
            bw.write(response + "\n");
            bw.flush();
        }

        Log.log(br.readLine());

        //

        Log.log("Client port closing" + PORT);
        ckientSocket.close();
        Log.log("Client port closed" + PORT);

        Log.log("Finalizing");
    }
}