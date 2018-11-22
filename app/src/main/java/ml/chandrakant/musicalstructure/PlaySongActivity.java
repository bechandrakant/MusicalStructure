package ml.chandrakant.musicalstructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class PlaySongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        String title = "";
        String artist = "";
        final int songDuration;

        // Get Intent extras to populate data in activity.
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            title = extras.getString("SongTitle");
            artist = extras.getString("SongArtist");
            songDuration = extras.getInt("SongDuration");
        } else {
            // Default song duration [Random]
            songDuration = 259;
        }

        TextView songTitle = findViewById(R.id.song_title);
        TextView songArtist = findViewById(R.id.song_artist);
        TextView totalDuration = findViewById(R.id.total_duration);
        final TextView currentDuration = findViewById(R.id.current_duration);

        songTitle.setText(title);
        songArtist.setText(artist);
        // Song duration is in seconds, converted to Min:Sec format and updated textview.
        totalDuration.setText((songDuration / 60) + ":" + (songDuration % 60));
        // current duration at start
        currentDuration.setText("0:00");

        final SeekBar seekBar = findViewById(R.id.seek_bar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                int currentTime = (songDuration * progress)/100;
                // current time is in seconds, converted to Min:Sec format and updated textview.
                int min = currentTime / 60;
                int sec = currentTime % 60;
                // second should be double digit.
                currentDuration.setText( min + ":" + ((sec < 10)?"0" + sec : sec));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ImageView dislike = findViewById(R.id.thumbs_down_image_view);
        ImageView like = findViewById(R.id.thumbs_up_image_view);
        ImageView fastRewind = findViewById(R.id.fast_rewind_image_view);
        ImageView fastForward = findViewById(R.id.fast_forward_image_view);
        final ImageView playPause = findViewById(R.id.play_pause_image_view);

        dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlaySongActivity.this, "You dislike this song!", Toast.LENGTH_SHORT).show();
            }
        });

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlaySongActivity.this, "You Like this song!", Toast.LENGTH_SHORT).show();
            }
        });

        fastRewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Decrement progress by 2%
                int secondsDecremented = songDuration * 2 / 100;
                seekBar.setProgress(seekBar.getProgress() - 2);
                // update current duration.
                Toast.makeText(PlaySongActivity.this, "Rewinded by " + secondsDecremented + " sec", Toast.LENGTH_SHORT).show();
            }
        });

        fastForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Increment progress by 2%
                int secondsIncremented = songDuration * 2 / 100;
                seekBar.setProgress(seekBar.getProgress() + 2);
                // update current duration.
                Toast.makeText(PlaySongActivity.this, "Forwarded by " + secondsIncremented + " sec", Toast.LENGTH_SHORT).show();
            }
        });

        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Flipping play pause functionality based on current image.
                if (playPause.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.ic_play).getConstantState()) {
                    Toast.makeText(PlaySongActivity.this, "Playing!", Toast.LENGTH_SHORT).show();
                    // Change icon to pause.
                    playPause.setImageResource(R.drawable.ic_pause);
                } else {
                    Toast.makeText(PlaySongActivity.this, "Paused!", Toast.LENGTH_SHORT).show();
                    // Change icon to play.
                    playPause.setImageResource(R.drawable.ic_play);
                }
            }
        });
    }
}
