package ru.kpfu.itis.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class ApplicationEntity extends AbstractEntity<Long>{
    private String studentName;
    private String phone_number;
    private Timestamp created;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ApplicationEntity that = (ApplicationEntity) o;
        return Objects.equals(studentName, that.studentName) && Objects.equals(phone_number, that.phone_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentName, phone_number, created);
    }
}
