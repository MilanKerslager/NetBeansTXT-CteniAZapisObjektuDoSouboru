package zapisacteniobjektu;

import java.io.Serializable;

public class Clovek implements Serializable {
    private String jmeno;
    private int vek;

    public Clovek(String jmeno, int vek) {
        this.jmeno = jmeno;
        this.vek = vek;
    }
    
    public void predstavSe() {
        System.out.print("Jsem "+this.jmeno);
        System.out.println(" a je mi "+this.vek+" roků.");
    }
}
