package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MasterTraining {

    private List<Plan> plans;

    public MasterTraining() {
        this.plans = new ArrayList<>();
    }

    /**
     * Determina para un plan específico el rendimiento del corazón del ciclista.
     * Si el corazón presenta latidos irregulares, crea un nuevo plan de tipo “Heart Care” para dicho ciclista.
     * <p>
     * Si el promedio de beats es menor a 90 o mayor a 160, se considera un ritmo irregular.
     *
     * @param number El numero del plan a verificar
     * @return Plan: El nuevo plan creado en caso de necesitarlo, de lo contrario null.
     */
    public Plan checkHeart(long number) {
        Plan p =findPlan(number);
        Plan result = null;
        double pab= p.averageBeats();

        if(pab < Plan.MIN_BEATS || pab > Plan.MAX_BEATS){

            result= new Plan("Heart Care",p.getCyclist());
            addPlan(result);
        }
        return result;

    }

    /**
     * Encuetra el plan dado su id.
     * Si el plan no existe retono null
     * @param number
     * @return
     */
    private Plan findPlan(long number){
        Plan p = null;

        for(int i = 0 ; i < this.plans.size() && p == null;i++)
        {
            if(this.plans.get(i).getNumber() == number)
            {
                p=this.plans.get(i);
            }
        }

        return p;
    }

    public void addPlan(Plan plan) {
        this.plans.add(plan);
    }

    public int countPlans() {
        return this.plans.size();
    }


}
