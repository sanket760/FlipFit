# FlipFit

FlipFit is a command-line application for booking workout slots at various fitness centers. It allows users to view available slots, book them, and manage their bookings.

## Execution Flow

The application starts from the `Main.java` file. Here's a breakdown of the execution flow:

1.  **Initialization**: A `FlipFit` object is created in the `main` method of the `Main` class.
2.  **Center and Workout Setup**:
    *   A new fitness center is added using the `addCenter` method.
    *   Different workout types (e.g., "weights", "cardio", "yoga") are added to the center using the `addWorkoutType` method.
    *   Time slots for these workouts are defined using the `addSlot` method, specifying the workout type, start time, and number of available seats.
3.  **User Registration**: Users are registered in the system using the `registerUser` method, providing their name, age, and city.
4.  **Viewing Available Slots**: The `getAvailableSlot` method is called to display the available workout slots for a given center and date.
5.  **Booking a Slot**: A user can book an available slot using the `BookSlot` method, which takes the center name, username, and slot ID as input.
6.  **Viewing Bookings**: Users can view their booked slots for a specific date using the `viewUserBooking` method.
7.  **Canceling a Slot**: A user can cancel a booked slot using the `cancelSlot` method. If there are users on the waitlist for that slot, the first user from the waitlist is automatically booked.

## File Descriptions

*   **`Main.java`**: The entry point of the application. It contains the `main` method that simulates the application's functionality.
*   **`FlipFit.java`**: The core class of the application. It manages all the data and operations, such as adding centers, users, and workouts, as well as handling slot bookings and cancellations.
*   **`Center.java`**: Represents a fitness center. It stores information about the center, including its name, city, the workouts it offers, and its slot definitions.
*   **`User.java`**: Represents a user of the application. It stores the user's name, age, and city.
*   **`SlotDefinition.java`**: Defines the template for a workout slot, including the start time, workout type, and the number of seats.
*   **`SlotInstance.java`**: Represents a specific instance of a slot on a given date. It keeps track of the users who have booked the slot and those on the waitlist.
