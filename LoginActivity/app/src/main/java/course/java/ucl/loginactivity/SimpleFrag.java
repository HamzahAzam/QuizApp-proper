package course.java.ucl.loginactivity;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



    /**
     * A placeholder fragment containing a simple view.
     */
    public  class SimpleFrag extends Fragment {

        public SimpleFrag() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_simple,
                    container, false);

            Button exit = (Button) rootView.findViewById(R.id.btn_q_Exit);
           /* Button btn = (Button) rootView.findViewById(R.id.btnSimpleFrga);
            btn.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    Toast.makeText(getActivity(), "OOOHHH!!!", Toast.LENGTH_SHORT).show();
                }
            }); */

            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().finish();
                }
            });
            return rootView;
        }

    }

