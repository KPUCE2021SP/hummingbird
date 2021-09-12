package codevinci.com.kotlinretrofitrestexample.util

import android.content.Context
import com.squareup.picasso.Picasso

public val Context.picasso: Picasso
    get() = Picasso.with(this)