package ru.job4j.tracker;


public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
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
                int id = input.askInt("Enter id: ");
                String newName = input.askStr("Enter new item: ");
                Item newItem = new Item(newName);
                if(tracker.replace(id, newItem)) {
                    System.out.println("Replace successfully completed");
                } else {
                    System.out.println("Replace not produced");
                }
            } else if(select ==3) {
                System.out.println("=== Delete item ====");
                int id = input.askInt("Enter id: ");
                if (tracker.delete(id)) {
                    System.out.println("Delete successfully completed");
                } else {
                    System.out.println("Delete not produced");
                }
            } else if(select == 4) {
                System.out.println("=== Find item by id ====");
                int id = input.askInt("Enter id: ");
                Item item = tracker.findById(id);
                if(item != null) {
                    System.out.println(" This item: " + item);
                } else {
                    System.out.println("Items not protected");
                }
            }  else if(select == 5) {
                System.out.println("=== Find item by name ====");
                System.out.print("Enter name: ");
                String name = input.askStr("Enter name: ");
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}