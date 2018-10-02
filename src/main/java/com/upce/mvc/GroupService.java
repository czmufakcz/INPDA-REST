package com.upce.mvc;

import com.upce.elements.Group;
import com.upce.elements.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class GroupService {

    private final List<Group> groups;

    public GroupService() {
        groups = new LinkedList<>();
        Map<Integer, User> users = new HashMap<>();
        Integer id = 1;
        users.put(id, new User(id++, "Jakub", "Ž", 25));
        users.put(id, new User(id++, "Jakub", "K", 25));
        users.put(id, new User(id++, "Tomáš", "T", 10));
        users.put(id, new User(id++, "Martin", "F", 12));
        groups.add(new Group(1, "Group 1", users));

        users = new HashMap<>();
        users.put(id, new User(id++, "Martin", "B", 25));
        users.put(id, new User(id++, "Petr", "K", 24));
        users.put(id, new User(id++, "Jan", "M", 24));
        users.put(id, new User(id++, "Jan", "F", 40));
        users.put(id, new User(id++, "Libor", "M", 24));
        users.put(id, new User(id++, "Filip", "N", 24));
        groups.add(new Group(2, "Group 2", users));
    }

    public List<Group> getGroups() {
        return groups;
    }
}
