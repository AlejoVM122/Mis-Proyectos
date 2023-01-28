import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            InetAddress address = InetAddress.getLocalHost(); //getByName ()
            DatagramSocket datagramSocket =  new DatagramSocket();
            Scanner scanner = new Scanner(System.in);
            String echoString;

            do {
                System.out.println("Enter String to be echoed: ");
                echoString = scanner.nextLine();

                byte [] buffer = echoString.getBytes();

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length,address,5000);
                datagramSocket.send(packet);


                byte [] buffer2 = new byte[50];
                packet = new DatagramPacket(buffer2,buffer2.length);
                datagramSocket.receive(packet);
                System.out.println( "Text received is: "+ new String(buffer2,0, packet.getLength()));

            }while(!echoString.equals("exit"));

    }catch (SocketException e){
    System.out.println(e.getMessage());
    }catch (IOException e){
    System.err.println(e.getMessage());
    }

    }
}