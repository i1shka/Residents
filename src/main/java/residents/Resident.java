package residents;

import java.util.Objects;

public class Resident {
    int age;
    int sex;

    public Resident(int age, int sex) throws WrongAgeException, WrongSexException {
        if (age<0 || age>100) throw new WrongAgeException(age, "Неверный возраст: " + age);
        if (!(sex==0 || sex==1)) throw new WrongSexException(sex, "Несуществующий пол: " + sex);
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "age=" + age +
                ", sex=" + sex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resident resident = (Resident) o;
        return age == resident.age && sex == resident.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, sex);
    }
}
