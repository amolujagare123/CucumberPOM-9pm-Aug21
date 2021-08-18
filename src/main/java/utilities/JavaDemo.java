package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaDemo {

    public static void main(String[] args) throws IOException {

        int a;
        int b;

        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br =new BufferedReader(r);

        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());

        int c;

        c=a+b;
        System.out.println("c="+c);
    }
}
