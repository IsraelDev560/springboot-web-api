package dio.web_api.respository;

import dio.web_api.handler.BusinessException;
import dio.web_api.handler.CampoObrigatorioException;
import dio.web_api.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public void save(User user) {
        if(user.getUsername() == null){
            throw new CampoObrigatorioException("username");
        }

        if(user.getLogin() == null){
            throw new CampoObrigatorioException("login");
        }

        if(user.getPassword() == null){
            throw new CampoObrigatorioException("password");
        }

        if (user.getId() == null) {
            user.setId(users.size() + 1);
            System.out.println("SAVE - Recebendo o usuário na camada de repositório");
        } else {
            users.removeIf(existingUser -> existingUser.getId().equals(user.getId()));
            System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
        }
        users.add(user);
        System.out.println(user);
    }
    public void deleteById(Integer id){
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário", id));
        users.removeIf(user -> user.getId().equals(id));
    }
    public List<User> findAll(){
        System.out.println("LIST - Listando os usuários do sistema");
        return new ArrayList<>(users);
    }
    public User findById(Integer id){
        System.out.println(String.format("FIND/id - Recebendo o id: %d para localizar um usuário", id));
        Optional<User> user = users.stream().filter(u -> u.getId().equals(id)).findFirst();
        return user.orElse(null);
    }
    public User findByUsername(String username){
        System.out.println(String.format("FIND/username - Recebendo o username: %s para localizar um usuário", username));
        Optional<User> user = users.stream().filter(u -> u.getLogin().equals(username)).findFirst();
        return user.orElse(null);
    }
    public User findByLogin(String login){
        System.out.println(String.format("FIND/login - Recebendo o login: %s para localizar um usuário", login));
        Optional<User> user = users.stream().filter(u -> u.getLogin().equals(login)).findFirst();
        return user.orElse(null);
    }
}
