package com.example.androiddevchallenge.ui.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.PuppyData
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.ffEFEFEF

@Composable
fun PuppyList(puppies: List<PuppyData>, onPuppyClick: (PuppyData) -> Unit = {}) {
    LazyColumn(
        Modifier.background(ffEFEFEF),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(puppies) { item: PuppyData ->
            PuppyItem(item,
                Modifier
                    .clickable {
                        onPuppyClick(item)
                    }
                    .fillMaxWidth())
        }
    }
}

@Composable
fun PuppyItem(puppy: PuppyData, modifier: Modifier = Modifier) {
    Card(modifier) {
        Row {
            Image(
                painterResource(puppy.photo),
                "Puppy: ${puppy.name}",
                Modifier.size(120.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .absolutePadding(left = 10.dp, right = 10.dp)
                    .height(120.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(puppy.name, style = MaterialTheme.typography.h6)
                Row {
                    Text("${if (puppy.isMale) "Boy" else "Girl"}; Born on ${puppy.birthday}")
                }
                Text(puppy.breed)
                Text(puppy.location)
            }
        }
    }
}

@Composable
fun PuppyDetail(puppy: PuppyData, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Image(
            painter = painterResource(id = puppy.photo),
            contentDescription = "Puppy: ${puppy.name}",
            modifier = Modifier.aspectRatio(1f),
            contentScale = ContentScale.Crop
        )
        Column(Modifier.padding(10.dp)) {
            Text(
                text = puppy.name,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.absolutePadding(top = 10.dp)
            )
            Text(
                text = "${if (puppy.isMale) "Boy" else "Girl"}; Born on ${puppy.birthday}",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.absolutePadding(top = 10.dp)
            )
            Text(text = puppy.breed, style = MaterialTheme.typography.h5)
            Text(
                text = puppy.location, style = MaterialTheme.typography.h5,
                modifier = Modifier.absolutePadding(bottom = 20.dp)
            )
            Button(onClick = {
                Toast.makeText(
                    context,
                    "We will contact you soon.",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Text(text = "I WANT ADOPT IT")
            }
        }
    }
}

private val previewPuppy = PuppyData(
    R.drawable.puppy_kiki, "Kiki", "2020.01.01", true,
    "Welsh Corgi Pembroke", "Guangzhou, China"
)

@Preview
@Composable
fun PuppyListPreview() {
    val puppies = listOf(
        previewPuppy,
        previewPuppy,
        previewPuppy,
    )
    MyTheme {
        PuppyList(puppies)
    }
}

@Preview
@Composable
fun PuppyListPreviewDark() {
    val puppies = listOf(
        previewPuppy,
        previewPuppy,
        previewPuppy,
    )
    MyTheme(darkTheme = true) {
        PuppyList(puppies)
    }
}

@Preview
@Composable
fun PuppyItemPreview() {
    MyTheme {
        PuppyItem(previewPuppy)
    }
}

@Preview
@Composable
fun PuppyItemPreviewDark() {
    MyTheme(darkTheme = true) {
        PuppyItem(previewPuppy)
    }
}

@Preview
@Composable
fun PuppyDetailPreview() {
    MyTheme() {
        PuppyDetail(puppy = previewPuppy)
    }
}