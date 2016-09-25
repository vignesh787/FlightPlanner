package bits.project.com.flightplanner;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.DecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.ui.FirebaseListAdapter;
import com.firebase.ui.FirebaseRecyclerViewAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {



    Firebase mRootRef;

    ListView mListView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        mRootRef = new Firebase("https://samplefp-61fba.firebaseio.com/");
        Map<String, String> post1 = new HashMap<String, String>();
        post1.put("od", "MAA - BOM");
        post1.put("date", "09/20/2016 - 09/21/2016");
        post1.put("bookedWeight", "100");
        post1.put("grantedWeight","100");
        post1.put("bookedVolume", "50");
        post1.put("gratntedVolume", "50");


      //  mRootRef.push().setValue(post1);
        Map<String, String> post2 = new HashMap<String, String>();
        post2.put("od", "MAA - CCU ");
        post2.put("date", "09/21/2016 - 09/22/2016");
        post2.put("bookedWeight","60");
        post2.put("grantedWeight", "100");
        post2.put("bookedVolume","30");
        post2.put("gratntedVolume", "50");
       // mRootRef.push().setValue(post2);

        FirebaseListAdapter<Flight> listAdapter = new FirebaseListAdapter<Flight>(this,Flight.class,R.layout.two_line_list_item,mRootRef) {
            @Override
            protected void populateView(View view, Flight flight) {

                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setText(flight.getOd());
                TextView textView1 = (TextView) view.findViewById(android.R.id.text2);
                textView1.setText(flight.getDate());
            //    ProgressBar mprogressBar = (ProgressBar) view.findViewById(R.id.circular_progress_bar);
            //    System.out.println(flight);
            //    mprogressBar.setProgress(Integer.parseInt(flight.getGrantedWeight()));
            //    ProgressBar mprogressBar1 = (ProgressBar) view.findViewById(R.id.circular_progress_bar1);
            //    mprogressBar.setSecondaryProgress(Integer.parseInt(flight.getBookedWeight()));
                ProgressBar pb =(ProgressBar)view.findViewById(R.id.progressWheel);
                pb.setProgress(Integer.parseInt(flight.getGrantedWeight()));
                pb.setSecondaryProgress(Integer.parseInt(flight.getBookedWeight()));
                ProgressBar pb2 =(ProgressBar)view.findViewById(R.id.progressWheel2);
                pb2.setProgress(Integer.parseInt(flight.getGrantedVolume()));
                pb2.setSecondaryProgress(Integer.parseInt(flight.getBookedVolume()));
            }
        };
        mListView = (ListView) findViewById(R.id.ListView);
        mListView.setAdapter(listAdapter);
        mRootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("There are " + dataSnapshot.getChildrenCount() + " blog posts");


                for (DataSnapshot flightSnapshot: dataSnapshot.getChildren()) {
                    Flight flight = flightSnapshot.getValue(Flight.class);
                 //   System.out.println(flight.getData()+" - "+flight.getProgress() );
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    //    mListView = (ListView) findViewById(R.id.ListView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();


        Firebase messageRef= mRootRef.child("messages");


    }


}
