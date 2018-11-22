package ml.chandrakant.musicalstructure;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        final Song song = getItem(position);

        TextView songTitle = listItemView.findViewById(R.id.song_title);
        songTitle.setText(song.getSongTitle());

        TextView songArtist = listItemView.findViewById(R.id.song_artist);
        songArtist.setText(song.getSongArtist());

        // Go to PlaySongActivity on clicking of play icon instead of whole list view.
        ImageView playButton = listItemView.findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PlaySongActivity.class);
                // Put extras to be passed to activity that plays music.
                intent.putExtra("SongTitle", song.getSongTitle());
                intent.putExtra("SongArtist", song.getSongArtist());
                intent.putExtra("SongDuration", song.getDuration());
                getContext().startActivity (intent);
            }
        });

        return listItemView;
    }
}
