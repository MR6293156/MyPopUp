package com.example.mypopup

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.RelativeLayout

class MainActivity : AppCompatActivity() {

    Button myButton;
    private PopupWindow myPopUp;
    private RelativeLayout positionOfPopUp;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        //FIRST SETTING UP BUTTON TO OPEN POP UP WINDOW USING ONCLICKLISTENER.
        myButton = (Button) findViewById(R.id.button);
        positionOfPopup = (RelativeLayout) findViewById(R.id)

        myButton.setOnClickListener(new View.OnClickListener()) {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = inflater.inflate(R.layout.popup_layout,null); //popup_layout is LAYOUT OF POP UP WINDOW

                myPopUp = new PopUpWindow(
                        customView
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );

                ImageButton closePopUp = (ImageButton) customView.findViewById(R.id.close);
                closePopUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myPopUp.dismiss();
                }

                }

            }
        });

        myPopUp.showAtLocation(positionOfPopup, Gravity.CENTER, 0, 0);
    }
}
