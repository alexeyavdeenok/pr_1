import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final ArrayList<Person> list = new ArrayList<>();
    public static void main(String[] args) {

        while (true) {
            System.out.println("1. Добавить элемент");
            System.out.println("2. Добавить пустой элемент");
            System.out.println("3. Удалить элемент по индексу");
            System.out.println("4. Вывод всех элементов в консоль");
            System.out.println("5. Сравнение двух элементов на равенство (по индексам)");
            System.out.println("6. Завершение работы программы");

            int choice = 0;
            if (input.hasNextInt()) {
                choice = input.nextInt();
            } else {
                input.next();
            }
            switch (choice) {
                case 1:
                    if (addElem()) {
                        break;
                    }
                    System.out.println("Объект не добавлен");
                    break;
                case 2:
                    if (emptyObject()) {
                        System.out.println("Объект добавлен");
                        break;
                    }
                    System.out.println("Объект не добавлен");
                    break;
                case 3:
                    if (list.isEmpty()) {
                        System.out.println("Операция невозможна, список пуст");
                        break;
                    }
                    deleteObject();
                    break;
                case 4:
                    if (list.isEmpty()) {
                        System.out.println("Список пуст");
                        break;
                    }
                    printElem();
                    break;
                case 5:
                    if (list.isEmpty()) {
                        System.out.println("Список пуст");
                        break;
                    }
                    if (equalObjects()) {
                        break;
                    } else {
                        System.out.println("Сравнение не удалось");
                        break;
                    }
                case 6:
                    System.out.println("Программа завершена");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ошибка ввода");
            }
        }
    }
    public static boolean addElem() {
        System.out.println("Выберите класс объекта");
        System.out.println("1. Персона");
        System.out.println("2. Сотрудник");
        System.out.println("3. Преподаватель");
        System.out.println("4. Студент");

        int choice = 0;
        if (input.hasNextInt()) {
            choice = input.nextInt();
        } else {
            return false;
        }
        switch (choice) {
            case 1:
                if (addPerson()) {
                    System.out.println("Объект типа Персона добавлен");
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (addWorker()) {
                    System.out.println("Объект типа Сотрудник добавлен");
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (addTeacher()) {
                    System.out.println("Объект типа Преподаватель добавлен");
                    return true;
                } else {
                    return false;
                }
            case 4:
                if (addStudent()) {
                    System.out.println("Объект типа Студент добавлен");
                    return true;
                } else {
                    return false;
                }
            default:
                System.out.println("Ошибка ввода");
                break;
        }
        return false;
    }
    public static boolean addPerson() {
        System.out.println("Ввевдите имя: ");
        String name = input.next();
        System.out.println("Введите возраст: ");
        if (input.hasNextInt()) {
            int age = input.nextInt();
            Person person = new Person(name, age);
            if (person.getAge() == -1) {
                return false;
        }
            list.add(person);
            return true;
        } else {
            System.out.println("Недопустимый возраст");
            input.next();
            return false;
        }

    }
    public static boolean addWorker() {
        System.out.println("Введите имя: ");
        String name = input.next();
        System.out.println("Введите возраст:");
        int age = 500;
        if (input.hasNextInt()) {
            age = input.nextInt();
        } else {
            System.out.println("Недопустимый возраст");
            input.next();
            return false;
        }
        System.out.println("Введите профессию: ");
        String profession = input.next();
        System.out.println("Введите заработную плату: ");
        int salary = -1;
        if (input.hasNextInt()) {
            salary = input.nextInt();
        } else {
            input.next();
            return false;
        }
        Worker worker = new Worker(name, age, salary, profession);
        if (salary == worker.getSalary() && age == worker.getAge()) {
            list.add(worker);
            return true;
        }
        return false;
    }
    public static boolean addTeacher() {
        System.out.println("Введите имя: ");
        String name = input.next();
        System.out.println("Введите возраст:");
        int age = 500;
        if (input.hasNextInt()) {
            age = input.nextInt();
        } else {
            System.out.println("Недопустимый возраст");
            input.next();
            return false;
        }
        System.out.println("Введите заработную плату: ");
        int salary = -1;
        if (input.hasNextInt()) {
            salary = input.nextInt();
        } else {
            input.next();
            return false;
        }
        System.out.println("Введите предмет(дисциплину): ");
        String direction = input.next();
        System.out.println("Введите нагрузку в часах в неделю: ");
        int hours = -1;
        if (input.hasNextInt()) {
            hours = input.nextInt();
        } else {
            input.next();
            return false;
        }
        Teacher teacher = new Teacher(name, age, salary, hours, direction);
        if (age == teacher.getAge() && salary == teacher.getSalary() &&
        hours == teacher.getHours()) {
            list.add(teacher);
            return true;
        }
        return false;
    }
    public static boolean addStudent() {
        System.out.println("Введите имя: ");
        String name = input.next();
        System.out.println("Введите возраст:");
        int age = 500;
        if (input.hasNextInt()) {
            age = input.nextInt();
        } else {
            System.out.println("Недопустимый возраст");
            input.next();
            return false;
        }
        System.out.println("Введите направление: ");
        String speciality = input.next();
        System.out.println("Введите размер стипендии: ");
        int scholarship = -1;
        if (input.hasNextInt()) {
            scholarship = input.nextInt();
        } else {
            input.next();
            return false;
        }
        Student student = new Student(name, age, scholarship, speciality);
        if (age == student.getAge() && scholarship == student.getScholarship()) {
            list.add(student);
            return true;
        }
        return false;
    }
    public static void printElem() {
        for (Person i: list) {
            System.out.println("Индекс объекта: " + list.indexOf(i));
            if (i.getClass() == Person.class) {
                System.out.println("Класс: Персона");
            } else if (i.getClass() == Worker.class) {
                System.out.println("Класс: Сотрудник");
            } else if (i.getClass() == Teacher.class) {
                System.out.println("Класс: Преподаватель");
            } else {
                System.out.println("Класс: Студент");
            }
            System.out.println(i);
            System.out.println(" ");
        }
    }
    public static boolean emptyObject() {
        System.out.println("Выберите класс объекта");
        System.out.println("1. Персона");
        System.out.println("2. Сотрудник");
        System.out.println("3. Преподаватель");
        System.out.println("4. Студент");

        int choice = 0;
        if (input.hasNextInt()) {
            choice = input.nextInt();
        } else {
            input.next();
            return false;
        }
        switch (choice) {
            case 1:
                Person person = new Person();
                list.add(person);
                return true;
            case 2:
                Worker worker = new Worker();
                list.add(worker);
                return true;
            case 3:
                Teacher teacher = new Teacher();
                list.add(teacher);
                return true;
            case 4:
                Student student = new Student();
                list.add(student);
                return true;
            default:
                System.out.println("Ошибка ввода");
                break;
        }
        return false;
    }
    public static void deleteObject() {
        System.out.println("Введите индекс объекта, который хотите удалить:");
        int index = -1;
        if (input.hasNextInt()) {
            index = input.nextInt();
        } else {
            input.next();
        }
        if (index >= 0 && index < list.size()) {
            list.remove(index);
            System.out.println("Объект удален");
        } else {
            System.out.println("Объект не удален, неверный индекс");
        }
    }
    public static boolean equalObjects() {
        System.out.println("ВВедите индекс первого объекта:");
        int index1 = -1;
        if (input.hasNextInt()) {
            index1 = input.nextInt();
        } else {
            input.next();
            return false;
        }
        if (!(index1 >= 0 && index1 < list.size())){
            System.out.println("Неверный индекс");
            return false;
        }
        System.out.println("ВВедите индекс второго объекта:");
        int index2 = -1;
        if (input.hasNextInt()) {
            index2 = input.nextInt();
        } else {
            input.next();
            return false;
        }
        if (!(index2 >= 0 && index2 < list.size())){
            System.out.println("Неверный индекс");
            return false;
        }
        boolean check = list.get(index1).equals(list.get(index2));
        int hash1 = list.get(index1).hashCode();
        int hash2 = list.get(index2).hashCode();
        if (check) {
            System.out.println("Объекты равны");
            System.out.println("hashCode первого объекта: " + hash1);
            System.out.println("hashCode второго объекта: " + hash2);
            return true;
        }
        System.out.println("Объекты не равны");
        System.out.println("hashCode первого объекта: " + hash1);
        System.out.println("hashCode второго объекта: " + hash2);
        return true;
    }
}