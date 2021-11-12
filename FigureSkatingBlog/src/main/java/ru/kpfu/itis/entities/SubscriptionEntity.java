package ru.kpfu.itis.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class SubscriptionEntity extends AbstractEntity<Long>{
    private String studentName;
    private String phoneNumber;
    private Timestamp created;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone_number) {
        this.phoneNumber = phoneNumber;
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
        SubscriptionEntity that = (SubscriptionEntity) o;
        return Objects.equals(studentName, that.studentName) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentName, phoneNumber, created);
    }
}
