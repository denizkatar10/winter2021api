package pojos;

    /*
        POJO: Plain Old Java Object
        POJO is a Java Class

        To create a POJO Class, we need to do 5 steps;
        1)Create "private" variables
        2)Create all getter() and setter()
        3)Create constructor without parameter
        4)Create constructor with all parameters
        5)Create toString()
     */

public class TodosPojo {

    //1)Create "private" variables
    private int userId;
    private String title;
    private boolean completed;

    //2)Create all getter() and setter()
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    //3)Create constructor without parameter
    public TodosPojo() {
    }

    //4)Create constructor with all parameters
    public TodosPojo(int userId, String title, boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    //5)Create toString()
    @Override
    public String toString() {
        return "TodosPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}