package com.shvants.balinatestapp.presentation.fragment

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.shvants.balinatestapp.R
import com.shvants.balinatestapp.data.repository.PhotoImage
import com.shvants.balinatestapp.databinding.FragmentPhotosBinding
import com.shvants.balinatestapp.domain.adapter.ImageAdapter
import com.shvants.balinatestapp.domain.mvp.contract.PhotosContract
import com.shvants.balinatestapp.util.convertToString
import com.shvants.network.data.entity.ImageDtoIn
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

class PhotosFragment private constructor() : Fragment(), PhotosContract.View, KoinComponent {

    private val presenter: PhotosContract.Presenter by inject()
    private val binding: FragmentPhotosBinding by viewBinding()

    private val imageAdapter = ImageAdapter()
    private val page = AtomicInteger(0)

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locale: Locale

    private var coordinate = Pair(0.0, 0.0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        locale = requireActivity().resources.configuration.locales[0]
        presenter.attachView(this)
        presenter.loadImages(page.incrementAndGet(), locale)

        binding.bindView()
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
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as? Bitmap

            imageBitmap?.let {
                val image = ImageDtoIn(
                    base64Image = imageBitmap.convertToString(),
                    date = (System.currentTimeMillis() / 1000).toInt(),
                    lat = coordinate.first,
                    lng = coordinate.second
                )
                presenter.saveImage(image, page.get(), locale)
            }
        }
    }

    override fun onDestroyView() {
        presenter.detachView()

        super.onDestroyView()
    }

    override fun setImages(list: List<PhotoImage>) {
        imageAdapter.setPhotos(list)
    }

    override fun addImage(image: PhotoImage) {
        imageAdapter.addImage(image)
    }

    private fun FragmentPhotosBinding.bindView() {
        with(recyclerview) {
            adapter = imageAdapter
            layoutManager = GridLayoutManager(requireContext(), 3)
            setHasFixedSize(true)
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    val manager = layoutManager as GridLayoutManager
                    val lastItem = manager.findLastCompletelyVisibleItemPosition()
                    val totalCount = manager.itemCount

                    if (totalCount <= lastItem + 3 && presenter.hasMore) presenter.loadImages(
                        page.incrementAndGet(),
                        locale
                    )
                }
            })
        }

        addFoto.setOnClickListener {
            when {
                hasCameraPermission() -> addLocationListener()
                shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION) -> {
                    //todo make info message
                }
                else -> requestPermissions(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), 1)
            }

            makeFoto()
        }
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

    private fun hasCameraPermission() = ContextCompat.checkSelfPermission(
        requireContext(),
        Manifest.permission.CAMERA
    ) == PackageManager.PERMISSION_GRANTED


    companion object {
        private val instance = PhotosFragment()

        val INSTANCE: PhotosFragment
            get() = instance
    }
}