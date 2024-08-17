package com.superapp.catanddogsdk

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.superapp.catanddogsdk.common.Resource
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class ComposeActivity : AppCompatActivity() {

    private val dogViewModel: DogViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }

    @Composable
    fun MainContent() {
        val dogResource by dogViewModel.dog.collectAsState()

        when (dogResource) {
            is Resource.Loading -> Text(text = "Loading...")
            is Resource.Success<*> -> Text(text = "Dog name: ${(dogResource as Resource.Success).data.url}")
            is Resource.Error -> Text(text = "Error: ${(dogResource as Resource.Error).throwable.message}")
        }
    }
}