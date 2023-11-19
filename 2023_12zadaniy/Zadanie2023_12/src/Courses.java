public class Courses extends TrainingProgram{
    private String name;

    public Courses(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "name='" + name + '\'' +
                '}';
    }
}
