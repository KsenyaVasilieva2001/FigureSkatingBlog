package ru.kpfu.itis.entities;

import java.util.Objects;

public class SpecialityEntity extends AbstractEntity<Integer>{
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SpecialityEntity that = (SpecialityEntity) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    public String getName() {
        return name;
    }

    public void setName(String specialityName) {
        this.name = name;
    }
}
