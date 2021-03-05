package entities;

/**
 * Esta clase representa un registro del atleta
 *
 *  - beats, no puede ser nunca menor a 30;
 */

public class Record {

    private int beats;

    public Record(int beats) {
        this.beats = beats;
    }

    public int getBeats() {
        return beats;
    }
}
