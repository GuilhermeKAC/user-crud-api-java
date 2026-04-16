package userapi;

import userapi.controller.UserController;
import userapi.model.User;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        UserController controller = new UserController();

        controller.setup();

        User newUser = controller.createUser("Novo Nome", "novo2@email.com");
        System.out.println("usuário criado com id: " + newUser.getId());

        System.out.println("\n=== LISTA DE TODOS ===");

        for (User user : controller.getAllUsers()) {
            System.out.println(user.getId() + " - " + user.getName() + " - " + user.getEmail());
        }

        System.out.println("\n=== FIM ===");
    }
}