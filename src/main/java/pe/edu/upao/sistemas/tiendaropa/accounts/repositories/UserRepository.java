package pe.edu.upao.sistemas.tiendaropa.accounts.repositories;

import org.springframework.stereotype.Service;
import pe.edu.upao.sistemas.tiendaropa.accounts.models.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepository {
    private ArrayList<User> db = new ArrayList<>();

    UserRepository(){
        this.initializeDb();
    }

    private void initializeDb() {
        User admin = new User();
        admin.username = "Jeycob";
        admin.password = "123";
        db.add(admin);
    }

    public List<User> list(){
        return db;
    }

    public User create(User user){
        user.id = db.size() + 1;
        db.add(user);
        return user;
    }
}
