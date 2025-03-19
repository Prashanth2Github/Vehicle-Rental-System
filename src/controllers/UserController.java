package controllers;

import model.User;
import service.UserService;
import java.util.List;

/**
 * Controller for managing user-related operations.
 */
public class UserController {
    private UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    public void addUser(String name, String contactInfo, String paymentMethod) {
        User user = new User(0, name, contactInfo, paymentMethod); // ID auto-generated
        userService.addUser(user);
    }

    public User getUserById(int userId) {
        return userService.getUserById(userId);
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public void updateUser(int userId, String name, String contactInfo, String paymentMethod) {
        User user = new User(userId, name, contactInfo, paymentMethod);
        userService.updateUser(user);
    }

    public void deleteUser(int userId) {
        userService.deleteUser(userId);
    }
}
