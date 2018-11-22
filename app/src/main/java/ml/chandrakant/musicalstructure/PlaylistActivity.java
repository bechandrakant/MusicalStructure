package ml.chandrakant.musicalstructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        ArrayList<Song> songs = new ArrayList<>();

        // Add data.
        songs.add(new Song("Ready for it.", "Taylor Swift", 211));
        songs.add(new Song("Not Afraid", "Eminem", 259));
        songs.add(new Song("Look what I found.", "Lady Gaga", 198));
        songs.add(new Song("What do you mean", "Justin Bieber", 298));
        songs.add(new Song("Waka Waka", "Shakira", 211));
        songs.add(new Song("Jai Ho.", "AR Rehman", 255));
        songs.add(new Song("Look what you made me do.", "Taylor Swift", 256));
        songs.add(new Song("Papa kehte hain.", "Udit Narayan", 255));
        songs.add(new Song("Tip tip barsa pani", "Alka Yagnik", 161));
        songs.add(new Song("Mangal Murti Maruti Nandan", "Gulshan Kumar", 397));
        songs.add(new Song("Maiyya Yashoda", "Anuradha Podwal", 328));

        ListView listView = findViewById(R.id.song_list);

        SongAdapter songAdapter = new SongAdapter(this, songs);

        listView.setAdapter(songAdapter);
    }
}
