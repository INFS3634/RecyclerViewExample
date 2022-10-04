package au.edu.unsw.infs3634.recyclerview_example;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.MyViewHolder> implements Filterable {
    private List<Course> mCourses, mCoursesFiltered;
    private CourseRecyclerviewInterface mInterface;

    public CourseAdapter(List<Course> courses, CourseRecyclerviewInterface courseInterface) {
        mCourses = courses;
        mCoursesFiltered = courses;
        mInterface = courseInterface;
    }

    @NonNull
    @Override
    public CourseAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view, mInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.MyViewHolder holder, int position) {
        Course course = mCoursesFiltered.get(position);
        holder.mCode.setText(course.getCode());
        holder.mName.setText(course.getName());
    }

    @Override
    public int getItemCount() {
        return mCoursesFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String query = charSequence.toString();
                if(query.isEmpty()) {
                    mCoursesFiltered = mCourses;
                } else {
                    ArrayList<Course> filteredList = new ArrayList<>();
                    for(Course course : mCourses) {
                        if(course.getName().contains(query)) {
                            filteredList.add(course);
                        }
                    }
                    mCoursesFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mCoursesFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mCoursesFiltered = (ArrayList<Course>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mCode, mName;

        public MyViewHolder(@NonNull View itemView, CourseRecyclerviewInterface mInterface) {
            super(itemView);
            mCode = itemView.findViewById(R.id.tvCode);
            mName = itemView.findViewById(R.id.tvName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mInterface.onCourseClick(getAdapterPosition());
                }
            });
        }
    }
}
