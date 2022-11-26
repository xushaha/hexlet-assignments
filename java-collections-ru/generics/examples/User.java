package exercise;

import java.util.Date;
import java.util.Objects;

public class User {
    private String name;
    private Date birthdate;

    public User(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(getName(), user.getName())
            && Objects.equals(getBirthdate(), user.getBirthdate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBirthdate());
    }
}
