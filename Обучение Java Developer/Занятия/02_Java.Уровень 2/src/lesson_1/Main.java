package lesson_1;

public class Main {
    public static void main(String[] args) {

        Being[] beings = {new Cat("Barsik",100,1),
                new Cat("Mursik",200,2),
                new Human("Jack", 2000, 3),
                new Human("John", 1500, 4),
                new Robot("HAL 9000",50000,50),
                new Robot("T-1000",40000,40)};

        Let[] lets = {new Treadmill(100), new Wall(1),
                new Treadmill(1000), new Wall(3),
                new Treadmill(10000), new Wall(10)};

        boolean isHappened;
        for (Being being : beings) {
            isHappened = true;
            for (Let let : lets) {
                if (let instanceof Treadmill && !being.run((Treadmill) let)) {
                    isHappened = false;
                    break;
                } else if (let instanceof Wall && !being.jump((Wall) let)) {
                    isHappened = false;
                    break;
                }
            }
            if (!isHappened) continue;
        }

        DayOfWeek.getHoursToEndWeek(DayOfWeek.SATURDAY);

    }
}
