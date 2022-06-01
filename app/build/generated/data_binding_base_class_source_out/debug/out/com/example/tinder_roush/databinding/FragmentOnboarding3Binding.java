// Generated by view binder compiler. Do not edit!
package com.example.tinder_roush.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.tinder_roush.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentOnboarding3Binding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView onboarding3;

  @NonNull
  public final TextView title3;

  @NonNull
  public final TextView txt3;

  private FragmentOnboarding3Binding(@NonNull LinearLayout rootView, @NonNull ImageView onboarding3,
      @NonNull TextView title3, @NonNull TextView txt3) {
    this.rootView = rootView;
    this.onboarding3 = onboarding3;
    this.title3 = title3;
    this.txt3 = txt3;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentOnboarding3Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentOnboarding3Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_onboarding3, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentOnboarding3Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.onboarding_3;
      ImageView onboarding3 = ViewBindings.findChildViewById(rootView, id);
      if (onboarding3 == null) {
        break missingId;
      }

      id = R.id.title3;
      TextView title3 = ViewBindings.findChildViewById(rootView, id);
      if (title3 == null) {
        break missingId;
      }

      id = R.id.txt3;
      TextView txt3 = ViewBindings.findChildViewById(rootView, id);
      if (txt3 == null) {
        break missingId;
      }

      return new FragmentOnboarding3Binding((LinearLayout) rootView, onboarding3, title3, txt3);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
