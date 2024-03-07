public class Person {
  private String name;
  private int age = -1;

  public Person(String name, int age) {
    setName(name);
    setAge(age);
  }

  public Person() {
    setName("None");
    setAge(0);
  }

  @Override
  public String toString() {
    return "Имя: " + this.name + "\nВозраст: " + this.age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return name.equals(person.name) && age == person.age;
  }

  @Override
  public int hashCode() {
    int result = name == null ? 0 : name.hashCode();
    result = result * 31 + age;
    return result;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) { // Установка возраста с реалистичным значением
    if (age >= 0 && age < 150) {
      this.age = age;
    } else {
      System.out.println("Недопустимый возраст");
    }
  }
}
