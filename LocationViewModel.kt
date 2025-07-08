class LocationViewModel: ViewModel() {
    private val _location = mutableStateOf<LocationData?>(null)
    val location : State<LocationData?> = _location

    private val _address = mutableStateOf(listOf<GeoCodingResult>())
    val address: State<List<GeoCodingResult>> = _address

    fun updateLocation(newLocation : LocationData){
        _location.value = newLocation
    }

    fun fetchAddress(latlng: String){
        try{
            viewModelScope.launch {
                val result = RetrofitClient.create().getAddressFromCoordinates(
                    latlng,
                    ""
                )
                _address.value = result.results
            }

        }catch(e:Exception){
            Log.d("res1", "${e.cause} ${e.message}")
        }

    }
}
