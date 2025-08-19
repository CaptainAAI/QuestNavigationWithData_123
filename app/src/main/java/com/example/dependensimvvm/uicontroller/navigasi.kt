package com.example.dependensimvvm.uicontroller

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dependensimvvm.view.TampilData
import com.example.dependensimvvm.view.FormIsian
import com.example.dependensimvvm.viewmodel.SiswaViewModel

enum class Navigasi {
    Formulir,
    Detail
}

@Composable
fun DataApp(
    viewModel: SiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()

) {
    Scaffold { paddingValues ->
        val uiState = viewModel.statusUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
            composable(route = Navigasi.Formulir.name) {
                val Konteks = LocalContext.current
                FormIsian(
                    pilihanJK =JenisK.map{ id -> konteks.resources.getstring(id)},
                    onSubmitBtnClick = {
                        navController.navigate(route = Navigasi.Detail.name)
                    }
                )
            }
            composable(route = Navigasi.Detail.name) {
                TampilData(
                    statusUiSiswa = uiState.value,
                    onBackBtnClick = {
                        cancelAndBackToFormulir(navController)
                    }
                )
            }
        }
    }
}

private fun cancelAndBackToFormulir(navController: NavHostController) {
    navController.popBackStack(Navigasi.Formulir.name, inclusive = false)
}