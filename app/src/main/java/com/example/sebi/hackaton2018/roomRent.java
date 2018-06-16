package com.example.sebi.hackaton2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import Model.DummyData.DummyCreator;
import Model.Job;
import Model.Room;
import Model.UserSingleton;

public class roomRent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_rent);

        ListView listViewRoom = findViewById(R.id.roomListView);

        RoomAdapter roomAdapter = new RoomAdapter();
        listViewRoom.setAdapter(roomAdapter);
    }

    class RoomAdapter extends BaseAdapter {

        ArrayList<Room> rooms;
        public RoomAdapter(){
            rooms = new ArrayList<>();
            //get all rooms
            rooms = DummyCreator.getSomeRooms();
        }

        @Override
        public int getCount() {
            return rooms.size();
        }

        @Override
        public Object getItem(int i) {
            return rooms.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.roomrent_listview,null);
            addRoomsToList(rooms.get(i), view);
            return view;
        }

        private void addRoomsToList(Room room, View view) {
            TextView roomtitleView = view.findViewById(R.id.roomtitleView);
            roomtitleView.setText(("Name: "+room.getTitle()));
            TextView roomlocationView = view.findViewById(R.id.roomlocationView);
            roomlocationView.setText(("Ort: "+room.getLocation()));
            TextView roomDescriptionView = view.findViewById(R.id.roomDescriptionView);
            roomDescriptionView.setText(("Beschreibung: "+room.getDescription()));
            TextView roomResponsiblePersonView = view.findViewById(R.id.roomResponsiblePersonView);
            roomResponsiblePersonView.setText(("Verantwortlicher: "+room.getResponsiblePerson()));
            TextView roomSizeView = view.findViewById(R.id.roomSizeView);
            roomSizeView.setText(("Größe: "+room.getSize()+"m"));
            TextView roomPriceView = view.findViewById(R.id.roomPriceView);
            roomPriceView.setText(("Preis: "+room.getCost()+" WüRG"));
            Button reservateRoom = view.findViewById(R.id.reservateRoom);
            if(room.getBooker() != null){
                reservateRoom.setText("Besetzt");
                reservateRoom.setClickable(false);
                reservateRoom.setEnabled(false);
            }
            else {
                reservateRoom.setText("Reservieren");
                reservateRoom.setClickable(true);
                reservateRoom.setEnabled(true);
            }
        }
    }

    public void reservate(View view){

        //Reservate On Server
        Button reservateRoom = findViewById(R.id.reservateRoom);

        reservateRoom.setText("Besetzt");
        reservateRoom.setClickable(false);
        reservateRoom.setEnabled(false);
    }
}
