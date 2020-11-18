package com.shvants.balinatestapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.shvants.balinatestapp.R

class MapFragment : Fragment(), OnMapReadyCallback {

    //    private val binding: FragmentMapBinding by viewBinding()
    private lateinit var googleMapsFragment: SupportMapFragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        googleMapsFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.map)
//                as SupportMapFragment
//
//        googleMapsFragment.getMapAsync(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val mapFragment =
//            requireActivity().supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

    }

    override fun onMapReady(googleMap: GoogleMap) {
//        val testLocation = LatLng(55.0, 23.0)
//        googleMap.addMarker(MarkerOptions().position(testLocation).title("Test location"))
//        googleMap.moveCamera(CameraUpdateFactory.newLatLng(testLocation))
    }

    companion object {
        private val instance = MapFragment()

        val INSTANCE: MapFragment
            get() = instance
    }
}