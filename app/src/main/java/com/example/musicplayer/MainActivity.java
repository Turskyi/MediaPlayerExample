package com.example.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        1)
        mediaPlayer = MediaPlayer.create(this,
                R.raw.zombi_a_contrari_post_apocalyptic_dubstep_mix);

//        2)
//        Uri myUri = Uri.parse(Uri.decode(
//                        "https://cdnet2.mixmuz" +
//                                ".ru/5a482e3b688d/652e3465b630" +
//                                "/b31996b77e2788855af79da85f7dc4c8-aac5575-dc7a0ab-1-560cd631608" +
//                                "/%D0%92%D1%96%D0%B4%D1%87%D1%83%D1%82%D1%82%D1%8F" +
//                                ".%D0%A2%D0%B8%D1%88%D1%96%20%E2%80%94%20%D0%91%D0%B5%D0%B7%D0%BE%D0%B4%D0%BD%D1%8F" +
//                                ".mp3")); // initialize Uri here
//        mediaPlayer = new MediaPlayer();
//        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//        try {
//            mediaPlayer.setDataSource(getApplicationContext(), myUri);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            mediaPlayer.prepare();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        3)
//        String url = "https://cdnet2.mixmuz" +
//                ".ru/5a482e3b688d/652e3465b630" +
//                "/b31996b77e2788855af79da85f7dc4c8-aac5575-dc7a0ab-1-560cd631608" +
//                "/%D0%92%D1%96%D0%B4%D1%87%D1%83%D1%82%D1%82%D1%8F" +
//                ".%D0%A2%D0%B8%D1%88%D1%96%20%E2%80%94%20%D0%91%D0%B5%D0%B7%D0%BE%D0%B4%D0%BD%D1%8F" +
//                ".mp3"; // your URL here
//        mediaPlayer = new MediaPlayer();
//        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//        try {
//            mediaPlayer.setDataSource(url);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            mediaPlayer.prepare(); // might take long! (for buffering, etc)
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        mediaPlayer.start();

        Button playButton = findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(MainActivity.this, "I'm done", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button pauseButton = findViewById(R.id.pause_button);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();

            }
        });
    }
}
