// Generated by view binder compiler. Do not edit!
package com.itcraftsolution.esell.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.itcraftsolution.esell.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentPhoneLoginBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnPhoneNumLogin;

  @NonNull
  public final EditText etEnterCountryCode;

  @NonNull
  public final EditText etEnterPhoneNumber;

  @NonNull
  public final ImageView ivAvatarLogin;

  @NonNull
  public final ImageView ivphoneDetailsBackArrow;

  @NonNull
  public final TextView tvDetails;

  @NonNull
  public final TextView tvEnterPhone;

  @NonNull
  public final TextView tvEnterPhoneLogin;

  private FragmentPhoneLoginBinding(@NonNull LinearLayout rootView,
      @NonNull Button btnPhoneNumLogin, @NonNull EditText etEnterCountryCode,
      @NonNull EditText etEnterPhoneNumber, @NonNull ImageView ivAvatarLogin,
      @NonNull ImageView ivphoneDetailsBackArrow, @NonNull TextView tvDetails,
      @NonNull TextView tvEnterPhone, @NonNull TextView tvEnterPhoneLogin) {
    this.rootView = rootView;
    this.btnPhoneNumLogin = btnPhoneNumLogin;
    this.etEnterCountryCode = etEnterCountryCode;
    this.etEnterPhoneNumber = etEnterPhoneNumber;
    this.ivAvatarLogin = ivAvatarLogin;
    this.ivphoneDetailsBackArrow = ivphoneDetailsBackArrow;
    this.tvDetails = tvDetails;
    this.tvEnterPhone = tvEnterPhone;
    this.tvEnterPhoneLogin = tvEnterPhoneLogin;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentPhoneLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentPhoneLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_phone_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentPhoneLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnPhoneNumLogin;
      Button btnPhoneNumLogin = ViewBindings.findChildViewById(rootView, id);
      if (btnPhoneNumLogin == null) {
        break missingId;
      }

      id = R.id.etEnterCountryCode;
      EditText etEnterCountryCode = ViewBindings.findChildViewById(rootView, id);
      if (etEnterCountryCode == null) {
        break missingId;
      }

      id = R.id.etEnterPhoneNumber;
      EditText etEnterPhoneNumber = ViewBindings.findChildViewById(rootView, id);
      if (etEnterPhoneNumber == null) {
        break missingId;
      }

      id = R.id.ivAvatarLogin;
      ImageView ivAvatarLogin = ViewBindings.findChildViewById(rootView, id);
      if (ivAvatarLogin == null) {
        break missingId;
      }

      id = R.id.ivphoneDetailsBackArrow;
      ImageView ivphoneDetailsBackArrow = ViewBindings.findChildViewById(rootView, id);
      if (ivphoneDetailsBackArrow == null) {
        break missingId;
      }

      id = R.id.tvDetails;
      TextView tvDetails = ViewBindings.findChildViewById(rootView, id);
      if (tvDetails == null) {
        break missingId;
      }

      id = R.id.tvEnterPhone;
      TextView tvEnterPhone = ViewBindings.findChildViewById(rootView, id);
      if (tvEnterPhone == null) {
        break missingId;
      }

      id = R.id.tvEnterPhoneLogin;
      TextView tvEnterPhoneLogin = ViewBindings.findChildViewById(rootView, id);
      if (tvEnterPhoneLogin == null) {
        break missingId;
      }

      return new FragmentPhoneLoginBinding((LinearLayout) rootView, btnPhoneNumLogin,
          etEnterCountryCode, etEnterPhoneNumber, ivAvatarLogin, ivphoneDetailsBackArrow, tvDetails,
          tvEnterPhone, tvEnterPhoneLogin);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}