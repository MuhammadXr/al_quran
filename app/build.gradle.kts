plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
}

android {
    namespace = "com.rast.alquran"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.rast.alquran"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            buildConfigField("String", "API_URL", "\"https://api.quran.com/api/v4/\"")
            buildConfigField(
                "String",
                "FONT_URL",
                "\"https://firebasestorage.googleapis.com/v0/b/al-quran-8f5c8.appspot.com/o/qcf_font%2F\""
            )
//            buildConfigField(
//                "String",
//                "FONT_URL",
//                "\"https://archive.org/download/maktabadda_gmail_QCF2/\""
//            )
        }

        release {
            buildConfigField("String", "API_URL", "\"https://api.quran.com/api/v4/\"")
            buildConfigField(
                "String",
                "FONT_URL",
                "\"https://firebasestorage.googleapis.com/v0/b/al-quran-8f5c8.appspot.com/o/qcf_font%2F\""
            )
//            buildConfigField(
//                "String",
//                "FONT_URL",
//                "\"https://archive.org/download/maktabadda_gmail_QCF2/\""
//            )
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.10.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.44.2")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    // Dependency Injection
    implementation("androidx.hilt:hilt-work:1.0.0")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    implementation("androidx.work:work-runtime-ktx:2.8.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    //Room
    implementation("androidx.room:room-runtime:2.6.0")
    //noinspection KaptUsageInsteadOfKsp
    kapt("androidx.room:room-compiler:2.6.0")
    implementation("androidx.room:room-ktx:2.6.0")
    androidTestImplementation("androidx.room:room-testing:2.6.0")

    //JetPack Navigation
    implementation("androidx.navigation:navigation-compose:2.7.4")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.17.0")

    //RETROFIT 2
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")


    //GOOGLE Accompanist
    implementation ("com.google.accompanist:accompanist-flowlayout:0.20.0")
}