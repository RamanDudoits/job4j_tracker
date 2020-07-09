package ru.job4j.tracker;

public class FindItemByName implements UserAction {
    private final Output out;

    public FindItemByName(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by name ===");
        String name = input.askStr("Enter name: ");
        Item[] item = tracker.findByName(name);
            for (int i = 0; i < item.length; i++) {
                out.println("This item: " + item[i]);
            }
        return true;
    }
}
