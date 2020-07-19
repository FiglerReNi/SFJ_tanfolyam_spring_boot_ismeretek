/*Ha ezzel a módszerrel programozzuk le a lányt és a labdát, akkor minden esetben el fog készülni
a labda, akkor is ha adott esetben nincs is szükség rá. A labda ugyan külön objektum, de ha azt akarjuk,
hogy tudjuk itt hasznáni beleírjuk ebbe az objektumba.
Hiba ezzel: Meghívjuk az objektumot, majd miután nem hasznájuk átkerül a carbage collectorba, ha megint szükség lesz egy ilyen
objektumra, újra meghívjuk és a labdából is új készül, pedig a régi is jó lenne, ha tudnánk használni valahogyan.
Megoldás: Van egy úgynevezett container, ami képes tárolni a labdánkat és ő adja át a lány objektumnak, ha szükség van rá.
Így csak annyi jön létre amennyi tényleg kell. Ha megszűnik a lány objektum a labda a containerben marad és következő alkalommal
innen kerül az új lány objektumhoz. Így sokkal kevesebb objektumot kell létrehozni, kevesebb helyet foglal a heapben.
A container tud azokról az objetumokról amiket figyelnie kell és amikről ő gondoskodik. Így tudjuk azt is figyelni és szabályozni
meddig éljen egy objektum. Pl. megadhatjuk hogy minden nap legyen belőle új létrehozva.
Ez a folyamat az inversion of control lényege.*/
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
