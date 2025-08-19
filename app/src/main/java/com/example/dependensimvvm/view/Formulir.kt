package com.example.dependensimvvm.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.dependensimvvm.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(pilihanJK: List<String> , onSubmitBtnClick: () -> Unit) {
    var txtNama by rememberSaveable { mutableStateOf("") }
    var txtAlamat by remember { mutableStateOf("") }
    var txtGender by remember { mutableStateOf("") }
    val listData: MutableList<String> = mutableListOf(txtNama,txtGender,txtAlamat)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.tampilan_data), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = colorResource(id = R.color.teal_700))
            )
        }
    ) { paddingValues ->
        IsiRuang(
            paddingValues = paddingValues,
            namaLengkap = txtNama,
            onNamaLengkapChange = { txtNama = it },
            alamat = txtAlamat,
            onAlamatChange = { txtAlamat = it },
            jenisK = pilihanJK,
            jenisKelamin = txtGender,
            onJenisKelaminSelected = { txtGender = it },
            onSubmitBtnClick = { onSubmitBtnClick(txtNama, txtAlamat, txtGender) }
        )
    }
}

@Composable
fun IsiRuang(
    paddingValues: PaddingValues,
    namaLengkap: String,
    onNamaLengkapChange: (String) -> Unit,
    alamat: String,
    onAlamatChange: (String) -> Unit,
    jenisK: List<String>,
    jenisKelamin: String,
    onJenisKelaminSelected: (String) -> Unit,
    onSubmitBtnClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = namaLengkap,
            onValueChange = onNamaLengkapChange,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Nama Lengkap") }
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Jenis Kelamin:", modifier = Modifier.weight(1f))
            jenisK.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    RadioButton(
                        selected = jenisKelamin == item,
                        onClick = { onJenisKelaminSelected(item) }
                    )
                    Text(text = item)
                }
            }
        }

        OutlinedTextField(
            value = alamat,
            onValueChange = onAlamatChange,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Alamat") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = onSubmitBtnClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.submit))
        }
    }
}
