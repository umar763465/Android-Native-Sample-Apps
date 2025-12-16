package com.example.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.implicitintent.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {
 Button button3;
 EditText url;
    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.open.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment)
        );
        button3 = view.findViewById(R.id.button3);
        url = view.findViewById(R.id.url);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urltext = url.getText().toString();

//                Implicit Intent to test Email Sending:-
                String[] addresses= {"john.archibald.campbell@example-pet-store.com"};
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL,addresses);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Implicit Intent Test");
                intent.putExtra(Intent.EXTRA_TEXT, urltext);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null){
                startActivity(intent);
                }
                else {
                    Toast.makeText(getActivity(), "No application can handle this request", Toast.LENGTH_SHORT).show();
                }


//                Implicit Intent to testing Opening URL:-
//                    Uri webpage = Uri.parse(urltext);
//                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
//                    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
//                        startActivity(intent);
//                        }
//                    else {
//                        Toast.makeText(getActivity(), "No application can handle this request", Toast.LENGTH_SHORT).show();
//                    }



            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}