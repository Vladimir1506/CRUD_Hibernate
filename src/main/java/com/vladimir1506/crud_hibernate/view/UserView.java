package com.vladimir1506.crud_hibernate.view;

import com.vladimir1506.crud_hibernate.controller.PostController;
import com.vladimir1506.crud_hibernate.controller.RegionController;
import com.vladimir1506.crud_hibernate.controller.UserController;
import com.vladimir1506.crud_hibernate.model.Post;
import com.vladimir1506.crud_hibernate.model.Region;
import com.vladimir1506.crud_hibernate.model.Role;
import com.vladimir1506.crud_hibernate.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserView extends ViewAbstractClass {
    private final UserController userController = new UserController();
    private final RegionController regionController = new RegionController();
    private final PostController postController = new PostController();


    protected void print() {
        System.out.println("Введите номер действия, которые желаете произвести:");
        System.out.println("1. Вывести список всех пользователей.");
        System.out.println("2. Вывести информацию о пользователе по заданному id.");
        System.out.println("3. Добавить нового пользователя.");
        System.out.println("4. Удалить пользователя.");
        System.out.println("5. Изменить информацию о пользователе.");
        System.out.println("6. Вернуться к выбору сущности.");
        exitMessage(7);
    }

    protected void choose() {
        int choice = scanner().nextInt();
        switch (choice) {
            case 1:
                this.getAll();
                break;
            case 2:
                this.getById();
                break;
            case 3:
                this.create();
                break;
            case 4:
                this.delete();
                break;
            case 5:
                this.update();
                break;
            case 6:
                new MainView().start();
            case 7:
                System.exit(0);
                break;
        }
    }

    public void getAll() {
        List<User> users = userController.getAll();
        if (!users.isEmpty()) {
            System.out.println("Список пользователей:");
            System.out.println(users);
        } else System.out.println("Ни одного пользователя не создано");
    }

    public void create() {
        Region region;
        List<Post> userPosts = new ArrayList<>();
        System.out.println("Введите имя пользователя:");
        String userFName = scanner().nextLine();
        System.out.println("Введите фамилию пользователя:");
        String userLName = scanner().nextLine();
        List<Region> regions = regionController.getAll();
        if (regions.isEmpty()) {
            System.out.println("Список регионов пуст, введите название нового региона для этого пользователя:");
            region = regionController.createRegion(scanner().nextLine());
        } else {
            System.out.println("Выберите регион пользователя:");
            System.out.println(regions);
            region = regionController.getRegionById(Long.parseLong(scanner().nextLine()));
        }
        System.out.println("Введите роль пользователя из перечисленных вариантов");
        System.out.println(Arrays.toString(Role.values()));
        Role role = Role.valueOf(scanner().nextLine().toUpperCase());
        User newUser = userController.createUser(userFName, userLName, userPosts, region, role);
        System.out.println("Вы добавили нового пользователя:");
        System.out.println(newUser);
    }

    public void delete() {
        if (isUsersEmpty()) return;
        System.out.println("Введите id пользователя, которого желаете удалить:");
        Long id = scanner().nextLong();
        User deletedUser = userController.getUserById(id);
        userController.deleteUser(id);
        System.out.println("Удалён пользователь " + deletedUser);
        this.getAll();
    }

    public void getById() {
        if (isUsersEmpty()) return;
        System.out.println("Введите id пользователя, который желаете получить:");
        Long id = scanner().nextLong();
        User user = userController.getUserById(id);
        System.out.println("Запрашиваемый пользователь: ");
        System.out.println(user);
    }

    public void update() {
        if (isUsersEmpty()) return;
        System.out.println("Введите id пользователя, которого хотите изменить:");
        Long id = scanner().nextLong();
        System.out.println("Введите новое имя пользователя:");
        String firstName = scanner().nextLine();

        System.out.println("Введите новую фамилию пользователя:");
        String lastName = scanner().nextLine();
        System.out.println("Выберите новый регион пользователя: ");
        System.out.println(new RegionController().getAll());
        Region region = new RegionController().getRegionById(Long.parseLong(scanner().nextLine()));
        System.out.println("Введите новую роль пользователя из перечисленных вариантов");
        System.out.println(Arrays.toString(Role.values()));
        Role role = Role.valueOf(scanner().nextLine().toUpperCase());
        userController.updateUser(id, firstName, lastName,  region, role);
        this.getAll();
    }

    private boolean isUsersEmpty() {
        List<User> users = userController.getAll();
        if (users.isEmpty()) {
            getAll();
            return true;
        } else return false;
    }
}
