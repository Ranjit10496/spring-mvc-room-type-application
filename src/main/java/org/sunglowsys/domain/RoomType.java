package org.sunglowsys.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "room_type")
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", unique = true)
    @NotNull
    private String name;

    public RoomType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public RoomType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomType roomType = (RoomType) o;
        return Objects.equals(id, roomType.id) && Objects.equals(name, roomType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
