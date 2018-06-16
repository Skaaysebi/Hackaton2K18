package com.example.sebi.hackaton2018;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import Model.DummyData.DummyCreator;
import Model.Job;
import Model.Room;
import Model.UserSingleton;

public class joboverview_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joboverview_page);

        TextView points = findViewById(R.id.pointView);
        //int amount = UserSingleton.getInstance().getAmount();
        //points.setText((amount+"WüRG"));
        Spinner spinner = findViewById(R.id.kategorySpinner);

        String[] categorys = {"Haushalt", "Garten", "Betreuung", "Dienstleistung", "Handwerk"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, categorys);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        ListView listViewRoom = findViewById(R.id.listViewJobs);

        JobAdapter jobAdapter = new JobAdapter();
        listViewRoom.setAdapter(jobAdapter);
    }

    class JobAdapter extends BaseAdapter {

        ArrayList<Job> jobs;
        public JobAdapter(){
            jobs = new ArrayList<>();
            //get all rooms
            jobs = DummyCreator.getSomeJobs();
        }

        @Override
        public int getCount() {
            return jobs.size();
        }

        @Override
        public Object getItem(int i) {
            return jobs.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.job_listview,null);
            addJobToList(jobs.get(i), view);
            return view;
        }

        private void addJobToList(Job job, View view) {
            TextView titleView = view.findViewById(R.id.titleView);
            titleView.setText(("Name: "+job.getName()));
            TextView locationView = view.findViewById(R.id.locationView);
            locationView.setText(("Ort: "+job.getLocation()));
            TextView descriptionView = view.findViewById(R.id.descriptionView);
            descriptionView.setText(("Beschreibung: "+job.getDescription()));
            TextView responsibleView = view.findViewById(R.id.responsibleView);
            responsibleView.setText(("Verantwortlicher: "+job.getResponsiblePerson()));
            TextView dateView = view.findViewById(R.id.dateView);
            dateView.setText(("Datum: "+job.getDate()));
            TextView rewardView = view.findViewById(R.id.rewardView);
            rewardView.setText(("Entlohnung: "+job.getReward()+" WüRG"));
            Button acceptJob = view.findViewById(R.id.acceptJob);
            if(job.getWorkerId() == null){
                acceptJob.setText("Besetzt");
                acceptJob.setClickable(false);
                acceptJob.setEnabled(false);
            }
            else {
                acceptJob.setText("Reservieren");
                acceptJob.setClickable(true);
                acceptJob.setEnabled(true);
            }
        }
    }

    public void reservate(View view){

        //Reservate On Server
        Button acceptJob = findViewById(R.id.acceptJob);

        acceptJob.setText("Besetzt");
        acceptJob.setClickable(false);
        acceptJob.setEnabled(false);
    }
}
