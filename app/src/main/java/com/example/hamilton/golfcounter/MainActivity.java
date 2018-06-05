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

public class MainActivity extends AppCompatActivity {
    Button showPopupBtn, closePopupBtn;
    PopupWindow PopupWindow;
    RelativeLayout relativeLayout1;
    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        if (scoreTeamA <= (-20)) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (scoreTeamA == (-19)) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (scoreTeamA == (-18)) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (scoreTeamA == (-17)) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            scoreTeamA = scoreTeamA - 4;
            displayForTeamA(scoreTeamA);
        }
    }

    /**
     * Decrease the score for team A by 3 points.
     */
    public void doubleEaglePointsA(View view) {
        if (scoreTeamA <= (-20)) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (scoreTeamA == (-19)) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (scoreTeamA == (-18)) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            scoreTeamA = scoreTeamA - 3;
            displayForTeamA(scoreTeamA);
        }
    }

    /**
     * Decrease the score for team A by 2 points.
     */

    public void eaglePointsA(View view) {
        if (scoreTeamA <= (-20)) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (scoreTeamA == (-19)) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            scoreTeamA = scoreTeamA - 2;
            displayForTeamA(scoreTeamA);
        }
    }

    /**
     * Decrease the score for team A by 1 points.
     */

    public void birdiePointsA(View view) {
        if (scoreTeamA <= (-20)) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            scoreTeamA = scoreTeamA - 1;
            displayForTeamA(scoreTeamA);
        }
    }

    /**
     * Increase the score for team A by 1 points.
     */

    public void bogeyPointsA(View view) {
        if (scoreTeamA >= 20) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            scoreTeamA = scoreTeamA + 1;
            displayForTeamA(scoreTeamA);
        }
    }

    /**
     * Increase the score for team A by 2 points.
     */

    public void doubleBogeyPointsA(View view) {
        if (scoreTeamA >= 20) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (scoreTeamA == 19) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            scoreTeamA = scoreTeamA + 2;
            displayForTeamA(scoreTeamA);
        }
    }

    /**
     * Increase the score for team A by 3 points.
     */

    public void tripleBogeyPointsA(View view) {
        if (scoreTeamA >= 20) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (scoreTeamA == 19) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (scoreTeamA == 18) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            scoreTeamA = scoreTeamA + 3;
            displayForTeamA(scoreTeamA);
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
        if (scoreTeamB <= (-20)) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (scoreTeamB == 19) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (scoreTeamB == 18) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (scoreTeamB == 17) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            scoreTeamB = scoreTeamB - 4;
            displayForTeamB(scoreTeamB);
        }
    }

    /**
     * Decrease the score for team B by 3 points.
     */

    public void doubleEaglePointsB(View view) {
        if (scoreTeamB <= (-20)) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (scoreTeamB == (-19)) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (scoreTeamB == (-18)) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            scoreTeamB = scoreTeamB - 3;
            displayForTeamB(scoreTeamB);
        }
    }

    /**
     * Decrease the score for team B by 2 points.
     */

    public void eaglePointsB(View view) {
        if (scoreTeamB <= (-20)) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (scoreTeamB == (-19)) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            scoreTeamB = scoreTeamB - 2;
            displayForTeamB(scoreTeamB);
        }
    }

    /**
     * Decrease the score for team B by 1 points.
     */

    public void birdiePointsB(View view) {
        if (scoreTeamB <= (-20)) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            scoreTeamB = scoreTeamB - 1;
            displayForTeamB(scoreTeamB);
        }
    }

    /**
     * Increase the score for team B by 1 points.
     */

    public void bogeyPointsB(View view) {
        if (scoreTeamB >= 20) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            scoreTeamB = scoreTeamB + 1;
            displayForTeamB(scoreTeamB);
        }
    }

    /**
     * Increase the score for team B by 2 points.
     */

    public void doubleBogeyPointsB(View view) {
        if (scoreTeamB >= 20) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (scoreTeamB == 19) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            scoreTeamB = scoreTeamB + 2;
            displayForTeamB(scoreTeamB);
        }
    }

    /**
     * Increase the score for team B by 3 points.
     */

    public void tripleBogeyPointsB(View view) {
        if (scoreTeamB >= 20) {
            //Show an error message as a toast
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (scoreTeamB == 19) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else if (scoreTeamB == 18) {
            Toast.makeText(this, getString(R.string.exceeded), Toast.LENGTH_LONG).show();
        } else {
            scoreTeamB = scoreTeamB + 3;
            displayForTeamB(scoreTeamB);
        }
    }

    /**
     * Resets Score for Team A and Team B.
     */

    public void resetScore(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
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
        if (scoreTeamA < scoreTeamB) {
            Toast.makeText(this, getString(R.string.winner_team_a), Toast.LENGTH_LONG).show();
            ImageView winnerTeam = (ImageView) findViewById(R.id.team_a_avatar);
            winnerTeam.setImageResource(R.drawable.winner);
            ImageView loserTeam = (ImageView) findViewById(R.id.team_b_avatar);
            loserTeam.setImageResource(R.drawable.loser);
            final MediaPlayer ring = MediaPlayer.create(this, R.raw.tada);
            ring.start();
        } else if (scoreTeamA == scoreTeamB) {
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
