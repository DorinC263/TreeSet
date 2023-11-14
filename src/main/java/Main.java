import java.util.*;

public class Main {
    public static void main(String[] args) {
        Comparator<Person> ageComparator = Comparator.comparingInt(Person::getAge);

        Set<Person> personSetByAge = new TreeSet<>(ageComparator);

        personSetByAge.add(new Person("Cristi", 25));
        personSetByAge.add(new Person("Alexandra", 33));
        personSetByAge.add(new Person("Mihai", 28));

        System.out.println("\nSorted by age: ");
        for (Person person : personSetByAge) {
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        }

        // HashMap to store hobbies
        Map<Person, List<Hobby>> hobbiesMap = new HashMap<>();

        // Adding information about hobbies
        List<Address> cyclingAddresses = Arrays.asList(
                new Address("Barcelona", "Spain"),
                new Address("Brussels", "Belgium"));
        List<Address> swimmingAddresses = Arrays.asList(
                new Address("Sydney", "Australia"),
                new Address("New York", "USA"));

        hobbiesMap.put(new Person("Cristi", 25),
                Arrays.asList(new Hobby("Cycling", 3, cyclingAddresses),
                        new Hobby("Swimming", 4, swimmingAddresses)));

        hobbiesMap.put(new Person("Mihai",28),
                Arrays.asList(new Hobby("Swimming",3,swimmingAddresses)));

        Person cristiToPrintHobbies = new Person("Cristi", 25);
        Person mihaiToPrintHobbies = new Person("Mihai", 28);

        List<Hobby> cristiHobbies = hobbiesMap.get(cristiToPrintHobbies);
        List<Hobby> mihaiHobbies = hobbiesMap.get(mihaiToPrintHobbies);

        if (cristiHobbies != null) {
            System.out.println("\nHobbies for " + cristiToPrintHobbies.getName() + ": ");
            for (Hobby hobby : cristiHobbies) {
                System.out.println("Hobby: " + hobby.getName() + ", Countries: " + getCountryList(hobby.getAddresses()));
            }
        }

        if(mihaiHobbies != null){
            System.out.println("\nHobbies for " + mihaiToPrintHobbies.getName() + ": ");
            for (Hobby hobby : mihaiHobbies) {
                System.out.println("Hobby: " + hobby.getName() + ", City: "
                        + getCityList(hobby.getAddresses()));
            }
        }
    }

    private static String getCountryList(List<Address> addresses) {
        StringBuilder countries = new StringBuilder();
        for (Address address : addresses) {
            countries.append(address.getCountry()).append(", ");
        }
        return countries.substring(0, countries.length() - 2);
    }

    private static String getCityList(List<Address> addresses) {
        StringBuilder cities = new StringBuilder();
        for (Address address : addresses) {
            cities.append(address.getCity()).append(", ");
        }
        return cities.substring(0, cities.length() - 2);
    }
}
