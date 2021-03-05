package entities;

public class Session {

    private Activity activity;

    public void assignActivity(Activity activity) {
        this.activity = activity;
    }
    public double averageBeats(){
        double aab;

        if(this.activity == null)
        {
            aab=0;
        }
        else
        {
            aab = this.activity.averageBeats();
        }
        return aab;

    }
}
