package by.petrovich.computer;

import by.petrovich.computer.model.Computer;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("John", "Smith", 55);
        User user = new User();
        user.setName("John");
        user.setSurName("Smith");
        user.setAge(20);
        user.setGender("male");
        user.getName();
        user.getSurName();
        user.increaseAge(5);
        System.out.println(user);

        Computer computer = new Computer("Intell4.8", "Hynix3200", "Seagate 7200 500gb");
        System.out.println(computer);
        computer.on();
        System.out.println(computer);

    }

}
