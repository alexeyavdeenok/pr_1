public class Student extends Person {
  private int scholarship;
  private String speciality;

  public Student() {
    super();
    setScholarship(0);
    setSpeciality("None");
  }

  public Student(String name, int age, int scholarship, String speciality) {
    super(name, age);
    setScholarship(scholarship);
    setSpeciality(speciality);
  }

  @Override
  public String toString() {
    return super.toString()
        + "\nНаправление: "
        + this.speciality
        + "\nСтипендия: "
        + this.scholarship;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Student student = (Student) o;
    return scholarship == student.scholarship && speciality.equals(student.speciality);
  }

  @Override
  public int hashCode() {
    int result = speciality == null ? 0 : speciality.hashCode();
    result = result * 31 + scholarship;
    result += super.hashCode();
    return result;
  }

  public int getScholarship() {
    return this.scholarship;
  }

  public void setScholarship(int scholarship) {
    if (scholarship >= 0 && scholarship <= 100000) {
      this.scholarship = scholarship;
    } else {
      System.out.println("Недопустимое значение стипендии");
    }
  }

  public String getSpeciality() {
    return this.speciality;
  }

  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }
}
