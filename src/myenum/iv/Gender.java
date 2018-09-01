package myenum.iv;

class Xx{
    public static Xx MALE;
    static {
        MALE=new Xx(){
            public void info(){
                System.out.println("XXXXX");
            }
        };

    }
    public void info(){
        System.out.println("BBBB");
    }
}

public enum Gender implements GenderDesc {
    MALE("n") {
        public void info() {
            System.out.println("n");
        }
        public void run(){
            System.out.println("SSSSSS");
        }
    },
    FEMALE("nv") {
        public void info() {
            System.out.println("nv");
        }
    };
    private final String sex;

    private Gender(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return this.sex;
    }

    public void info() {
        System.out.println("xxxx");
    }

    public static void main(String[] args) {
        Gender gender=Gender.FEMALE;
        gender.info();
    }
}
