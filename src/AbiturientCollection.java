import java.util.*;

public class AbiturientCollection {
    private Map<Integer, Abiturient> abiturients;

    public AbiturientCollection() {
        this.abiturients = new HashMap<>();
    }

    public void addAbiturient(Abiturient abiturient) {
        abiturients.put(abiturient.getId(), abiturient);
    }

    public void removeAbiturient(int id) {
        abiturients.remove(id);
    }

    public List<Abiturient> searchByName(String name) {
        List<Abiturient> result = new ArrayList<>();
        for (Abiturient abiturient : abiturients.values()) {
            if (abiturient.getFirstName().equalsIgnoreCase(name) ||
                    abiturient.getLastName().equalsIgnoreCase(name) ||
                    abiturient.getMiddleName().equalsIgnoreCase(name)) {
                result.add(abiturient);
            }
        }
        result.sort(Comparator.comparingDouble(Abiturient::getAverageScore).reversed());
        return result;
    }

    public List<Abiturient> filterByAverageScore(double minScore) {
        List<Abiturient> result = new ArrayList<>();
        for (Abiturient abiturient : abiturients.values()) {
            if (abiturient.getAverageScore() > minScore) {
                result.add(abiturient);
            }
        }
        return result;
    }

    public List<Abiturient> getTopNByAverageScore(int n) {
        List<Abiturient> result = new ArrayList<>(abiturients.values());
        result.sort(Comparator.comparingDouble(Abiturient::getAverageScore).reversed());
        return result.subList(0, Math.min(n, result.size()));
    }

    public List<Abiturient> sortByLastNameAndFirstName() {
        List<Abiturient> result = new ArrayList<>(abiturients.values());
        result.sort(Comparator.comparing(Abiturient::getLastName)
                .thenComparing(Abiturient::getFirstName));
        return result;
    }

    public Set<Integer> getUniqueBirthYears() {
        Set<Integer> birthYears = new TreeSet<>();
        for (Abiturient abiturient : abiturients.values()) {
            birthYears.add(2000);
        }
        return birthYears;
    }

    public Map<Integer, Integer> countAbiturientsByBirthYear() {
        Map<Integer, Integer> birthYearCount = new HashMap<>();
        for (Abiturient abiturient : abiturients.values()) {
            int birthYear = 2000;
            birthYearCount.put(birthYear, birthYearCount.getOrDefault(birthYear, 0) + 1);
        }
        return birthYearCount;
    }

    @Override
    public String toString() {
        return "AbiturientCollection{" +
                "abiturients=" + abiturients +
                '}';
    }
}
