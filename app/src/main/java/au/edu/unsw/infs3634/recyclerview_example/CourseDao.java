package au.edu.unsw.infs3634.recyclerview_example;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CourseDao {

    // Return list of all course records from the table
    @Query("SELECT * FROM course")
    List<Course> getCourses();

    // Return a course record with provided course code
    @Query("SELECT * FROM course WHERE code == :courseCode")
    Course getCourse(String courseCode);

    // Delete all records from course table
    @Delete
    void deleteCourses(Course... courses);

    // Delete all records by using @Query
    @Query("DELETE FROM course")
    void deleteAll();

    // Insert list of courses into course table
    @Insert
    void insertCourses(Course... courses);
}
