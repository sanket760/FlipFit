import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        FlipFit app = new FlipFit();
        app.addCenter("bellandur","bangalore", List.of("monday","sunday"), 5);

        app.addWorkoutType("bellandur","weights");
        app.addWorkoutType("bellandur","cardio");
        app.addWorkoutType("bellandur","yoga");

        app.addSlot("bellandur","weights","6:00",2);
        app.addSlot("bellandur","Yoga","8:00",1);  //time in 24hr format

        app.registerUser("Vivek",16,"bangalore");
        app.registerUser("Pavan",20,"bangalore");
        app.registerUser("Varun",22,"bangalore");

        app.getAvailableSlot("bellandur","28-05-2021");

        app.BookSlot("bellandur","Vivek",1);
        app.viewUserBooking("Vivek","28-05-2021");

        app.cancelSlot("bellandur","Vivek",1);
        app.viewUserBooking("Vivek","28-05-2021");
    }
}