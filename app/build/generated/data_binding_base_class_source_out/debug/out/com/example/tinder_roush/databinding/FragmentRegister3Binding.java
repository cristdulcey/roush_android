// Generated by view binder compiler. Do not edit!
package com.example.tinder_roush.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.tinder_roush.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentRegister3Binding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button backR3Button;

  @NonNull
  public final LinearLayout linearlayoutButtonForm3;

  @NonNull
  public final LinearLayout linearlayoutForm1;

  @NonNull
  public final Button nextR3Button;

  @NonNull
  public final LinearLayout register3;

  private FragmentRegister3Binding(@NonNull LinearLayout rootView, @NonNull Button backR3Button,
      @NonNull LinearLayout linearlayoutButtonForm3, @NonNull LinearLayout linearlayoutForm1,
      @NonNull Button nextR3Button, @NonNull LinearLayout register3) {
    this.rootView = rootView;
    this.backR3Button = backR3Button;
    this.linearlayoutButtonForm3 = linearlayoutButtonForm3;
    this.linearlayoutForm1 = linearlayoutForm1;
    this.nextR3Button = nextR3Button;
    this.register3 = register3;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentRegister3Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentRegister3Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_register_3, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentRegister3Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.back_r3_button;
      Button backR3Button = ViewBindings.findChildViewById(rootView, id);
      if (backR3Button == null) {
        break missingId;
      }

      id = R.id.linearlayout_button_form3;
      LinearLayout linearlayoutButtonForm3 = ViewBindings.findChildViewById(rootView, id);
      if (linearlayoutButtonForm3 == null) {
        break missingId;
      }

      id = R.id.linearlayout_form1;
      LinearLayout linearlayoutForm1 = ViewBindings.findChildViewById(rootView, id);
      if (linearlayoutForm1 == null) {
        break missingId;
      }

      id = R.id.next_r3_button;
      Button nextR3Button = ViewBindings.findChildViewById(rootView, id);
      if (nextR3Button == null) {
        break missingId;
      }

      LinearLayout register3 = (LinearLayout) rootView;

      return new FragmentRegister3Binding((LinearLayout) rootView, backR3Button,
          linearlayoutButtonForm3, linearlayoutForm1, nextR3Button, register3);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
