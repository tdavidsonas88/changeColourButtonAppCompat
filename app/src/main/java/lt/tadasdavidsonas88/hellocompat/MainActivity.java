package lt.tadasdavidsonas88.hellocompat;

import android.os.Build;
import android.os.PersistableBundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView mHelloTextView;

    private String[] mColorArray = {"red", "pink", "purple", "deep_purple",
        "indigo", "blue", "light_blue", "cyan", "teal", "green",
        "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
        "brown", "grey", "blue_grey", "black"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelloTextView = findViewById(R.id.hello_textview);
        if(savedInstanceState != null){
            mHelloTextView.setTextColor(savedInstanceState.getInt("color"));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        // save the current color
        outState.putInt("color", mHelloTextView.getCurrentTextColor());
    }

    public void changeColor(View view) {
        Random random = new Random();
        // The nextInt() method with the argument 20 gets another random integer between 0 and 19.
        String colorName = mColorArray[random.nextInt(20)];

        // get the color identifier that matches the color name
        int colorResourceName = getResources().getIdentifier(colorName,
                "color", getApplicationContext().getPackageName());

        // The getResources() method gets the set of resources for your app,
        // and the getColor() method retrieves a specific color
        // from those resources by the ID of the color name.
        int colorRes = ContextCompat.getColor(this, colorResourceName);
        mHelloTextView.setTextColor(colorRes);

    }
}
