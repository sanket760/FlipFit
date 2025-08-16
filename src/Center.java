import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Center {
    String centerName;
    String cityName;
    Integer numberOfSlots;
    List<String> workoutList;
    List<String> daysClosed;
    List<SlotDefinition> slotDefinitionList;
    HashMap<String, List<SlotInstance>> slotDetailsList;

    public Center(String centerName, String cityName, Integer numberOfSlots, List<String> daysClosed){
        this.centerName = centerName;
        this.cityName = cityName;
        this.numberOfSlots = numberOfSlots;
        this.daysClosed = daysClosed;
        this.workoutList = new ArrayList<>();
        this.slotDefinitionList = new ArrayList<>();
        this.slotDetailsList = new HashMap<>();
    }

    public void addWorkoutType(String workout){
        this.workoutList.add(workout);
    }

    public void addSlot(SlotDefinition slotDefinition){
        this.slotDefinitionList.add(slotDefinition);
    }
}
