
package springalapfogalmak.classes;

public class Lany {
    
    private Labda labda = new Labda();
    
    public Lany(){}
    
    public void jatszik(){
        labda.jatek(); 
    }

    public Labda getLabda() {
        return labda;
    }

    public void setLabda(Labda labda) {
        this.labda = labda;
    }
    
    
}
