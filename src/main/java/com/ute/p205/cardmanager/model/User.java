package com.ute.p205.cardmanager.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "UserName")
    private String username;
    @Column(name = "Password")
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "User_ID"),
            inverseJoinColumns = @JoinColumn(name = "Role_ID")
    )
    private Set<Role> roles;

    @OneToOne
    @JoinColumn(name = "status", referencedColumnName = "id")
    private Status status;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserInfo userInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
/*CREATE TABLE Users(
	ID int not null primary key,
    UserName nvarchar(25) not null,
    Password nvarchar(25) not null,
    Status int not null,
    Info_ID int not null,
    foreign key (Status) references Status(ID) on update cascade on delete cascade,
    foreign key (Info_ID) references UserInfo(ID) on update cascade on delete cascade
);*/