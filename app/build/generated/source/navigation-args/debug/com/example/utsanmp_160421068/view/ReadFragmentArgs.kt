package com.example.utsanmp_160421068.view

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class ReadFragmentArgs(
  public val idNews: Int,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("id_news", this.idNews)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("id_news", this.idNews)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): ReadFragmentArgs {
      bundle.setClassLoader(ReadFragmentArgs::class.java.classLoader)
      val __idNews : Int
      if (bundle.containsKey("id_news")) {
        __idNews = bundle.getInt("id_news")
      } else {
        throw IllegalArgumentException("Required argument \"id_news\" is missing and does not have an android:defaultValue")
      }
      return ReadFragmentArgs(__idNews)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): ReadFragmentArgs {
      val __idNews : Int?
      if (savedStateHandle.contains("id_news")) {
        __idNews = savedStateHandle["id_news"]
        if (__idNews == null) {
          throw IllegalArgumentException("Argument \"id_news\" of type integer does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"id_news\" is missing and does not have an android:defaultValue")
      }
      return ReadFragmentArgs(__idNews)
    }
  }
}
