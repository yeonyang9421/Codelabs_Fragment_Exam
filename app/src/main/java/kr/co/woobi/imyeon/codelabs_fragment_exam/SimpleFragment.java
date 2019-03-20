package kr.co.woobi.imyeon.codelabs_fragment_exam;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class SimpleFragment extends Fragment {
    private static final int YES = 0;
    private static final int NO = 1;

    public SimpleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_simple, container, false);
        final RadioGroup radioGroup = rootView.findViewById(R.id.radio_group);
        final RatingBar ratingBar=rootView.findViewById(R.id.ratingbar);


       radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               View radioButton=radioGroup.findViewById(checkedId);
               int index=radioGroup.indexOfChild(radioButton);
               TextView textView  = rootView.findViewById(R.id.text_fragment_header);
               switch (index){
                   case YES:
                       textView.setText(R.string.yes_message);
                       break;
                   case NO:
                       textView.setText(R.string.no_message);
                       break;
                       default:
                           break;
               }
           }
       });

       ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
           @Override
           public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
               Toast.makeText(getContext(), "My Rating: "+ rating, Toast.LENGTH_SHORT).show();
           }
       });

        return rootView;

    }


    public static SimpleFragment newInstance(){
        return  new SimpleFragment();
    }
}
