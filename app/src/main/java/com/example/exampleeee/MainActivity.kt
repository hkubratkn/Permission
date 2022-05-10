package com.example.exampleeee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.exampleeee.ui.theme.ExampleeeeTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionRequired
import com.google.accompanist.permissions.rememberPermissionState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleeeeTheme {
                AskPer()
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun AskPer(){

    val cameraPermissionState = rememberPermissionState(android.Manifest.permission.READ_EXTERNAL_STORAGE)

    PermissionRequired(
        permissionState = cameraPermissionState,
        permissionNotGrantedContent = {
            Button(onClick = { cameraPermissionState.launchPermissionRequest() }) {
                Text(text="Enable camera permission")
            }
        },
        permissionNotAvailableContent = {
            Text(text="please enable camera functionalty from the settings")
        }
    ) {
        Text(text="granded permission, OK")
    }
}
