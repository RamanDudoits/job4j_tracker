package ru.job4j.tracker;

public class ReplaceItem implements UserAction {
    private  final Output out;

    public ReplaceItem(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Replace item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Replace item ====");
        int id = input.askInt("Enter id: ");
        String newName = input.askStr("Enter new name: ");
        Item item = new Item(newName);
        if(tracker.replace(id, item)) {
            out.println("Replace successfully completed");
        } else {
            out.println("Replace not produced");
        }
        return true;
    }
}
