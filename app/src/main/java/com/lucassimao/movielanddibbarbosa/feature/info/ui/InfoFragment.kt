package com.lucassimao.movielanddibbarbosa.feature.info.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lucassimao.movielanddibbarbosa.databinding.FragmentInfoBinding
import com.lucassimao.movielanddibbarbosa.feature.info.util.Constants.EMAIL
import com.lucassimao.movielanddibbarbosa.feature.info.util.Constants.INSTAGRAM_USERNAME
import com.lucassimao.movielanddibbarbosa.feature.info.util.Constants.LABEL
import com.lucassimao.movielanddibbarbosa.feature.info.util.Constants.LATITUDE
import com.lucassimao.movielanddibbarbosa.feature.info.util.Constants.LONGITUDE
import com.lucassimao.movielanddibbarbosa.feature.info.util.Constants.WEBSITE
import com.lucassimao.movielanddibbarbosa.feature.info.util.EmailSender
import com.lucassimao.movielanddibbarbosa.feature.info.util.InstagramProfileOpener
import com.lucassimao.movielanddibbarbosa.feature.info.util.LocationOpener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class InfoFragment : Fragment() {
    private lateinit var binding: FragmentInfoBinding

    @Inject
    lateinit var emailSender: EmailSender

    @Inject
    lateinit var instagramProfileOpener: InstagramProfileOpener

    @Inject
    lateinit var locationOpener: LocationOpener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivMapInfo.setOnClickListener {
            locationOpener.openLocationInMaps(LATITUDE, LONGITUDE, LABEL)
        }

        binding.tvInstagramInfo.setOnClickListener {
            instagramProfileOpener.openInstagramProfile(INSTAGRAM_USERNAME)
        }

        binding.tvEmailInfo.setOnClickListener {
            emailSender.sendEmailTo(EMAIL)
        }

        binding.tvWebInfo.setOnClickListener {
            openBrowser()
        }
    }

    private fun openBrowser() {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(WEBSITE))
        startActivity(browserIntent)
    }
}