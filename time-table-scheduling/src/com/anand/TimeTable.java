package com.anand;

import java.util.Scanner;

public class TimeTable {
    public static void main(String[] args) {

        Scheduler scheduler = new Scheduler();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Timetable Scheduling Menu ---");
            System.out.println("1. Add a Subject and Class Type");
            System.out.println("2. Schedule Timetable");
            System.out.println("3. Display Timetable");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addSubject(scheduler, scanner);
                    break;
                case 2:
                    scheduler.scheduleTimeTable();
                    System.out.println("Timetable scheduled successfully.");
                    break;
                case 3:
                    displayTimetable(scheduler);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void addSubject(Scheduler scheduler, Scanner scanner) {
        System.out.print("Enter subject name: ");
        String subject = scanner.nextLine();
        System.out.print("Enter class type (Lecture/Lab/Tutorial): ");
        String type = scanner.nextLine();

        // Ask for the day (1 for Monday, 5 for Friday)
        System.out.println("Enter day (1 for Monday, 2 for Tuesday, 3 for Wednesday, 4 for Thursday, 5 for Friday): ");
        int day = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        scheduler.createNode(subject, type, day);
        System.out.println("Subject added: " + subject + " - " + type + " on " + getDayName(day));
    }

    private static void displayTimetable(Scheduler scheduler) {
        // Create a 2D array (5 days, 13 slots (0-12))
        String[][] timetable = new String[5][13];

        // Initialize the timetable with empty strings
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 13; j++) {
                timetable[i][j] = "No Class"; // Default is no class
            }
        }

        // Fill the timetable with assigned classes
        for (Node node : scheduler.getScheduledNodes()) {
            int day = node.getDay() - 1; // Adjust day to 0-based index (1 = Monday, 5 = Friday)
            int slot = node.getTimeSlot();
            if (day >= 0 && day < 5 && slot >= 0 && slot <= 12) {
                timetable[day][slot] = node.getSubject() + " (" + node.getType() + ")";
            }
        }

        // Print the timetable
        System.out.println("\n--- Timetable ---");
        System.out.println("Day\t0\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11\t12");

        for (int i = 0; i < 5; i++) {
            System.out.print(getDayName(i + 1) + "\t");
            for (int j = 0; j < 13; j++) {
                System.out.print(timetable[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static String getDayName(int day) {
        return switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            default -> "Unknown Day";
        };
    }
}
