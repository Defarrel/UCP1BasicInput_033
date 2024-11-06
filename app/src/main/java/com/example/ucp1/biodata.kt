package com.example.ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun biodata(modifier: Modifier = Modifier){

    var Nama by remember { mutableStateOf("") }
    var NoTelepon by remember { mutableStateOf("") }
    var MemilihJK by remember { mutableStateOf("") }

    val JenisKelamin = listOf("Laki-laki", "Perempuan")

    var Namasv by remember { mutableStateOf("") }
    var NoTeleponsv by remember { mutableStateOf("") }
    var MemilihJKsv by remember { mutableStateOf("") }

    Column () {
        Card (modifier = Modifier
            .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.Cyan),
            shape = RoundedCornerShape(bottomEnd = 80.dp)
        ){
            Column (modifier = Modifier
                .padding(16.dp)
            ) {
                Icon(imageVector = Icons.Filled.Menu,
                    tint = Color.White,
                    contentDescription = null,
                )
                Spacer(Modifier .padding(8.dp))

                Row (modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                    Column {
                        Text(text = "Halo,",
                            color = Color.White,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "$Namasv",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }

                    Box (
                        contentAlignment = Alignment.BottomStart
                    ){
                        Image(painter = painterResource(id = R.drawable.kaoruko),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape),

                            )
                    }
                }
            }
        }
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text("Yuk Lengkapi data dirimu !",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = Nama,
                onValueChange = {Nama = it},
                label = { Text("Nama") },
                leadingIcon = { Icon(Icons.Default.Face, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(20.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = NoTelepon,
                onValueChange = {NoTelepon = it},
                label = { Text("No. Handphone") },
                leadingIcon = { Icon(Icons.Default.Phone, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(20.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Jenis Kelamin", fontSize = 16.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                JenisKelamin.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = MemilihJK == item,
                            onClick = { MemilihJK = item }
                        )
                        Text(item)
                    }
                }
            }

            Button(
                onClick = {
                    Namasv = Nama
                    NoTeleponsv = NoTelepon
                    MemilihJKsv = MemilihJK
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan)
            ) {
                Text("Submit", color = Color.White)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(){
                ElevatedCard (
                    colors = CardDefaults.cardColors(containerColor = Color.LightGray),
                    modifier = Modifier
                        .fillMaxWidth()){
                    ShowData(judul = "Nomor Handphone", isinya = NoTeleponsv, icon = Icons.Default.Phone)
                    ShowData(judul = "Jenis Kelamin", isinya = MemilihJKsv, icon = Icons.Default.AccountBox)
                }
            }
        }
    }
}


@Composable
fun ShowData(judul: String, isinya: String, icon: ImageVector) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(10.dp)
    ) {
        Spacer(modifier = Modifier.width(8.dp))
            Icon(icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
            Text(text = "$judul :", color = Color.Black, fontSize = 14.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = isinya, color = Color.Black, fontSize = 14.sp)
        }
    }

