/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverconnessione;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author simon
 */
public class ServerConnessione {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        int porta = 3333;
        
        
        try(ServerSocket sSocket = new ServerSocket(porta))
        {
            while(true)
            {
                Socket connessione;
                System.out.println("In attesa della connessione...");
                sSocket.setSoTimeout(60000);
                MyThread t = new MyThread();
                t.start();
                connessione = sSocket.accept();
                System.out.println("Connessione stabilita.");
                //Scanner in = new Scanner(connessione.getInputStream());
                OutputStream mess_client = connessione.getOutputStream();
                PrintWriter out = new PrintWriter(mess_client);
                
                Date data = new Date();
                String info = data.toString();
                out.println(info);
                
                /*while(true) {
                    
                    String line = in.nextLine();
                    if(line.equals("esci")) {
                        
                        break;
                        
                    } else {
                        
                        out.println("Messaggio ricevuto: "+ line);
                        out.flush();
                        
                    }
                    
                }*/
                
                System.out.println("Sto chiudendo il socket");
                
                out.close();
                connessione.close();
                //t.wait(60000);
                System.out.println("Connessione chiusa.");
            }
        }
        catch(SocketTimeoutException s)
        {
            System.out.print("Il server non è più disponibile");
            System.exit(0);
        }
        catch(SocketException ex)
        {
            System.out.println("Errore: "+ex);
            System.exit(0);
        }
        catch(IOException ex)
        {
            System.out.print("Errore :"+ ex);
            System.exit(0);
        }
        /*catch(InterruptedException ex)
        {
            System.out.println("Errore: "+ ex);
            System.exit(0);
        }*/

        
    }
    
}
