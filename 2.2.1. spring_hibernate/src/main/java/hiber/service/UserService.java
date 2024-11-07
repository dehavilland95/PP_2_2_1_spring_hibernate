package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listAll();
    User getByCarModelAndSeries(String carModel, int series);
}
