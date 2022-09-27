package au.edu.unsw.infs3634.recyclerview_example;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.MyViewHolder> {
    private List<Course> mCourses;

    public CourseAdapter(List<Course> courses) {
        mCourses = courses;
    }

    @NonNull
    @Override
    public CourseAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.MyViewHolder holder, int position) {
        Course course = mCourses.get(position);
        holder.mCode.setText(course.getCode());
        holder.mName.setText(course.getName());
    }

    @Override
    public int getItemCount() {
        return mCourses.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mCode, mName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mCode = itemView.findViewById(R.id.tvCode);
            mName = itemView.findViewById(R.id.tvName);
        }
    }
}
