package ml.chandrakant.musicalstructure;

public class Song {
    private String mSongTitle;
    private String mSongArtist;
    private int mDuration;

    public Song(String mSongTitle, String mSongArtist, int mDuration) {
        this.mSongTitle = mSongTitle;
        this.mSongArtist = mSongArtist;
        this.mDuration =  mDuration;
    }

    public String getSongTitle() {
        return mSongTitle;
    }

    public String getSongArtist() {
        return mSongArtist;
    }

    public int getDuration () {
        return mDuration;
    }
}
