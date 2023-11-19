import java.util.ArrayList;
import java.util.List;

public class Linker {
    private List<TrainingProgram> trainingPrograms = new ArrayList<>();
    public void addTrainingProgram (TrainingProgram trainingProgram){
        trainingPrograms.add(trainingProgram);

    }
    public void createTrainingProgram (){
        System.out.println("TrainingProgram:");
        for (TrainingProgram tp: trainingPrograms){
            System.out.println(tp);
        }
    }
}
