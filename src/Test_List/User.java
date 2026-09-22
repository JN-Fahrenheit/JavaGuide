package Test_List;

public class User {
    int id ;
    String name ;
    int age ;
    String addr ;

    // 构造方法：创建User对象时必须传入以下信息
    public User(int id, String name, int age, String addr) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.addr = addr;
    }
    // 注意要写 getter/setter/toString,toString要重写当前实际List信息
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }
}
