@Composable
fun LocationSelectionScreeen(
    location: LocationData,
    onLocationSelected: (LocationData) -> Unit
){
    val userLocation = remember { mutableStateOf(LatLng(location.latitude, location.longitude)) }

    var cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(userLocation.value, 10f)

    }


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        GoogleMap(
            modifier = Modifier
                .weight(1f)
                .padding(top = 16.dp),
            cameraPositionState = cameraPositionState,
            onMapClick = {
                userLocation.value = it
            }
        ) {
            Marker(state = MarkerState(position = userLocation.value))
        }

        var newLocation: LocationData


        Button(onClick = {
            newLocation = LocationData(userLocation.value.latitude, userLocation.value.longitude)
            onLocationSelected(newLocation)
        }) {
            Text(" Set Location")

        }

    }
}
