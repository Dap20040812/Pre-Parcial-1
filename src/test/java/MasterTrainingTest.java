
import entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class MasterTrainingTest {

    public static final int MAX_WEEKS = 53;
    public static final int MAX_SESSIONS = 7;
    public static final int MAX_RECORDS = 5;

    private Random random;

    @BeforeEach
    public void setup() {
        random = new Random();
    }

    @Test
    @DisplayName("GIVEN a plan where the cyclist average beats is bad WHEN check heart THEN a new plan should be created")
    public void shouldCreateAPlanWhenCheckHeart() {

        Plan plan1 = generatePlan(1, 0);
        Plan plan2 = generatePlan(2, -1);
        Plan plan3 = generatePlan(3, 1);

        MasterTraining masterTraining = new MasterTraining();
        masterTraining.addPlan(plan1);
        masterTraining.addPlan(plan2);
        masterTraining.addPlan(plan3);

        assertEquals(masterTraining.countPlans(), 3, "The default count of plans");

        Plan newPlan1 = masterTraining.checkHeart(2);
        Plan newPlan2 = masterTraining.checkHeart(3);
        assertNotNull(newPlan1, "The new plan was created.");
        assertNotNull(newPlan2, "The new plan was created.");
        assertEquals(masterTraining.countPlans(), 5, "The count of plans with the new ones");


    }

    @Test
    @DisplayName("GIVEN a plan where the cyclist average beats is ok WHEN check heart THEN no new plan should be created")
    public void shouldNotCreateAPlanWhenCheckHeart() {

        Plan plan1 = generatePlan(1, 0);
        Plan plan2 = generatePlan(2, -1);
        Plan plan3 = generatePlan(3, 1);

        MasterTraining masterTraining = new MasterTraining();
        masterTraining.addPlan(plan1);
        masterTraining.addPlan(plan2);
        masterTraining.addPlan(plan3);

        assertEquals(masterTraining.countPlans(), 3, "The default count of plans");

        Plan newPlan1 = masterTraining.checkHeart(plan1.getNumber());
        assertNull(newPlan1, "No plan was created.");

        assertEquals(masterTraining.countPlans(), 3, "The count of plans with the new ones");
    }

    /**
     * Generate a new plan with all data for Week, Session, Activity and Record for the given type of beats.
     *
     * @param number    the plan id
     * @param typeBeats -1 lower beats, 0 good beats, 1 higher beats.
     * @return A plan with the specified beats.
     */
    public Plan generatePlan(long number, int typeBeats) {
        Plan plan = new Plan(number);

        for (int i = 0; i < (int) (Math.random() * MAX_WEEKS + 1); i++) {

            Week week = new Week();
            for (int j = 0; j < (int) (Math.random() * MAX_SESSIONS + 1); j++) {

                Session session = new Session();
                if (true) {

                    Activity activity = new Activity();
                    for (int k = 0; k < (int) (Math.random() * MAX_RECORDS + 1); k++) {
                        int beats = typeBeats == 0 ? generateGoodBeats() : typeBeats > 0 ? generateUpperBeats() : generateLowerBeats();
                        activity.addRecord(new Record(beats));
                    }
                    session.assignActivity(activity);
                }

                week.registerSession(session);
                week.assingPlan(plan);
            }

            plan.addWeek(week);
        }
        return plan;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private int generateGoodBeats() {
        return getRandomNumber(Plan.MIN_BEATS, Plan.MAX_BEATS);
    }

    private int generateLowerBeats() {
        return getRandomNumber(0, Plan.MIN_BEATS);
    }

    private int generateUpperBeats() {
        return getRandomNumber(Plan.MAX_BEATS, Integer.MAX_VALUE);
    }

}
