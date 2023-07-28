public class Passenger implements Comparable<Passenger> {

    private String name;
    private int age;
    private String career;
    private String nacionality;
    private String cityDestiny;

    public Passenger(String name, int age, String career, String nacionality, String cityDestiny) {
        this.name = name;
        this.age = age;
        this.career = career;
        this.nacionality = nacionality;
        this.cityDestiny = cityDestiny;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCareer() {
        return career;
    }

    public String getNacionality() {
        return nacionality;
    }

    public String getCityDestiny() {
        return cityDestiny;
    }

    public boolean isCareer(Career career) {
        return this.career.equals(career.getNameInSpanish());
    }

    @Override
    public int compareTo(Passenger p) {
        return Integer.compare(this.age, p.getAge());
    }

}