package program.day0918_night;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class Type {
    private String  description;
    private String keyword;
    private String name;
    private String imag;

    public Type() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImag() {
        return imag;
    }

    public void setImag(String imag) {
        this.imag = imag;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public Type(String description, String keyword, String name, String imag, String food) {

        this.description = description;
        this.keyword = keyword;
        this.name = name;
        this.imag = imag;
        this.food = food;
    }

    private String food;

}
