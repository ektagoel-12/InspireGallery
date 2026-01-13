package com.example.imagelistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.imagelistapp.model.ImageItem
import com.example.imagelistapp.utils.JsonUtils

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ImageListScreen()
                }
            }
        }
    }
}

@Composable
fun ImageListScreen() {
    val context = LocalContext.current

    // Load JSON data
    val imageResponse = JsonUtils.loadImagesFromJson(context)
    val images = imageResponse.images

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(images) { image ->
            ImageItemView(image)
        }
    }
}

@Composable
fun ImageItemView(image: ImageItem) {
    AsyncImage(
        model = image.url,
        contentDescription = "Image",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}
