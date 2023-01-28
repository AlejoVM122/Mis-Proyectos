import javax.swing.*;
import java.util.HashMap;
import java.util.Scanner;

public class Mafe {
    public static void main(String[] args) {

        HashMap <Integer,String> lista = new HashMap<>();

        lista.put(1,"mafe");
        lista.put(2,"steven");
        lista.put(3,"alejandro");
        lista.put(4,"tommy");
        lista.put(5,"bernarda");
        lista.put(6,"juanda");
        lista.put(7,"mami");


        int option= 3;

          JOptionPane jp = new JOptionPane("Digite la opcion que quiere ver ");


        System.out.println("Digite un numero");
         Scanner sc = new Scanner(System.in);
        option = sc;

        if (option == 2){
            lista.get(option);
        }else {
            System.out.println(" ANOTHER OPTION IS BETTER");
        }

    }
}
