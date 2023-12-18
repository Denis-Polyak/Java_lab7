import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static AbiturientCollection abiturientCollection = new AbiturientCollection();

    public static void main(String[] args) {

        Abiturient abiturient1 = new Abiturient(1, "Іванов", "Іван", "Іванович",
                "Івано-Франківськ", "123456789", 85.5);
        Abiturient abiturient2 = new Abiturient(2, "Петров", "Петр", "Петрович",
                "Київ", "987654321", 90.2);
        Abiturient abiturient3 = new Abiturient(3, "Степанчук", "Степан", "Степанович",
                "Одеса", "555555555", 78.0);

        abiturientCollection.addAbiturient(abiturient1);
        abiturientCollection.addAbiturient(abiturient2);
        abiturientCollection.addAbiturient(abiturient3);

        while (true) {
            System.out.println("====== Меню ======");
            System.out.println("1. Додати абітурієнта");
            System.out.println("2. Вилучити абітурієнта");
            System.out.println("3. Пошук абітурієнтів за іменем");
            System.out.println("4. Фільтр за середнім балом");
            System.out.println("5. Топ N абітурієнтів за середнім балом");
            System.out.println("6. Сортування за прізвищем та іменем");
            System.out.println("7. Унікальні роки народження");
            System.out.println("8. Кількість абітурієнтів за роками народження");
            System.out.println("0. Вийти");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addAbiturient();
                    break;
                case 2:
                    removeAbiturient();
                    break;
                case 3:
                    searchAbiturientsByName();
                    break;
                case 4:
                    filterAbiturientsByScore();
                    break;
                case 5:
                    getTopNAbiturients();
                    break;
                case 6:
                    sortAbiturients();
                    break;
                case 7:
                    showUniqueBirthYears();
                    break;
                case 8:
                    countAbiturientsByBirthYear();
                    break;
                case 0:
                    System.out.println("Дякую за використання програми. До побачення!");
                    System.exit(0);
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    private static int getUserChoice() {
        System.out.print("Введіть номер опції: ");
        return scanner.nextInt();
    }

    private static void addAbiturient() {
        System.out.println("Додавання нового абітурієнта:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Очищення буфера після введення числа
        System.out.print("Прізвище: ");
        String lastName = scanner.nextLine();
        System.out.print("Ім'я: ");
        String firstName = scanner.nextLine();
        System.out.print("По батькові: ");
        String middleName = scanner.nextLine();
        System.out.print("Адреса: ");
        String address = scanner.nextLine();
        System.out.print("Телефон: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Середній бал: ");
        double averageScore = scanner.nextDouble();

        Abiturient newAbiturient = new Abiturient(id, lastName, firstName, middleName, address, phoneNumber, averageScore);
        abiturientCollection.addAbiturient(newAbiturient);

        System.out.println("Новий абітурієнт доданий до колекції.");
    }

    private static void removeAbiturient() {
        System.out.println("Вилучення абітурієнта:");
        System.out.print("Введіть ID абітурієнта для вилучення: ");
        int id = scanner.nextInt();

        abiturientCollection.removeAbiturient(id);

        System.out.println("Абітурієнт вилучено з колекції.");
    }

    private static void searchAbiturientsByName() {
        System.out.println("Пошук абітурієнтів за іменем:");
        System.out.print("Введіть ім'я для пошуку: ");
        String name = scanner.next();

        List<Abiturient> searchResult = abiturientCollection.searchByName(name);

        System.out.println("Результат пошуку:");
        for (Abiturient abiturient : searchResult) {
            System.out.println(abiturient);
        }
    }

    private static void filterAbiturientsByScore() {
        System.out.println("Фільтр за середнім балом:");
        System.out.print("Введіть мінімальний середній бал: ");
        double minScore = scanner.nextDouble();

        List<Abiturient> filteredAbiturients = abiturientCollection.filterByAverageScore(minScore);

        System.out.println("Результат фільтрації:");
        for (Abiturient abiturient : filteredAbiturients) {
            System.out.println(abiturient);
        }
    }

    private static void getTopNAbiturients() {
        System.out.println("Топ N абітурієнтів за середнім балом:");
        System.out.print("Введіть кількість абітурієнтів: ");
        int n = scanner.nextInt();

        List<Abiturient> topNAbiturients = abiturientCollection.getTopNByAverageScore(n);

        System.out.println("Топ " + n + " абітурієнтів:");
        for (Abiturient abiturient : topNAbiturients) {
            System.out.println(abiturient);
        }
    }

    private static void sortAbiturients() {
        System.out.println("Сортування за прізвищем та іменем:");
        List<Abiturient> sortedAbiturients = abiturientCollection.sortByLastNameAndFirstName();

        System.out.println("Результат сортування:");
        for (Abiturient abiturient : sortedAbiturients) {
            System.out.println(abiturient);
        }
    }

    private static void showUniqueBirthYears() {
        System.out.println("Унікальні роки народження:");
        Set<Integer> uniqueBirthYears = abiturientCollection.getUniqueBirthYears();

        System.out.println("Результат:");
        for (int birthYear : uniqueBirthYears) {
            System.out.println(birthYear);
        }
    }

    private static void countAbiturientsByBirthYear() {
        System.out.println("Кількість абітурієнтів за роками народження:");
        Map<Integer, Integer> birthYearCount = abiturientCollection.countAbiturientsByBirthYear();

        System.out.println("Результат:");
        for (Map.Entry<Integer, Integer> entry : birthYearCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
