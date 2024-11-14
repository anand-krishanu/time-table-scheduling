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
            System.out.println("2. Add a Conflict (Edge)");
            System.out.println("3. Schedule Timetable");
            System.out.println("4. Display Timetable");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addSubject(scheduler, scanner);
                    break;
                case 2:
                    addConflict(scheduler, scanner);
                    break;
                case 3:
                    scheduler.scheduleTimeTable();
                    System.out.println("Timetable scheduled successfully.");
                    break;
                case 4:
                    displayTimetable(scheduler);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addSubject(Scheduler scheduler, Scanner scanner) {
        System.out.print("Enter subject name: ");
        String subject = scanner.nextLine();
        System.out.print("Enter class type (Lecture/Lab/Tutorial): ");
        String type = scanner.nextLine();
        scheduler.createNode(subject, type);
        System.out.println("Subject added: " + subject + " - " + type);
    }

    private static void addConflict(Scheduler scheduler, Scanner scanner) {
        System.out.print("Enter first subject name: ");
        String subject1 = scanner.nextLine();
        System.out.print("Enter first class type (Lecture/Lab/Tutorial): ");
        String type1 = scanner.nextLine();

        System.out.print("Enter second subject name: ");
        String subject2 = scanner.nextLine();
        System.out.print("Enter second class type (Lecture/Lab/Tutorial): ");
        String type2 = scanner.nextLine();

        scheduler.addConflict(subject1, type1, subject2, type2);
        System.out.println("Conflict added between " + subject1 + " " + type1 + " and " + subject2 + " " + type2);
    }

    private static void displayTimetable(Scheduler scheduler) {
        System.out.println("\n--- Scheduled Timetable ---");
        for (Node node : scheduler.getScheduledNodes()) {
            System.out.println("Subject: " + node.getSubject() + ", Type: " + node.getType() + ", Time Slot: " + node.getTimeSlot());
        }
    }
}
