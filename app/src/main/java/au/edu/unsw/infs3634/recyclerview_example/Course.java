package au.edu.unsw.infs3634.recyclerview_example;

public class Course {
    private String code;
    private String name;

    public Course(String courseCode, String courseName) {
        this.code = courseCode;
        this.name = courseName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
