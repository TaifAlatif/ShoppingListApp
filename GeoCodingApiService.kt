interface GeoCodingApiService {


    @GET("maps/api/geocode/json")
    suspend fun getAddressFromCoordinates(
        @Query("latlng") latlng: String,
        @Query("Key") apiKey: String
    ): GeocodingResponse
}
