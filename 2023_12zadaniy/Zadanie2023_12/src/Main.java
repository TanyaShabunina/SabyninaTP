public class Main {
    public static void main(String[] args) {
        Linker linker = new Linker();
        TrainingProgram items = new Items("Математика");
        TrainingProgram courses = new Courses("курс Русского языка");
        linker.addTrainingProgram(items);
        linker.addTrainingProgram(courses);
        linker.createTrainingProgram();
    }
}