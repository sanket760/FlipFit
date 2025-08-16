public class SlotDefinition {
    Integer id;
    String startTime;     // hhMM
    String workoutType;
    Integer numberOfSeats;

    public SlotDefinition(String startTime, String workoutType, Integer numberOfSeats){
        this.startTime = startTime;
        this.workoutType = workoutType;
        this.numberOfSeats = numberOfSeats;
    }
}
