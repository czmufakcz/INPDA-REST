package com.upce.mvc;

import com.upce.elements.Group;
import com.upce.elements.User;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/groups")
public class GroupRestController {

    @Autowired
    public GroupService groupService;

    @GetMapping
    public ResponseEntity<Map<Integer, Group>> getGroups() {
        return new ResponseEntity<>(groupService.getGroups(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Group> addGroup(@RequestBody Group group) {
        return new ResponseEntity<>(groupService.getGroups().put(group.getId(), group), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroup(@PathVariable Integer id) {
        Group group = groupService.getGroups().get(id);
        if (group != null) {
            return new ResponseEntity<>(group, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Group> removeGroup(@PathVariable Integer id) {
        return new ResponseEntity<>(groupService.getGroups().remove(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/users")
    public ResponseEntity<Map<Integer, User>> getUsersInGroup(@PathVariable Integer id) {
        Group group = groupService.getGroups().get(id);
        if (group != null) {
            return new ResponseEntity<>(group.getUsers(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{id}/users")
    public ResponseEntity<User> addUserToGroup(@PathVariable Integer id, @RequestBody User user) {
        Group group = groupService.getGroups().get(id);
        if (group != null) {
            return new ResponseEntity<>(group.addUser(user), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/users/{userID}")
    public ResponseEntity<User> getUserInGroup(@PathVariable Integer id, @PathVariable Integer userID) {
        Group group = groupService.getGroups().get(id);
        if (group != null) {
            User user = group.getUsers().get(userID);
            if (user != null) {
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}/users/{userID}")
    public ResponseEntity<User> removeUserInGroup(@PathVariable Integer id, @PathVariable Integer userID) {
        Group group = groupService.getGroups().get(id);
        if (group != null) {
            return new ResponseEntity<>(group.getUsers().remove(userID), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
