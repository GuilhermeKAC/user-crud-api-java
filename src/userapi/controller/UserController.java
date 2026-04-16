package userapi.controller;

import userapi.model.User;
import userapi.service.UserService;
import java.util.List;

public class UserController {

    private UserService service = new UserService();

    // Setup inicial (criar tabela)
    public void setup() {
        service.setupDatabase();
        System.out.println("Setup concluído!");
    }

    // CREATE - Criar usuário
    public User createUser(String name, String email) {
        System.out.println("POST /users - Criando usuário: " + name);
        return service.createUser(name, email);
    }

    // READ - Listar todos
    public List<User> getAllUsers() {
        System.out.println("GET /users - Listando todos");
        return service.getAllUsers();
    }

    // READ - Buscar por ID
    public User getUserById(Long id) {
        System.out.println("GET /users/" + id + " - Buscando usuário");
        return service.getUserById(id);
    }

    // UPDATE - Atualizar usuário
    public User updateUser(Long id, String name, String email) {
        System.out.println("PUT /users/" + id + " - Atualizando usuário");
        return service.updateUser(id, name, email);
    }

    // DELETE - Deletar usuário
    public void deleteUser(Long id) {
        System.out.println("DELETE /users/" + id + " - Deletando usuário");
        service.deleteUser(id);
    }
}