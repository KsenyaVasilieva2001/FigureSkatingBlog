package ru.kpfu.itis.models;

import java.util.List;
import java.util.Objects;

public class Items<T> extends AbstractModel{

    private List<T> items;
    private int count;
    public List<T> getItems() {
        return items;
    }
    public void setItems(List<T> items) {
        this.items = items;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items<?> items1 = (Items<?>) o;
        return count == items1.count && Objects.equals(items, items1.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, count);
    }

}
