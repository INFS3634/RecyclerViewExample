package au.edu.unsw.infs3634.recyclerview_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements CourseRecyclerviewInterface {
    static final String TAG = "MainActivity";
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
        adapter = new CourseAdapter(courseList, this);
        mRecyclerView.setAdapter(adapter);
    }

    private void getData(){
        for(int i=0; i < 30; i++) {
            Course course = new Course(String.valueOf(i), "Course "+ String.valueOf(i));
            courseList.add(course);
        }
    }

    @Override
    public void onCourseClick(int position) {
        Course course = courseList.get(position);
        Toast.makeText(this, course.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.course_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Log.d(TAG, "Line 58:: Query = "+s);
                adapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Log.d(TAG, "Line 58:: Query = "+s);
                adapter.getFilter().filter(s);
                return false;
            }
        });
       return true;
    }
}