class Address {
    String city;
    String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public char[] getCountry() {
        return country.toCharArray();
    }

    public char[] getCity() {
        return city.toCharArray();
    }
}