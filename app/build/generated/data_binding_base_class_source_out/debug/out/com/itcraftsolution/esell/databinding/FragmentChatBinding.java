// Generated by view binder compiler. Do not edit!
package com.itcraftsolution.esell.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.itcraftsolution.esell.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentChatBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView igBackToHome;

  @NonNull
  public final RecyclerView rvChatBuying;

  @NonNull
  public final TextView textView8;

  private FragmentChatBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView igBackToHome,
      @NonNull RecyclerView rvChatBuying, @NonNull TextView textView8) {
    this.rootView = rootView;
    this.igBackToHome = igBackToHome;
    this.rvChatBuying = rvChatBuying;
    this.textView8 = textView8;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentChatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_chat, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentChatBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.igBackToHome;
      ImageView igBackToHome = ViewBindings.findChildViewById(rootView, id);
      if (igBackToHome == null) {
        break missingId;
      }

      id = R.id.rvChatBuying;
      RecyclerView rvChatBuying = ViewBindings.findChildViewById(rootView, id);
      if (rvChatBuying == null) {
        break missingId;
      }

      id = R.id.textView8;
      TextView textView8 = ViewBindings.findChildViewById(rootView, id);
      if (textView8 == null) {
        break missingId;
      }

      return new FragmentChatBinding((ConstraintLayout) rootView, igBackToHome, rvChatBuying,
          textView8);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
