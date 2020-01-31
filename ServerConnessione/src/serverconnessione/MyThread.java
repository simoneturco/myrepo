/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverconnessione;

/**
 *
 * @author simon
 */
public class MyThread extends Thread{
//fare estenzione della classe thread su serverconnessione così risco a gestire bene i thread una volta connesso con un client    
    @Override
    public void run()
    {
        try
        {
            while(true)
            {
                for(int i=10; i>0; i--)
                {
                    System.out.println(getName()+": "+i);
                    sleep(1000);
                }
                System.out.println("Timeout: in");
                sleep(60000);
            }
        }
        catch(InterruptedException ex)
        {
            System.out.println("Errore: "+ex);
            System.exit(0);
        }
    }
}
