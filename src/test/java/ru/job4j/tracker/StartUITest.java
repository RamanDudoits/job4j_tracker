package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitProgram()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceItem(out),
                new ExitProgram()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteItem(out),
                new ExitProgram()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitProgram()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowAllItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item"));
        Input in = new StubInput(
                new String[]{"0", "1"});
        UserAction[] actions = {
                new ShowAllItem(out),
                new ExitProgram()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Show all items" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Show all items ===" + System.lineSeparator() +
                        tracker.findById(item.getId()) + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Show all items" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item"));
        Input in = new StubInput(
                new String[]{"0", "item", "1"});
        UserAction[] actions = {
                new FindItemByName(out),
                new ExitProgram()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find item by name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Find item by name ===" + System.lineSeparator() +
                        "This item: " +
                        tracker.findById(item.getId()) + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Find item by name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {
                new FindItemById(out),
                new ExitProgram()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find item by id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Find item by id ===" + System.lineSeparator() +
                        "This item: " +
                        tracker.findById(item.getId()) + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Find item by id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"7", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitProgram()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
        ));
    }
}