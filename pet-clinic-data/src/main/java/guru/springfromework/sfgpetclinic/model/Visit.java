package guru.springfromework.sfgpetclinic.model;

import javax.swing.*;
import java.time.LocalDate;

public class Visit extends BaseEntity {
    private LocalDate date;
    private Spring description;
    private Pet pet;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Spring getDescription() {
        return description;
    }

    public void setDescription(Spring description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
