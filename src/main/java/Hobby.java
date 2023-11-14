import java.util.List;

class Hobby {
    String name;
    int frequency;
    List<Address> addresses;

    public Hobby(String name, int frequency, List<Address> addresses) {
        this.name = name;
        this.frequency = frequency;
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public List getAddresses() {
        return addresses;
    }
}