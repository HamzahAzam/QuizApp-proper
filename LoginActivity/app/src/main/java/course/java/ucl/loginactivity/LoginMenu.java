package course.java.ucl.loginactivity;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

    /**
     * A placeholder fragment containing a simple view.
     */
    public  class LoginMenu extends Fragment {


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

           final EditText et_Username, et_Password, et_Email;

            View rootView = inflater.inflate(R.layout.login_fragment,
                    container, false);

            Button b2 = (Button) rootView.findViewById(R.id.btn_login_quit);
            Button btn = (Button) rootView.findViewById(R.id.btn_login_login);
            et_Username = (EditText)rootView.findViewById(R.id.et_login_Username);

            et_Password = (EditText)rootView.findViewById(R.id.et_login_Password);

            final DBHandler db = new DBHandler(getActivity());


            btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String username = String.valueOf(et_Username.getText());
                        // Stores Password

                       String password = String.valueOf(et_Password.getText());
                        // Validates the User name and Password for admin, admin
                       User retrievedUser = db.getUser(username);
                        if(retrievedUser!=null) {
                            String storedPassword = retrievedUser.getPassword();
                            if (storedPassword!=null) {
                              if (password.equals(storedPassword)) {
                                  Bundle bundle = getArguments();
                                  if (bundle != null) {
                                      int loggedValue = 1;
                                      bundle.putInt("loggedin",loggedValue);
                                  }
                                  Toast.makeText(getActivity(),
                                          "Redirecting...", Toast.LENGTH_SHORT).show();
                                  FragmentManager manager = getFragmentManager();
                                  getActivity().getSupportFragmentManager().popBackStack();
                                  Fragment fragment = new SimpleFrag();
                                  fragment.setArguments(bundle);
                                  manager.beginTransaction().replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();
                              }
                           }
                        }
                    }
                });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().getSupportFragmentManager().popBackStack();
                    getActivity().finish();
                }
            });
            return rootView;
        }

    }

