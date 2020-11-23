package com.shvants.balinatestapp.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.shvants.balinatestapp.R
import com.shvants.balinatestapp.data.repository.MapImage
import com.shvants.balinatestapp.databinding.FragmentMapBinding
import com.shvants.balinatestapp.domain.mvp.contract.MapContract
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.util.*

private const val DEFAULT_ZOOM = 10f

class MapFragment : Fragment(), MapContract.View, OnMapReadyCallback, KoinComponent {

    private val presenter: MapContract.Presenter by inject()
    private val binding: FragmentMapBinding by viewBinding()
    private var googleMapsFragment = SupportMapFragment()

    private lateinit var images: List<MapImage>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        presenter.attachView(this)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        presenter.loadAllImagesFromDb(Locale("ru"))
        childFragmentManager.beginTransaction().replace(R.id.map, googleMapsFragment).commit()

    }

    override fun onMapReady(googleMap: GoogleMap) {
        with(googleMap) {
            images.forEachIndexed { index, image ->
                val location = LatLng(image.lat, image.lng)
                addMarker(MarkerOptions().position(location).title(image.title))

                if (index == images.lastIndex) googleMap.moveCamera(
                    CameraUpdateFactory.newLatLngZoom(
                        location,
                        DEFAULT_ZOOM
                    )
                )
            }
        }
    }

    override fun getAllImagesFromDb(list: List<MapImage>) {
        images = list
        googleMapsFragment.getMapAsync(this)
    }

    companion object {
        private val instance = MapFragment()

        val INSTANCE: MapFragment
            get() = instance
    }
}