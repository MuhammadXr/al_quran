package com.rast.alquran.ui.screens.chapter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.rast.alquran.ui.base.Screen
import com.rast.alquran.ui.layouts.FlowMainAxisAlignment
import com.rast.alquran.ui.theme.AlQuranTheme
import com.rast.alquran.utils.PlayWordMedia
import com.rast.alquran.viewmodel.ChapterViewModel
import java.io.File

class ChapterScreen(val chapterId: Int, val navHostController: NavHostController) : Screen {
    @Composable
    override fun Content() {
        ChapterScreenContent(chapterId = chapterId, navController = navHostController)
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun ChapterScreenContent(
    chapterId: Int,
    navController: NavHostController,
    viewModel: ChapterViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = true, block = {
        viewModel.getVersesByChapter(chapterId, context)
    })

    val wordId = remember {
        mutableIntStateOf(-1)
    }
    val verseId = remember {
        mutableIntStateOf(-1)
    }

    val verses = viewModel.verses.collectAsState()
    val fontsMap = viewModel.fontPath.collectAsState()
    val downloadProgress = viewModel.downloadProgress.collectAsState()
    val isFontExist = viewModel.isFontExist.collectAsState()

    AlQuranTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(42.dp)
        ) {
            if (verses.value == null) {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
            if (isFontExist.value == true) {
                verses.value?.let {
                    LazyColumn(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .fillMaxWidth(),
                    ) {

                        it.verses?.let { verseList ->
                            items(verseList) { verse ->

                                Row(modifier = Modifier.fillMaxWidth()) {
                                    Spacer(modifier = Modifier.weight(1f))
                                    CompositionLocalProvider(
                                        LocalLayoutDirection provides LayoutDirection.Rtl
                                    ) {
                                        com.rast.alquran.ui.layouts.FlowRow(
                                            mainAxisAlignment = FlowMainAxisAlignment.Start,
                                        ) {
                                            fontsMap.value[verse?.v2Page]?.let { fontPath ->
                                                val words = verse?.codeV2?.split(' ')
                                                words?.forEachIndexed { index, word ->
                                                    Box {
                                                        var expanded by remember { mutableStateOf(false) }
                                                        Text(
                                                            modifier = Modifier.clickable(
                                                                onClick = {
                                                                    val wId = index + 1
                                                                    println(wId)
                                                                    if (wId != wordId.intValue ||
                                                                        verseId.intValue !=
                                                                        verse.verseKey!!.split(':')
                                                                            .last()
                                                                            .toInt()
                                                                    ) {
                                                                        expanded = true
                                                                        wordId.intValue = wId
                                                                        verseId.intValue =
                                                                            verse.verseKey!!.split(
                                                                                ':'
                                                                            )
                                                                                .last()
                                                                                .toInt()
                                                                    } else {
                                                                        expanded = false
                                                                        wordId.intValue = -1
                                                                        verseId.intValue = -1
                                                                    }
                                                                },
                                                                enabled = index != words.size - 1
                                                            ),
                                                            text = word,
                                                            style = TextStyle(
                                                                fontFamily = FontFamily(
                                                                    Font(
                                                                        file = File(fontPath),
                                                                    )
                                                                ),
                                                                fontSize = 28.sp,
                                                            )
                                                        )
                                                        DropdownMenu(
                                                            expanded = expanded,
                                                            onDismissRequest = { expanded = false },
                                                            modifier = Modifier.align(Alignment.Center),
                                                            offset = DpOffset(0.dp, y = (-120).dp)
                                                        ) {
                                                            DropdownMenuItem(
                                                                onClick = {},
                                                                text = {
                                                                    Row(
                                                                        modifier = Modifier
                                                                            .fillMaxSize(),
                                                                        verticalAlignment = Alignment.CenterVertically
                                                                    ) {
                                                                        IconButton(
                                                                            modifier = Modifier.padding(0.dp).size(48.dp),
                                                                            onClick = {
                                                                            PlayWordMedia.playWord(
                                                                                chapterId = chapterId,
                                                                                verseId = verseId.intValue,
                                                                                wordId = wordId.intValue
                                                                            )
                                                                            expanded = false
                                                                        }) {
                                                                            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null)
                                                                        }
                                                                    }
                                                                }
                                                            )
                                                        }
                                                    }

                                                }

                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
            if (isFontExist.value != null && isFontExist.value!!.not()) {
                Column(
                    Modifier
                        .align(Alignment.Center)
                        .padding(24.dp)
                ) {
                    Text(text = "Download Fonts")
                    LinearProgressIndicator(progress = downloadProgress.value.toFloat())
                }
            }
//            if (wordId.intValue != -1) {
//                Row(
//                    modifier = Modifier
//                        .height(48.dp)
//                        .fillMaxWidth()
//                ) {
//                    Spacer(modifier = Modifier.weight(1f))
//                    IconButton(onClick = {
//
//                    }) {
//                        Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null)
//                    }
//                }
//            }
        }
    }
}