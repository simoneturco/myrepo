/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientconnessione;

import java.net.*;
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author simon
 */
public class ClientConnessione {
    public static void main(String[] args)
    {
        try
        {
            Socket connessione;
            String ip = "127.0.0.1";
            int porta = 3333;
            connessione = new Socket(ip, porta);
            System.out.println("Connessione aperta");
            InputStream leggi_server = connessione.getInputStream();
            InputStreamReader input = new InputStreamReader(leggi_server);
            //Scanner socketIn = new Scanner(connessione.getInputStream());
            //PrintWriter socketOut = new PrintWriter(connessione.getOutputStream());
            //Scanner stdin = new Scanner(System.in);
            BufferedReader in = new BufferedReader(input);
            String data = in.readLine();
            System.out.println("Data e ora del Server: "+data);
            in.close();
            connessione.close();
            System.out.append("Connessione chiusa");
            /*try {
                while(true) {
                    
                    String inputLine = stdin.nextLine();
                    socketOut.println("Data e ora del Server: "+inputLine);
                    socketOut.flush();
                    System.out.println("Data e ora del Server: "+inputLine);
                    String socketLine = socketIn.nextLine();
                    System.out.println(socketLine);
                    
                }   
            }catch(NoSuchElementException e)
            {
                System.out.println("Connessione chiusa");
            }*/
        }
        catch(IOException ex)
        {
            System.out.print("Errore :"+ ex);
            System.exit(0);
        }
        
    }
    
    
}
