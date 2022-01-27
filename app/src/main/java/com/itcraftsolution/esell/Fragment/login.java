package com.itcraftsolution.esell.Fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.itcraftsolution.esell.MainActivity;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentLoginBinding;

public class login extends Fragment {


    private GoogleSignInClient GoogleSignInClient;
    private FragmentLoginBinding binding;
    private ActivityResultLauncher<Intent> SignInActivityResultLauncher;
    private FirebaseAuth auth;
    private ProgressDialog progressDialog;

    public login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(getLayoutInflater());

        auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Login Account");
        progressDialog.setMessage("SignIn Account With Google");



        binding.btnContinueWithPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
                fragmentTransaction.replace(R.id.frUserDetailsContainer , new phoneLogin())
                        .addToBackStack(null).commit();
            }
        });

        CreateRequest();

        binding.btnContinueWithGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SignIn();
                progressDialog.show();
            }
        });

     SignInActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK)
                        {

                            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(result.getData());
                            try {
                                GoogleSignInAccount account = task.getResult(ApiException.class);
                                SignInWithGoogle(account);

                            } catch (ApiException e) {
                                e.printStackTrace();
                            }
                        }
                        else {
                            progressDialog.dismiss();
                        }
                    }
                });

        return binding.getRoot();
    }

    private void CreateRequest() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.FirebaseClientid))
                .requestEmail()
                .build();

        GoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso);
    }

    private void SignIn()
    {
        Intent intent = GoogleSignInClient.getSignInIntent();
        SignInActivityResultLauncher.launch(intent);

    }

    private void SignInWithGoogle(GoogleSignInAccount account) {

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken() , null);
        auth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    progressDialog.dismiss();
                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.remove(login.this);
                    fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
                    fragmentTransaction.replace(R.id.frUserDetailsContainer , new UserProfileFragment())
                            .addToBackStack(null).commit();
                }
                else {
                    progressDialog.dismiss();
                    Toast.makeText(getContext(), ""+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }






}