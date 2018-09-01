package myenum.ii_2;

public enum Gender {
    MALE, FEMALE;
    private String sex;

    public void setSex(String sex) {
        switch (this) {
            case MALE:
                if (sex.equals("nan")) {
                    this.sex = sex;
                } else {
                    System.out.println("error");
                    return;
                }
                break;
            case FEMALE:
                if (sex.equals("nv")) {
                    this.sex = sex;
                } else {
                    System.out.println("error");
                    return;
                }
                break;
        }
    }

    public String getSex() {
        return this.sex;
    }
}
