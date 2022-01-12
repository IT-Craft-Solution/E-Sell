// Generated by view binder compiler. Do not edit!
package com.itcraftsolution.esell.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.itcraftsolution.esell.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentChatBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TabLayout tbMainChat;

  @NonNull
  public final ViewPager vpMainChat;

  private FragmentChatBinding(@NonNull ConstraintLayout rootView, @NonNull TabLayout tbMainChat,
      @NonNull ViewPager vpMainChat) {
    this.rootView = rootView;
    this.tbMainChat = tbMainChat;
    this.vpMainChat = vpMainChat;
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
      id = R.id.tbMainChat;
      TabLayout tbMainChat = ViewBindings.findChildViewById(rootView, id);
      if (tbMainChat == null) {
        break missingId;
      }

      id = R.id.vpMainChat;
      ViewPager vpMainChat = ViewBindings.findChildViewById(rootView, id);
      if (vpMainChat == null) {
        break missingId;
      }

      return new FragmentChatBinding((ConstraintLayout) rootView, tbMainChat, vpMainChat);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
