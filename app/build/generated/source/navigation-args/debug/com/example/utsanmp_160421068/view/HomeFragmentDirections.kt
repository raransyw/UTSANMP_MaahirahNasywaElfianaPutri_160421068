package com.example.utsanmp_160421068.view

import android.os.Bundle
import androidx.navigation.NavDirections
import com.example.utsanmp_160421068.R
import kotlin.Int

public class HomeFragmentDirections private constructor() {
  private data class ActionHomeFragmentToReadFragment(
    public val idNews: Int,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_homeFragment_to_readFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("id_news", this.idNews)
        return result
      }
  }

  public companion object {
    public fun actionHomeFragmentToReadFragment(idNews: Int): NavDirections =
        ActionHomeFragmentToReadFragment(idNews)
  }
}
