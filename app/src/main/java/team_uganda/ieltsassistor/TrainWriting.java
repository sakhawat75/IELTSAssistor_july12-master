package team_uganda.ieltsassistor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class TrainWriting extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    public static final String API_KEY = "AIzaSyB_Zd0mqe6hjOAZzg5a9fSbpwTvEgyDlcg";
    public static final String VIDEO_ID = "kM4lenmCDpY&list=PLOSo0A8ngEXWhD3_yisOF0qBB4e6sWx01";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_writing);

        YouTubePlayerView youTubePlayerView = (YouTubePlayerView)findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestricted) {
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        if(!wasRestricted)
        {
            youTubePlayer.cuePlaylist(VIDEO_ID);

        }
    }
    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(getApplicationContext(), "Failed to initialize", Toast.LENGTH_SHORT).show();
    }
}
