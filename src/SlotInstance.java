import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SlotInstance{
    Integer id;
    String date;   // yyyymmdd
    Integer numSeats;
    String centerName;
    List<User> userList;
    Queue<User> waitList;
    SlotDefinition slotDefinition;

    private static Integer slotCount = 0;

    public SlotInstance(String date, SlotDefinition slotDefinition, String centerName){
        this.date = date;
        this.id = ++slotCount;
        this.centerName = centerName;
        this.userList = new ArrayList<>();
        this.waitList = new ArrayDeque<>();
        this.slotDefinition = slotDefinition;
        this.numSeats = this.slotDefinition.numberOfSeats;
    }
}
