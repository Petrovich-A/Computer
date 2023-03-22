package by.petrovich.computer.model;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Computer {
    private static final int UPPERBOUND = 2;
    private String CPU;
    private String DDR;
    private String HDD;
    private int counterWorkCycle;
    private boolean isOn;
    private boolean isBurnedDown;

    public Computer() {
    }

    public Computer(String CPU, String DDR, String HDD) {
        this.CPU = CPU;
        this.DDR = DDR;
        this.HDD = HDD;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getDDR() {
        return DDR;
    }

    public void setDDR(String DDR) {
        this.DDR = DDR;
    }

    public String getHDD() {
        return HDD;
    }

    public void setHDD(String HDD) {
        this.HDD = HDD;
    }

    public int getCounterWorkCycle() {
        return counterWorkCycle;
    }

    public void setCounterWorkCycle(int counterWorkCycle) {
        this.counterWorkCycle = counterWorkCycle;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public boolean isBurnedDown() {
        return isBurnedDown;
    }

    public void setBurnedDown(boolean burnedDown) {
        isBurnedDown = burnedDown;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return counterWorkCycle == computer.counterWorkCycle && Objects.equals(CPU, computer.CPU) && Objects.equals(DDR, computer.DDR) && Objects.equals(HDD, computer.HDD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CPU, DDR, HDD, counterWorkCycle);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Computer{");
        sb.append("CPU='").append(CPU).append('\'');
        sb.append(", DDR='").append(DDR).append('\'');
        sb.append(", HDD='").append(HDD).append('\'');
        sb.append(", workCycle=").append(counterWorkCycle);
        sb.append('}');
        return sb.toString();
    }

    public void on() {
        if (!checkIsBurnedDown()) {
            System.out.println("Внимание! Введите 0 или 1:");
            int input = getInput();
            if (input == generateRandomNumber()) {
                off();
            } else {
                isBurnedDown = true;
            }
            counterWorkCycle++;
        }
    }

    private int getInput() {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        try {
            do {
                System.out.println("Неверный ввод! Введите 0 или 1:");
                input = Integer.parseInt(scanner.nextLine());
            } while (input > 1);
        } catch (NumberFormatException e) {
            System.out.println("Введено неверное число:" + e);
        }
        return input;
    }

    private boolean checkIsBurnedDown() {
        if (isBurnedDown) {
            System.out.println("Компьютер сгорел!");
        }
        return isBurnedDown;
    }

    public void off() {
        if (!isBurnedDown) {
            System.out.println("Выключение компьютера");
            this.counterWorkCycle--;
            isOn = false;
        }
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(UPPERBOUND);
    }
}
