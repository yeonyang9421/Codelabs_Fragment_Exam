package kr.co.woobi.imyeon.codelabs_fragment_exam;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private boolean isFragmentDisplayed=false;
    static final String STATE_FRAGMENT = "state_of_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton=findViewById(R.id.button_open);

        if(savedInstanceState !=null){
            isFragmentDisplayed=savedInstanceState.getBoolean(STATE_FRAGMENT);
            if(isFragmentDisplayed){
                mButton.setText(R.string.close);
            }
        }

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isFragmentDisplayed){
                    displayFragment();
                }else{
                    closeFragment();
                }
            }
        });
    }

    public void displayFragment(){
        SimpleFragment simpleFragment=SimpleFragment.newInstance();

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container,simpleFragment).addToBackStack(null).commit();
        mButton.setText(R.string.close);
        isFragmentDisplayed=true;
    }

    public void closeFragment(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        SimpleFragment simpleFragment= (SimpleFragment) fragmentManager.findFragmentById(R.id.fragment_container);
        if(simpleFragment !=null){
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.remove(simpleFragment).commit();
        }
        mButton.setText(R.string.open);
        isFragmentDisplayed=false;
    }

    public void onSaveInstanceState(Bundle savednstanceState) {
        savednstanceState.putBoolean(STATE_FRAGMENT, isFragmentDisplayed);
        super.onSaveInstanceState(savednstanceState);
    }
}
