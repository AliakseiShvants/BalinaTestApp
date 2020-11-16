package com.shvants.balinatestapp.presentation.fragment

import android.Manifest
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.shvants.balinatestapp.R
import com.shvants.balinatestapp.data.repository.Image
import com.shvants.balinatestapp.databinding.FragmentMainBinding
import com.shvants.balinatestapp.domain.mvp.contract.MainContract
import com.shvants.balinatestapp.util.convertToString
import com.shvants.network.data.entity.ImageDtoIn
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.util.concurrent.atomic.AtomicInteger

class MainFragment : Fragment(R.layout.fragment_main), MainContract.View, KoinComponent {

    private val presenter: MainContract.Presenter by inject()

    private val binding: FragmentMainBinding by viewBinding()

    private val page = AtomicInteger(0)
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var coordinate = Pair(0.0, 0.0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this)
//        presenter.loadImages(page.incrementAndGet(), Locale("ru"))

        with(binding.recyclerview) {
            layoutManager = GridLayoutManager(requireContext(), 3, RecyclerView.HORIZONTAL, false)
        }

        binding.addFoto.setOnClickListener {
            when {
                ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED -> addLocationListener()
                shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION) -> {
                    //todo make info message
                }
                else -> requestPermissions(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), 1)
            }

            makeFoto()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == 1
            && grantResults.isNotEmpty()
            && grantResults[0] == PackageManager.PERMISSION_GRANTED
        ) addLocationListener()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as? Bitmap

            imageBitmap?.let {
                val image = ImageDtoIn(
                    base64Image = imageBitmap.convertToString(),
                    date = System.currentTimeMillis().toInt(),
                    lat = coordinate.first,
                    lng = coordinate.second
                )
                presenter.saveImage(image)
            }
        }
    }

    override fun onDestroyView() {
        presenter.detachView()

        super.onDestroyView()
    }

    override fun setImages(list: List<Image>) {

    }

    private fun makeFoto() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, 1)
    }

    private fun addLocationListener() {
        fusedLocationClient.lastLocation.addOnSuccessListener {
            coordinate = Pair(it.latitude, it.longitude)
        }
    }
}