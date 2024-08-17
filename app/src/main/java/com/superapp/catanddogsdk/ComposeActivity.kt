package com.superapp.catanddogsdk

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.superapp.catanddogsdk.common.Resource
import com.superapp.catdogsdk.model.Cat
import com.superapp.catdogsdk.model.Duck
import com.superapp.catdogsdk.model.Fox
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ComposeActivity : AppCompatActivity() {

    private val animalViewModel: AnimalViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }

    @Composable
    fun MainContent() {
        val dog by animalViewModel.dog.collectAsState()
        val fox by animalViewModel.fox.collectAsState()
        val duck by animalViewModel.duck.collectAsState()
        val cat by animalViewModel.cat.collectAsState()


        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 24.dp)
        ) {
            item {
                when (dog) {
                    is Resource.Loading -> Text(text = "Loading...")
                    is Resource.Success<*> -> AnimalCard(url = (dog as Resource.Success).data.url)
                    is Resource.Error -> Text(text = "Error: ${(dog as Resource.Error).throwable.message}")
                }
            }
            item {
                when (fox) {
                    is Resource.Loading -> {
                        // Display a loading indicator
                    }

                    is Resource.Error -> {
                        // Display an error message
                    }

                    is Resource.Success -> {
                        AnimalCard(url = (fox as Resource.Success<Fox>).data.image)
                    }
                }
            }
            item {
                when (duck) {
                    is Resource.Loading -> {
                        // Display a loading indicator
                    }

                    is Resource.Error -> {
                        // Display an error message
                    }

                    is Resource.Success -> {
                        AnimalCard(url = (duck as Resource.Success<Duck>).data.url)
                    }
                }
            }
            item {
                when (cat) {
                    is Resource.Loading -> {
                        // Display a loading indicator
                    }

                    is Resource.Error -> {
                        // Display an error message
                    }

                    is Resource.Success -> {
                        AnimalCard(url = (cat as Resource.Success<Cat>).data.url)
                    }
                }
            }
        }
    }

    @Composable
    fun AnimalCard(url: String) {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(url)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Animal Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }


}