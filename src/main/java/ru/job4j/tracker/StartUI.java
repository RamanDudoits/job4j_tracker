package ru.job4j.tracker;


public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println(" Show all items");
        Item[] items = tracker.findAll();
        if(items.length > 0) {
            for (int i = 0; i < items.length; i++) {
                System.out.println(items[i]);
            }
        } else {
            System.out.println("Items not found");
        }
    }

    public static void replaceItem (Input input, Tracker tracker) {
        System.out.println("=== Replace item ====");
        int id = input.askInt("Enter id: ");
        String newName = input.askStr("Enter new item: ");
        Item newItem = new Item(newName);
        if(tracker.replace(id, newItem)) {
            System.out.println("Replace successfully completed");
        } else {
            System.out.println("Replace not produced");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Delete successfully completed");
        } else {
            System.out.println("Delete not produced");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by id ====");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if(item != null) {
            System.out.println(" This item: " + item);
        } else {
            System.out.println("Items not protected");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find item by name ====");
        String name = input.askStr("Enter name: ");
        Item[] item = tracker.findByName(name);
        for (int i = 0; i < item.length; i++) {
                System.out.println("This item: " + item[i]);
            }
        }


    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++){
            System.out.println(index + ". " + actions[index].name());
        }
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = { new CreateAction(), new ShowAllItem(),
                new ReplaceItem(), new DeleteItem(), new FindItemById(),
                new FindItemByName(), new ExitProgram()
        };
        new StartUI().init(input, tracker, actions);
    }
}