package Animals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Animals {
    protected int petId;
    protected String name;
    protected LocalDate birthday;

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getPetId() {
        return petId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdayDate() {
        return birthday;
    }
    public String getBirthday() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return formatter.format(birthday);
    }

    @Override
    public String toString() {
        return String.format("%d. %s: кличка: %s, дата рождения: %s ", getPetId(), getClass().getSimpleName(), name, getBirthday());
    }
}
