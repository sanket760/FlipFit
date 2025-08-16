import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class FlipFit {
    List<User> users;
    List<Center> centers;
    HashMap<String, Center> centerNameMap;
    HashMap<String, User> userNameMap;
    HashMap<Integer, SlotInstance> slotIdMap;
    HashMap<String, HashMap<String, List<SlotInstance>>> userBookings;

    public FlipFit(){
        this.users = new ArrayList<>();
        this.centers = new ArrayList<>();
        this.userNameMap = new HashMap<>();
        this.centerNameMap = new HashMap<>();
        this.userBookings = new HashMap<>();
        this.slotIdMap = new HashMap<>();
    }

    private Center getCenterByName(String centerName){
        return centerNameMap.get(centerName);
    }

    private User getUserByName(String userName){
        return userNameMap.get(userName);
    }

    public void addCenter(String centerName, String cityName, List<String> daysClosed, Integer numSlots){
        Center center = new Center(centerName, cityName, numSlots, daysClosed);

        this.centers.add(center);
        this.centerNameMap.put(centerName, center);
    }

    public void addWorkoutType(String centerName, String workoutName){
        Center center = getCenterByName(centerName);
        center.addWorkoutType(workoutName);
    }

    public void addSlot(String centerName, String workoutType, String startTime, Integer numberOfSeats){
        Center center = getCenterByName(centerName);
        SlotDefinition slotDefinition = new SlotDefinition(startTime, workoutType, numberOfSeats);

        center.addSlot(slotDefinition);
    }

    public void registerUser(String userName, Integer age, String city){
        User user = new User(userName, age, city);
        users.add(user);
        userNameMap.put(userName, user);
        userBookings.put(userName, new HashMap<>());
    }

    private List<SlotInstance> createSlotInstance(String date, Center center, HashMap<Integer, SlotInstance> slotIdMap){
        List<SlotInstance> slotList = new ArrayList<>();
        for(SlotDefinition slotDefinition : center.slotDefinitionList){
            SlotInstance slotInstance = new SlotInstance(date, slotDefinition, center.centerName);

            slotList.add(slotInstance);
            slotIdMap.put(slotInstance.id, slotInstance);
        }

        center.slotDetailsList.put(date, slotList);
        return slotList;
    }

    public void getAvailableSlot(String centerName, String date){
        Center center = getCenterByName(centerName);

        List<SlotInstance> slots;
        if(center.slotDetailsList.get(date) == null) slots = createSlotInstance(date, center, slotIdMap);
        else slots = center.slotDetailsList.get(date);

        for(SlotInstance slot : slots){
            Integer slotId = slot.id;
            String workoutType = slot.slotDefinition.workoutType;
            String startTime = slot.slotDefinition.startTime;
            Integer seatsAvailable = slot.numSeats - slot.userList.size();

            System.out.printf("%d, %s, %s, %s, %d \n", slotId, centerName, workoutType, startTime, seatsAvailable);
        }
    }

    public void BookSlot(String centerName, String userName, Integer slotId){
        User user = getUserByName(userName);

        SlotInstance slot = slotIdMap.get(slotId);
        String date = slot.date;
        int seatsAvailable = slot.numSeats - slot.userList.size();

        if(seatsAvailable > 0) {
            slot.userList.add(user);

        }
        else slot.waitList.add(user);

        userBookings.get(userName).computeIfAbsent(date, k -> new ArrayList<>());
        userBookings.get(userName).get(date).add(slot);
    }

    public void viewUserBooking(String userName, String date){
        List<SlotInstance> userSlots = userBookings.get(userName).get(date);

        if(userSlots == null || userSlots.isEmpty())
            System.out.printf("No bookings for the user %s on date %s.", userName, date);
        else{
            for(SlotInstance slot : userSlots){
                Integer slotId = slot.id;
                String centerName = slot.centerName;
                String workoutType = slot.slotDefinition.workoutType;
                String startTime = slot.slotDefinition.startTime;

                System.out.printf("%d, %s, %s, %s \n", slotId, centerName, workoutType, startTime);
            }
        }
    }

    public void cancelSlot(String centerName, String userName, Integer slotId){
        User user = getUserByName(userName);

        SlotInstance slot = slotIdMap.get(slotId);
        String date = slot.date;

        userBookings.get(userName).get(date).remove(slot);
        slot.userList.remove(user);

        if(!slot.waitList.isEmpty()) {
            slot.userList.add(slot.waitList.peek());
            slot.waitList.remove();
        }
    }
}
