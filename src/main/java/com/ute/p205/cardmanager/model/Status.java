package com.ute.p205.cardmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "Status")
public class Status {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name = "Status")
    private String status;

    @OneToOne(mappedBy = "status")
    private User users;

    public Status() {
    }

    public Status(String status) {
        this.status = status;
    }

    public Status(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}
/*CREATE TABLE Status(
	ID int not null primary key,
    Status nvarchar(25) not null
);*/