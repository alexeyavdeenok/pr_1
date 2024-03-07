public class Worker extends Person{
    private int salary;
    private String profession;

    public Worker(String name, int age, int salary, String profession) {
        super(name, age);
        setSalary(salary);
        setProfession(profession);
    }

    public Worker() {
        super();
        setSalary(0);
        setProfession("None");
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nЗаработная плата: " + this.salary +
                "\nДолжность: " + this.profession;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return salary == worker.salary && profession.equals(worker.profession);
    }

    @Override
    public int hashCode() {
        int result = profession == null ? 0 : profession.hashCode();
        result = result * 31 + salary;
        result += super.hashCode();
        return result;
    }
    public void setSalary(int salary){
        if (salary >= 0 && salary < 2000000) {
            this.salary = salary;
        } else {
            System.out.println("Недопустимое значение з/п");
        }
    }
    public int getSalary() {
        return this.salary;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
    public String getProfession() {
        return this.profession;
    }
    }
