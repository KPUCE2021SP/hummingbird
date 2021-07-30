// Generated by view binder compiler. Do not edit!
package com.github.peep.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.utils.widget.ImageFilterButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.github.peep.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageFilterButton commitExpInfoBtn;

  @NonNull
  public final ProgressBar commitExpProgressbar;

  @NonNull
  public final ConstraintLayout homeFragment;

  @NonNull
  public final ImageButton peepCollectionBtn;

  @NonNull
  public final ImageView peepHomeImageview;

  @NonNull
  public final ImageButton renewBtn;

  @NonNull
  public final ImageButton settingBtn;

  @NonNull
  public final TextView todayCommitCountTextview;

  @NonNull
  public final TextView todayCommitTextview;

  private FragmentHomeBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageFilterButton commitExpInfoBtn, @NonNull ProgressBar commitExpProgressbar,
      @NonNull ConstraintLayout homeFragment, @NonNull ImageButton peepCollectionBtn,
      @NonNull ImageView peepHomeImageview, @NonNull ImageButton renewBtn,
      @NonNull ImageButton settingBtn, @NonNull TextView todayCommitCountTextview,
      @NonNull TextView todayCommitTextview) {
    this.rootView = rootView;
    this.commitExpInfoBtn = commitExpInfoBtn;
    this.commitExpProgressbar = commitExpProgressbar;
    this.homeFragment = homeFragment;
    this.peepCollectionBtn = peepCollectionBtn;
    this.peepHomeImageview = peepHomeImageview;
    this.renewBtn = renewBtn;
    this.settingBtn = settingBtn;
    this.todayCommitCountTextview = todayCommitCountTextview;
    this.todayCommitTextview = todayCommitTextview;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.commit_exp_info_btn;
      ImageFilterButton commitExpInfoBtn = rootView.findViewById(id);
      if (commitExpInfoBtn == null) {
        break missingId;
      }

      id = R.id.commit_exp_progressbar;
      ProgressBar commitExpProgressbar = rootView.findViewById(id);
      if (commitExpProgressbar == null) {
        break missingId;
      }

      ConstraintLayout homeFragment = (ConstraintLayout) rootView;

      id = R.id.peep_collection_btn;
      ImageButton peepCollectionBtn = rootView.findViewById(id);
      if (peepCollectionBtn == null) {
        break missingId;
      }

      id = R.id.peep_home_imageview;
      ImageView peepHomeImageview = rootView.findViewById(id);
      if (peepHomeImageview == null) {
        break missingId;
      }

      id = R.id.renew_btn;
      ImageButton renewBtn = rootView.findViewById(id);
      if (renewBtn == null) {
        break missingId;
      }

      id = R.id.setting_btn;
      ImageButton settingBtn = rootView.findViewById(id);
      if (settingBtn == null) {
        break missingId;
      }

      id = R.id.today_commit_count_textview;
      TextView todayCommitCountTextview = rootView.findViewById(id);
      if (todayCommitCountTextview == null) {
        break missingId;
      }

      id = R.id.today_commit_textview;
      TextView todayCommitTextview = rootView.findViewById(id);
      if (todayCommitTextview == null) {
        break missingId;
      }

      return new FragmentHomeBinding((ConstraintLayout) rootView, commitExpInfoBtn,
          commitExpProgressbar, homeFragment, peepCollectionBtn, peepHomeImageview, renewBtn,
          settingBtn, todayCommitCountTextview, todayCommitTextview);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}