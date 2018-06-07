package com.example.hamilton.golfcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;
import android.media.MediaPlayer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;
import android.content.Context;
import android.content.res.Configuration;

public class MainActivity extends AppCompatActivity {
    private static final String State_Score_Team_A = "scoreTeamA";
    private static final String State_Score_Team_B = "scoreTeamB";
    Button showPopupBtn, closePopupBtn;
    PopupWindow PopupWindow;
    RelativeLayout relativeLayout1;
    private int mscoreTeamA;
    private int mscoreTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            // Restore value of members from saved state
            mscoreTeamA = savedInstanceState.getInt(State_Score_Team_A);
            mscoreTeamB = savedInstanceState.getInt(State_Score_Team_B);
        } else {
            // Probably initialize variable with default values for a new instance
        }

        showPopupBtn = (Button) findViewById(R.id.rules_button);
        relativeLayout1 = (RelativeLayout) findViewById(R.id.relativeLayout1);

        showPopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //instantiate the popup.xml layout file
                LayoutInflater layoutInflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.custom_layout, null);

                closePopupBtn = (Button) customView.findViewById(R.id.closePopupBtn);

                //instantiate popup window
                PopupWindow = new PopupWindow(customView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

                //add animation to the popup window
                PopupWindow.setAnimationStyle(R.style.popup_window_animation_phone);

                //display the popup window
                PopupWindow.showAtLocation(relativeLayout1, Gravity.CENTER, 0, 0);

                //close the popup window on button click
                closePopupBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PopupWindow.dismiss();
                    }
                });
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);

        // Saved state score from saved instance
        savedInstanceState.putInt(State_Score_Team_A, mscoreTeamA);
        savedInstanceState.putInt(State_Score_Team_B, mscoreTeamB);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            // Always call the superclass first so it can restore the view hierarchy
            super.onRestoreInstanceState(savedInstanceState);

            mscoreTeamA = savedInstanceState.getInt(State_Score_Team_A);

            //Assign the tag to your variable and then display it
            TextView scoreViewA = (TextView) findViewById(R.id.team_a_score);
            scoreViewA.setText(String.valueOf(mscoreTeamA));

            mscoreTeamB = savedInstanceState.getInt(State_Score_Team_B);

            //Assign the tag to your variable and then display it
            TextView scoreViewB = (TextView) findViewById(R.id.team_b_score);
            scoreViewB.setText(String.valueOf(mscoreTeamB));
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Decrease the score for team A by 4 points.
     */
    public void condorPointsA(View view) {
        if (mscoreTeamA <= (-20)) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (mscoreTeamA == (-19)) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (mscoreTeamA == (-18)) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (mscoreTeamA == (-17)) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            mscoreTeamA = mscoreTeamA - 4;
            displayForTeamA(mscoreTeamA);
        }
    }

    /**
     * Decrease the score for team A by 3 points.
     */
    public void doubleEaglePointsA(View view) {
        if (mscoreTeamA <= (-20)) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (mscoreTeamA == (-19)) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (mscoreTeamA == (-18)) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            mscoreTeamA = mscoreTeamA - 3;
            displayForTeamA(mscoreTeamA);
        }
    }

    /**
     * Decrease the score for team A by 2 points.
     */

    public void eaglePointsA(View view) {
        if (mscoreTeamA <= (-20)) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (mscoreTeamA == (-19)) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            mscoreTeamA = mscoreTeamA - 2;
            displayForTeamA(mscoreTeamA);
        }
    }

    /**
     * Decrease the score for team A by 1 points.
     */

    public void birdiePointsA(View view) {
        if (mscoreTeamA <= (-20)) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            mscoreTeamA = mscoreTeamA - 1;
            displayForTeamA(mscoreTeamA);
        }
    }

    /**
     * Increase the score for team A by 1 points.
     */

    public void bogeyPointsA(View view) {
        if (mscoreTeamA >= 20) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            mscoreTeamA = mscoreTeamA + 1;
            displayForTeamA(mscoreTeamA);
        }
    }

    /**
     * Increase the score for team A by 2 points.
     */

    public void doubleBogeyPointsA(View view) {
        if (mscoreTeamA >= 20) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (mscoreTeamA == 19) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            mscoreTeamA = mscoreTeamA + 2;
            displayForTeamA(mscoreTeamA);
        }
    }

    /**
     * Increase the score for team A by 3 points.
     */

    public void tripleBogeyPointsA(View view) {
        if (mscoreTeamA >= 20) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (mscoreTeamA == 19) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (mscoreTeamA == 18) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            mscoreTeamA = mscoreTeamA + 3;
            displayForTeamA(mscoreTeamA);
        }
    }

    /**
     * Displays the given score for Team B.
     */

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Decrease the score for team B by 4 points.
     */
    public void condorPointsB(View view) {
        if (mscoreTeamB <= (-20)) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (mscoreTeamB == 19) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (mscoreTeamB == 18) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (mscoreTeamB == 17) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            mscoreTeamB = mscoreTeamB - 4;
            displayForTeamB(mscoreTeamB);
        }
    }

    /**
     * Decrease the score for team B by 3 points.
     */

    public void doubleEaglePointsB(View view) {
        if (mscoreTeamB <= (-20)) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (mscoreTeamB == (-19)) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (mscoreTeamB == (-18)) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            mscoreTeamB = mscoreTeamB - 3;
            displayForTeamB(mscoreTeamB);
        }
    }

    /**
     * Decrease the score for team B by 2 points.
     */

    public void eaglePointsB(View view) {
        if (mscoreTeamB <= (-20)) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (mscoreTeamB == (-19)) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            mscoreTeamB = mscoreTeamB - 2;
            displayForTeamB(mscoreTeamB);
        }
    }

    /**
     * Decrease the score for team B by 1 points.
     */

    public void birdiePointsB(View view) {
        if (mscoreTeamB <= (-20)) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            mscoreTeamB = mscoreTeamB - 1;
            displayForTeamB(mscoreTeamB);
        }
    }

    /**
     * Increase the score for team B by 1 points.
     */

    public void bogeyPointsB(View view) {
        if (mscoreTeamB >= 20) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            mscoreTeamB = mscoreTeamB + 1;
            displayForTeamB(mscoreTeamB);
        }
    }

    /**
     * Increase the score for team B by 2 points.
     */

    public void doubleBogeyPointsB(View view) {
        if (mscoreTeamB >= 20) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (mscoreTeamB == 19) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            mscoreTeamB = mscoreTeamB + 2;
            displayForTeamB(mscoreTeamB);
        }
    }

    /**
     * Increase the score for team B by 3 points.
     */

    public void tripleBogeyPointsB(View view) {
        if (mscoreTeamB >= 20) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (mscoreTeamB == 19) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (mscoreTeamB == 18) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            mscoreTeamB = mscoreTeamB + 3;
            displayForTeamB(mscoreTeamB);
        }
    }

    /**
     * Resets Score for Team A and Team B.
     */

    public void resetScore(View view) {
        mscoreTeamA = 0;
        mscoreTeamB = 0;
        displayForTeamA(mscoreTeamA);
        displayForTeamB(mscoreTeamB);
        ImageView resetAvatarA = (ImageView) findViewById(R.id.team_a_avatar);
        resetAvatarA.setImageResource(R.drawable.team_a);
        ImageView resetAvatarB = (ImageView) findViewById(R.id.team_b_avatar);
        resetAvatarB.setImageResource(R.drawable.team_b);
        final MediaPlayer ring = MediaPlayer.create(this, R.raw.reset);
        ring.start();
    }

    /**
     * Display a pop up windows with the scoring rules.
     */

    public void scoringRules(View view) {

    }

    /**
     * Review the score.
     */
    public void totalScoreTeam(View view) {
        if (mscoreTeamA < mscoreTeamB) {
            Toast.makeText(this, getString(R.string.winner_team_a), Toast.LENGTH_LONG).show();
            ImageView winnerTeam = (ImageView) findViewById(R.id.team_a_avatar);
            winnerTeam.setImageResource(R.drawable.winner);
            ImageView loserTeam = (ImageView) findViewById(R.id.team_b_avatar);
            loserTeam.setImageResource(R.drawable.loser);
            final MediaPlayer ring = MediaPlayer.create(this, R.raw.tada);
            ring.start();
        } else if (mscoreTeamA == mscoreTeamB) {
            Toast.makeText(this, getString(R.string.even), Toast.LENGTH_LONG).show();
            final MediaPlayer ring = MediaPlayer.create(this, R.raw.even);
            ring.start();
        } else {
            Toast.makeText(this, getString(R.string.winner_team_b), Toast.LENGTH_SHORT).show();
            ImageView winnerTeam = (ImageView) findViewById(R.id.team_b_avatar);
            winnerTeam.setImageResource(R.drawable.winner);
            ImageView loserTeam = (ImageView) findViewById(R.id.team_a_avatar);
            loserTeam.setImageResource(R.drawable.loser);
            final MediaPlayer ring = MediaPlayer.create(this, R.raw.tada);
            ring.start();
        }
    }
}