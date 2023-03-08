package com.example.flag_emoji

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.example.flag_emoji.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

  private var _binding: FragmentFirstBinding? = null

  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    _binding = FragmentFirstBinding.inflate(inflater, container, false)
    return binding.root

  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.textviewFirst.doOnTextChanged { text, start, before, count ->
      val text = PhoneUtils.getFlagEmoji(text.toString())
      binding.textviewSecond.text = text
    }
  }

  override fun onResume() {
    super.onResume()
    binding.textviewFirst.requestFocus()
    binding.textviewFirst.setText("1")
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}