package com.upce.elements;

import java.util.Map;
import java.util.Objects;

public class Group {

    private final Integer id;
    private final String name;
    private final Map<Integer, User> users;

    public Group(int id, String name, Map<Integer, User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public User addUser(User user) {
        return users.put(user.getId(), user);
    }

    public User removeUser(Integer idUser) {
        return users.remove(idUser);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + Objects.hashCode(this.users);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Group other = (Group) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.users, other.users);
    }

    @Override
    public String toString() {
        return "Group{" + "id=" + id + ", name=" + name + ", users=" + users + '}';
    }
}
