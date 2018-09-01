package myenum.ii_3;

public enum Gender {
    MALE("n"), FEMALE("nv");
    private final String sex;

    private Gender(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return this.sex;
    }
}
