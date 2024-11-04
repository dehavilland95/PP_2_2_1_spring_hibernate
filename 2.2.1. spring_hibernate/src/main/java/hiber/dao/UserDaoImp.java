package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from User")
                .getResultList();
    }

    @Override
    public User getByUser(String carModel, int series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession()
                .createQuery("from User u WHERE u.car.model = :carModel AND u.car.series = :series");
        query.setParameter("carModel", carModel);
        query.setParameter("series", series);
        return query.getSingleResult();
    }

}
