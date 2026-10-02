public class NameTag {

    private final String firstName;
    private final String lastName;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        firstName = parts[0];
        lastName = parts[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }
}