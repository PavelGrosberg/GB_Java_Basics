package HomeWork.Laptop;

public class Laptop {
    String model;
    String color;
    int ram;
    int hdd;
    String OS;
    String cpu;


    public Laptop(String model, String color, int ram, int hdd, String OS, String cpu) {
        this.model = model;
        this.color = color;
        this.ram = ram;
        this.hdd = hdd;
        this.OS = OS;
        this.cpu = cpu;
    }

    @Override
    public String toString() {
        return "Ноутбук: " + model + "   цвет: " + color + "   ОС: " + OS + "   RAM: " + ram + "Gb   HDD: " + hdd + "Tb" +
                "   CPU: " + cpu;
    }

    public boolean equalsManufacturer(String[] manufacturers) {
        for (String value : manufacturers) {
            if (value.equalsIgnoreCase(model)) {
                return true;
            }
        }
        return false;
    }

    public boolean equalsColor(String[] colors) {
        for (String value : colors) {
            if (value.equalsIgnoreCase(color)) {
                return true;
            }
        }
        return false;
    }

    public boolean equalsOs(String[] oSystems) {
        for (String value : oSystems) {
            if (value.equalsIgnoreCase(OS)) {
                return true;
            }
        }
        return false;
    }

    public boolean equalsCpu(String[] cpus) {
        for (String value : cpus) {
            if (value.equalsIgnoreCase(cpu)) {
                return true;
            }
        }
        return false;
    }

    public boolean equalsRam(Integer minRam, Integer maxRam) {
        if (maxRam == 0) {
            return (minRam <= ram);
        } else {
            return (minRam <= ram && maxRam >= ram);
        }
    }

    public boolean equalsHdd(Integer minHdd, Integer maxHdd) {
        if (maxHdd == 0) {
            return (minHdd <= hdd);
        } else {
            return (minHdd <= hdd && maxHdd >= hdd);
        }
    }

    public int hashCode() {
        return model.hashCode() ^ color.hashCode() ^ ram ^ hdd ^ OS.hashCode() ^ cpu.hashCode();
    }

    public boolean equals(Object obj) {
        Laptop laptop = (Laptop) obj;
        return model.equals(laptop.model)
                && color.equals(laptop.color)
                && ram == laptop.ram
                && hdd == laptop.hdd
                && OS.equals(laptop.OS)
                && cpu.equals(laptop.cpu);
    }
}

