package lesson_1;

public enum DayOfWeek {

    MONDAY (8),
    TUESDAY(8),
    WEDNESDAY(8),
    THURSDAY(8),
    FRIDAY(8),
    SATURDAY(0),
    SUNDAY(0);

    private final int hour;

    public int getHour() {
        return hour;
    }

    DayOfWeek(int hour) {
        this.hour = hour;
    }

    public static void getHoursToEndWeek(DayOfWeek dayOfWeek){

        int hoursToEndWeek = 0;

        DayOfWeek[] dayOfWeekMass = DayOfWeek.values();

        for (int i = dayOfWeek.ordinal(); i < dayOfWeekMass.length; i++) {
            hoursToEndWeek = hoursToEndWeek + dayOfWeekMass[i].getHour();
        }

        if (hoursToEndWeek == 0) {
            System.out.println("Сегодня выходной");
        } else {
            System.out.printf("До конца рабочей недели осталось %d часов\n",hoursToEndWeek);
        }

    }
}
