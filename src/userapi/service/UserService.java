package userapi.service;

import userapi.model.User;
import userapi.repository.UserRepository;
import java.util.List;

public class UserService {

    private UserRepository repository = new UserRepository();

    // Criar tabela (setup inicial)
    public void setupDatabase() {
        repository.createTable();
    }

    // Criar usuário
    public User createUser(String name, String email) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser vazio");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);

        return repository.save(user);
    }

    // Listar todos
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    // Buscar por ID
    public User getUserById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        User user = repository.findById(id);
        if (user == null) {
            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }
        return user;
    }

    // Atualizar usuário
    public User updateUser(Long id, String name, String email) {
        User existingUser = getUserById(id);

        if (name != null && !name.trim().isEmpty()) {
            existingUser.setName(name);
        }
        if (email != null && !email.trim().isEmpty()) {
            existingUser.setEmail(email);
        }

        return repository.update(existingUser);
    }

    // Deletar usuário
    public boolean deleteUser(Long id) {
        getUserById(id); // Verifica se existe
        return repository.delete(id);
    }
}