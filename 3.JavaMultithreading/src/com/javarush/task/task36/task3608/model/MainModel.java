package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.dao.mock.DataSource;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class MainModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    private List<User> getAllUsers() {
        return userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1, 100));
    }

    public List<User> getUsersBetweenLevels(int fromLevel, int toLevel) {
        List<User> loclist = new ArrayList<>();
        for (int i = 0; i < DataSource.getInstance().getUsers().size(); i++) {
            int level = DataSource.getInstance().getUsers().get(i).getLevel();
            if (level >= fromLevel && level <= toLevel) {
                loclist.add(DataSource.getInstance().getUsers().get(i));
            }
        }
        return loclist;
    }

    public List<User> getAllDeletedUsers(){
        List<User> loclist = new ArrayList<>();
        return  loclist;
    }

    @Override
    public ModelData getModelData() {
        return this.modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getAllUsers()); // userService.getUsersBetweenLevels(1,100)
    }

    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        modelData.setUsers(userService.getAllDeletedUsers());
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    public void deleteUserById(long id) {
        userService.deleteUser(id);
        loadUsers();
    }

    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name, id, level);
        loadUsers();
    }

}
