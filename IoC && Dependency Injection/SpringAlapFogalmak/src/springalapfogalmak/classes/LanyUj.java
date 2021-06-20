package springalapfogalmak.classes;

public class LanyUj {
    private Labda labda;
    
    //konstruktor alapú dependency injection
    /*public LanyUj(Labda labda){
        this.labda = labda;
    }*/
    public LanyUj(){}
    
    public void jatszik(){
        labda.jatek(); 
    }

    public Labda getLabda() {
        return this.labda;
    }
    
    //setter alapú dependency injection
    public void setLabda(Labda labda) {
        this.labda = labda;
    }
}
