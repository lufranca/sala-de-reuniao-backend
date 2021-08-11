package com.luciano.saladereuniao.saladereuniao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "meetingRoom")
public class Room implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "startHour" , nullable = false)
    private String startHour;

    @Column(name = "endHour" , nullable = false)
    private String endHour;

    public Room() {
    }

    public Room(long id, String name, String startHour, String endHour) {
        this.id = id;
        this.name = name;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    @Override
    public String toString() {
        return "Room [id=" + id + ", name=" + name + ", startHour=" + startHour + ", endHour=" + endHour + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room roomModel = (Room) o;
        return id == roomModel.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
