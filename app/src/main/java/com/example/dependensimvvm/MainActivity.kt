package com.example.dependensimvvm
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import com.example.dependensimvvm.ui.theme.DependensiMVVMTheme
import com.example.dependensimvvm.uicontroller.DataApp

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DependensiMVVMTheme  {
                Scaffold { DataApp() }
            }
        }
    }
}