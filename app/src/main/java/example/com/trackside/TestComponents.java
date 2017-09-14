package example.com.trackside;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import example.com.trackside.cameraFeeds.SubscribeTes;
import example.com.trackside.cameraFeeds.SubscribeTest;

public class TestComponents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_components);
        /*VideoView videoView =(VideoView)findViewById(R.id.view_topleft_video);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        // Uri uri=Uri.parse("https://firebasestorage.googleapis.com/v0/b/pushnotifivation-2dd69.appspot.com/o/test.mp4?alt=media&token=896c21de-1aee-40d7-87fa-12a733d9048b");
        Uri uri=Uri.parse("192.168.43.16:8080/test");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();*/
//        VideoView view = (VideoView)findViewById(R.id.view_topleft_video);
//        String path = "android.resource://" + getPackageName() + "/" + R.raw.race;
//        view.setVideoURI(Uri.parse(path));
//        view.start();

        SubscribeTes frag = new SubscribeTes();

        getFragmentManager().beginTransaction()
                .replace(R.id.test_list_container, frag)
                .commit();

    }
}
