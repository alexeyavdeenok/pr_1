public class Teacher extends Worker {
  private int hours;
  private String direction;

  public Teacher() {
    super();
    setProfession("Преподаватель");
    setHours(0);
    setDirection("None");
  }

  public Teacher(String name, int age, int salary, int hours, String direction) {
    super(name, age, salary, "Преподаватель");
    setHours(hours);
    setDirection(direction);
  }

  @Override
  public String toString() {
    return super.toString()
        + "\nДисциплина(предмет): "
        + this.direction
        + "\nНагрузка(в часах в неделю): "
        + this.hours;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Teacher teacher = (Teacher) o;
    return hours == teacher.hours && direction.equals(teacher.direction);
  }

  @Override
  public int hashCode() {
    int result = direction == null ? 0 : direction.hashCode();
    result = result * 31 + hours;
    result += super.hashCode();
    return result;
  }

  public int getHours() {
    return this.hours;
  }

  public void setHours(int hours) {
    if (hours >= 0 && hours <= 40) {
      this.hours = hours;
    } else {
      System.out.println("Столько работать нельзя");
    }
  }

  public String getDirection() {
    return this.direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }
}
