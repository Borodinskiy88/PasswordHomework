import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин: ");
        String login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();

        User user = getUserByLoginAndPassword(login, password);
        validateUser(user);

        System.out.println("Вход выполнен успешно!");

    }

    public static User[] getUsers() {
        User user1 = new User("leo", "1812", "tolstoi@mail.ru", 82);
        User user2 = new User("pavlik", "1917", "morozov@mail.ru", 11);
        User user3 = new User("yeltsyn", "1999", "yaustal@mail.ru", 76);
        User user4 = new User("tomsawyer", "Huckleberry", "twainrules@google.com", 9);
        return new User[]{user1, user2, user3, user4};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("Неверный логин или пароль");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException("Доступ запрещен, вам нет 18 лет");
        }
    }
}
