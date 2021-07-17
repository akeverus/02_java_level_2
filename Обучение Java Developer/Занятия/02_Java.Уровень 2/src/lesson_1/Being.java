package lesson_1;

abstract class Being implements RunnableJumpable{

    private final String name;
    private final int maxLenght;
    private final int maxHeight;

    public Being(String name, int maxLenght, int maxHeight) {
        this.name = name;
        this.maxLenght = maxLenght;
        this.maxHeight = maxHeight;
    }

    public boolean jump(Wall w) {
        if (w.getHeight() <= this.maxHeight) {
            System.out.printf("%s смог перепрыгнуть стену высотой %d, т.к. высота, которую он может перепрыгнуть равна %d\n", this.name, w.getHeight(), this.maxHeight);
            return true;
        } else {
            System.out.printf("%s НЕ смог перепрыгнуть стену высотой %d, т.к. высота, которую он может перепрыгнуть равна %d\n", this.name, w.getHeight(), this.maxHeight);
            return false;
        }
    }

    public boolean run(Treadmill t) {
        if (t.getLenght() <= this.maxLenght) {
            System.out.printf("%s смог пробежать дорожку длинной %d, т.к. расстояние, которое он может пробежать равно %d\n", this.name, t.getLenght(), this.maxLenght);
            return true;
        } else {
            System.out.printf("%s НЕ смог пробежать дорожку длинной %d, т.к. расстояние, которое он может пробежать равно %d\n", this.name, t.getLenght(), this.maxLenght);
            return false;
        }
    }
}
