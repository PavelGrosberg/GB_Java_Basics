package HomeWork.Laptop;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Filter {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();

        String[] colors = {"black", "white", "grey", "red"};
        int[] rams = {1, 2, 4, 8, 16, 32, 64};
        String[] cpus = {"i3", "i5", "i7", "i9", "Ryzen3", "Ryzen5", "Ryzen7", "Ryzen9"};
        int[] hdds = {1, 2, 3, 5, 10};
        String[] oss = {"Linux", "Windows", "Unix", "None"};
        String[] manufacturers = {"Toshiba", "Sony", "HP", "APPLE"};
        for (String manufacturer : manufacturers) {
            for (String color : colors) {
                for (int ram : rams) {
                    for (String cpu : cpus) {
                        for (int hdd : hdds) {
                            for (String os : oss) {
                                laptops.add(new Laptop(manufacturer, color, ram, hdd, os, cpu));
                            }
                        }
                    }
                }
            }
        }


        Scanner scanner = new Scanner(System.in);
        while (true) {
            Set<Laptop> results = findByManufacturers(laptops, scanner);
            results = findByColors(results, scanner);
            results = findByOs(results, scanner);
            results = findByCpu(results, scanner);
            results = findByRam(results, scanner);
            results = findByHdd(results, scanner);
            for (Laptop laptop : results) {
                System.out.println(laptop);
            }
            System.out.println("Повторить: y/n ?");
            String answer = scanner.nextLine();
            if (answer.equals("n")) {
                break;
            }
        }
        scanner.close();
    }

    public static Set<Laptop> findByManufacturers(Set<Laptop> laptops, Scanner scanner) {
        System.out.println("Введите производителя через запятую");
        Set<String> set = new HashSet<>();
        for (Laptop laptop : laptops) {
            set.add(laptop.model);
        }
        System.out.println("Доступные: " + String.join(", ", set));
        String line = scanner.nextLine();
        if (!line.equals("")) {
            String[] manufacturers = line.split(",");
            Set<Laptop> results = new HashSet<>();
            for (Laptop laptop : laptops) {
                if (laptop.equalsManufacturer(manufacturers)) {
                    results.add(laptop);
                }
            }
            return results;
        }
        return laptops;
    }

    public static Set<Laptop> findByColors(Set<Laptop> laptops, Scanner scanner) {
        System.out.println("Введите цвета через запятую");
        Set<String> set = new HashSet<>();
        for (Laptop laptop : laptops) {
            set.add(laptop.color);
        }
        System.out.println("Доступные: " + String.join(", ", set));
        String line = scanner.nextLine();
        if (!line.equals("")) {
            String[] colors = line.split(",");
            Set<Laptop> results = new HashSet<>();
            for (Laptop laptop : laptops) {
                if (laptop.equalsColor(colors)) {
                    results.add(laptop);
                }
            }
            return results;
        }
        return laptops;
    }

    public static Set<Laptop> findByOs(Set<Laptop> laptops, Scanner scanner) {
        System.out.println("Введите OS через запятую");
        Set<String> set = new HashSet<>();
        for (Laptop laptop : laptops) {
            set.add(laptop.OS);
        }
        System.out.println("Доступные: " + String.join(", ", set));
        String line = scanner.nextLine();
        if (!line.equals("")) {
            String[] oSystems = line.split(",");
            Set<Laptop> results = new HashSet<>();
            for (Laptop laptop : laptops) {
                if (laptop.equalsOs(oSystems)) {
                    results.add(laptop);
                }
            }
            return results;
        }
        return laptops;
    }

    public static Set<Laptop> findByCpu(Set<Laptop> laptops, Scanner scanner) {
        System.out.println("Введите CPU через запятую");
        Set<String> set = new HashSet<>();
        for (Laptop laptop : laptops) {
            set.add(laptop.cpu);
        }
        System.out.println("Доступные: " + String.join(", ", set));
        String line = scanner.nextLine();
        if (!line.equals("")) {
            String[] cpus = line.split(",");
            Set<Laptop> results = new HashSet<>();
            for (Laptop laptop : laptops) {
                if (laptop.equalsCpu(cpus)) {
                    results.add(laptop);
                }
            }
            return results;
        }
        return laptops;
    }

    public static Set<Laptop> findByRam(Set<Laptop> laptops, Scanner scanner) {
        System.out.println("Введите RAM минимальный, максимальный через запятую");
        Set<Integer> set = new TreeSet<>();
        for (Laptop laptop : laptops) {
            set.add(laptop.ram);
        }

        System.out.print("Доступные:");
        for (Integer ram : set) {
            System.out.print(" " + ram);
        }
        System.out.println(); // ""
        String line = scanner.nextLine();
        if (!line.equals("")) {
            String[] ram = line.split(",");
            Integer minRam = Integer.parseInt(ram[0]);
            Integer maxRam = 0;
            if (ram.length == 2) {
                maxRam = Integer.parseInt(ram[1]);
            }
            Set<Laptop> results = new HashSet<>();

            for (Laptop laptop : laptops) {
                if (laptop.equalsRam(minRam, maxRam)) {
                    results.add(laptop);
                }
            }
            return results;
        }
        return laptops;
    }

    public static Set<Laptop> findByHdd(Set<Laptop> laptops, Scanner scanner) {
        System.out.println("Введите HDD минимальный, максимальный через запятую");
        Set<Integer> set = new TreeSet<>();
        for (Laptop laptop : laptops) {
            set.add(laptop.hdd);
        }

        System.out.print("Доступные:");
        for (Integer hdd : set) {
            System.out.print(" " + hdd);
        }
        System.out.println(); // ""
        String line = scanner.nextLine();
        if (!line.equals("")) {
            String[] hdd = line.split(",");
            Integer minHdd = Integer.parseInt(hdd[0]);
            Integer maxHdd = 0;
            if (hdd.length == 2) {
                maxHdd = Integer.parseInt(hdd[1]);
            }
            Set<Laptop> results = new HashSet<>();

            for (Laptop laptop : laptops) {
                if (laptop.equalsHdd(minHdd, maxHdd)) {
                    results.add(laptop);
                }
            }
            return results;
        }
        return laptops;
    }
}
