package lesson.reflection;

/**
 * @author tyrantqiao
 * @date 2020/8/20
 * email: tyrantqiao@gmail.com
 */
public class ParentGeneric<T> {
    StringBuilder stringBuilder = new StringBuilder();

    private T msg;

    public void setMsg(T msg) {
        System.out.println("parent try to set msg");
        this.msg = msg;
        stringBuilder.append(",parent talked.\n");
    }

    @Override
    public String toString() {
        return "ParentGeneric{" +
                "stringBuilder=" + stringBuilder.toString() +
                '}';
    }
}
