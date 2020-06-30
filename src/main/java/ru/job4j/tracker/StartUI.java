package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if(select == 1) {
                System.out.println(" Show all items");
                Item[] items = tracker.findAll();
                if(tracker.findAll().length > 0) {
                    for (int i = 0; i < tracker.findAll().length; i++) {
                        System.out.println(items[i]);
                    }
                } else {
                    System.out.println("Items not found");
                }
            } else if(select == 2) {
                System.out.println("=== Replace item ====");
                System.out.print("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.print("Enter new item: ");
                String newName = scanner.nextLine();
                Item newItem = new Item(newName);
                if(tracker.replace(id, newItem)) {
                    System.out.println("Replace successfully completed");
                } else {
                    System.out.println("Replace not produced");
                }
            } else if(select ==3) {
                System.out.println("=== Delete item ====");
                System.out.print("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Delete successfully completed");
                } else {
                    System.out.println("Delete not produced");
                }
            } else if(select == 4) {
                System.out.println("=== Find item by id ====");
                System.out.print("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                Item item = tracker.findById(id);
                if(item != null) {
                    System.out.println(" This item: " + item);
                } else {
                    System.out.println("Items not protected");
                }
            }  else if(select == 5) {
                System.out.println("=== Find item by name ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item[] item = tracker.findByName(name);
                if (item != null) {
                        System.out.println("This item: " + item);
                    }
                 else {
                    System.out.println("Items not protected");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}