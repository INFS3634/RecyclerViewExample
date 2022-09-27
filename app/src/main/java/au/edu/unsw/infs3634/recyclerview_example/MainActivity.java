package au.edu.unsw.infs3634.recyclerview_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    private List<Course> courseList = new ArrayList<>();
    private CourseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rvList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);

        getData();
        adapter = new CourseAdapter(courseList);
        mRecyclerView.setAdapter(adapter);
    }

    private void getData(){
        for(int i=0; i < 30; i++) {
            Course course = new Course(String.valueOf(i), "Course "+ String.valueOf(i));
            courseList.add(course);
        }
    }
}