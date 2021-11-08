package ru.kpfu.itis.entities;

import java.util.Objects;

public class GroupEntity extends AbstractEntity<Integer>{
    private int groupNumber;

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GroupEntity that = (GroupEntity) o;
        return groupNumber == that.groupNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), groupNumber);
    }
}
