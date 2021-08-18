package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class JavaDemo2 {

    public static void main(String[] args) throws IOException {

        int a;
        int b;

        Scanner input = new Scanner(System.in);

        a = Integer.parseInt(input.next());
        b = Integer.parseInt(input.next());

        int c;

        c=a+b;
        System.out.println("c="+c);
    }
}
