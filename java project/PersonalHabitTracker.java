import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a Habit
class Habit {
    private String name;
    private int streak;
    private int targetDays;

    public Habit(String name, int targetDays) {
        this.name = name;
        this.targetDays = targetDays;
        this.streak = 0;
    }

    public String getName() {
        return name;
    }

    public int getStreak() {
        return streak;
    }

    public int getTargetDays() {
        return targetDays;
    }

    public void markDone() {
        streak++;
        System.out.println("✔ Habit '" + name + "' updated! Current streak: " + streak);
    }

    public boolean isCompleted() {
        return streak >= targetDays;
    }
}

// Class for managing Habits
class HabitTracker {
    private ArrayList<Habit> habits = new ArrayList<>();

    public void addHabit(String name, int targetDays) {
        habits.add(new Habit(name, targetDays));
        System.out.println("🎯 Habit '" + name + "' added with target " + targetDays + " days!");
    }

    public void markHabitDone(String habitName) {
        for (Habit h : habits) {
            if (h.getName().equalsIgnoreCase(habitName)) {
                h.markDone();
                return;
            }
        }
        System.out.println("⚠ Habit not found.");
    }

    public void showHabits() {
        if (habits.isEmpty()) {
            System.out.println("No habits added yet!");
            return;
        }
        System.out.println("\n📌 Your Habits:");
        for (Habit h : habits) {
            System.out.println("- " + h.getName() + " | Streak: " + h.getStreak() + "/" + h.getTargetDays() + 
                               (h.isCompleted() ? " ✅ Completed!" : ""));
        }
    }
}

// Main class
public class PersonalHabitTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HabitTracker tracker = new HabitTracker();
        int choice;

        do {
            System.out.println("\n--- Personal Habit Tracker ---");
            System.out.println("1. Add Habit");
            System.out.println("2. Mark Habit as Done");
            System.out.println("3. Show Habits");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter habit name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter target days: ");
                    int days = sc.nextInt();
                    tracker.addHabit(name, days);
                    break;
                case 2:
                    System.out.print("Enter habit name to mark done: ");
                    String habitName = sc.nextLine();
                    tracker.markHabitDone(habitName);
                    break;
                case 3:
                    tracker.showHabits();
                    break;
                case 4:
                    System.out.println("👋 Exiting Habit Tracker. Stay consistent!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
