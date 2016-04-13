package zapisacteniobjektu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ZapisACteniObjektu {

    public static void main(String[] args) {
        final String SOUBOR = "zaznam.ser";
        Clovek zaznam = new Clovek("René", 40);
        zaznam.predstavSe();
        // zápis objektu do souboru
        try {
            FileOutputStream fout = new FileOutputStream(SOUBOR);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(zaznam);
            out.close();
            fout.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ZapisACteniObjektu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ZapisACteniObjektu.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Dokončeno uložení objektu do souboru.");
        
        // načtení objektu do jiné proměnné
        Clovek novy = null;
        try {
            FileInputStream fin = new FileInputStream(SOUBOR);
            ObjectInputStream in = new ObjectInputStream(fin);
            novy = (Clovek) in.readObject();
            in.close();
            fin.close();
        } catch (FileNotFoundException ex) {
            System.err.println("CHYBA: Soubor s objektem nenalezen.");
            System.exit(1);
            //Logger.getLogger(ZapisACteniObjektu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ZapisACteniObjektu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ZapisACteniObjektu.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Nový objekt načten ze souboru.");
        // výpis objektu z jiné proměnné
        novy.predstavSe();
    } 
}
