package entities;

import java.util.ArrayList;
import java.util.List;

public class Activity {

    private List<Record> records;

    public Activity() {
        this.records = new ArrayList<>();
    }

    public void addRecord(Record record) {
        this.records.add(record);
    }
    public double averageBeats(){
        double rab= 0;

        for (Record r: this.records)
        {
            if(r.getBeats() != 0)
            {
                rab += r.getBeats();
            }
        }

        return this.records.size() == 0 ? 0: rab/this.records.size();
    }
}
