# MVVM with HILT
Here, I'm going to implement hilt dependency injection with Retrofit and Room Database, following by MMVVM architechture.

Learn how to use predefined components such as Singleton Component. Generally we use Retrofit to access network API. Learn how to define this Retrofit object as singleton using Hilt. Learn how to use room database with Hilt and MVVM.

`Used API` - BASE_URL = http://fakestoreapi.com/

## Project SetUp
build,gradle (Project Level)

    id("com.google.dagger.hilt.android") version "2.51" apply false
build,gradle (Module Level)

    kotlin("kapt")
    id("com.google.dagger.hilt.android")

    
    // Hilt
    implementation("com.google.dagger:hilt-android:2.51")
    kapt("com.google.dagger:hilt-android-compiler:2.51")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    //Room
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:2.6.1")

    //Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    
    // Allow references to generated code
    kapt {
        correctErrorTypes = true
    }
## Step - 1 ` @HiltAndroidApp ` & ` @AndroidEntryPoint `
   - Make application class and annotate it with ` @HiltAndroidApp `.
   - and don't forget to mention this class in your manifest file.
   - Annotate your MainActivity class with `@AndroidEntryPoint`.

## Step - 2 ` API and Room SetUp `
   - model
      - Create data class
   - Api Interface
      - make a retrofit api interface and make fun to get data.
   - db
      - Create DAO interface and make fun to insert data and get data.
      - Create Database abstract class and create abstract fun to get DAO.
   - Repository
      - Create repository class and @Inject the constructor to get objects of Api Interface and Database class.

             class ProductRepository @Inject constructor(val fakerApi: FakerApi, val fakerDB: FakerDB)
      - Create a fun to call the api and store the data in the database.
   - ViewModel
      - Now create the MainViewmodel class and @Inject Constructor for Repository class
      - ViewModelFactory class and @Inject the constructor for MainViewModel class
## Step - 3 ` Create Modules inside di`
   - Create modules for Retrofit Network and RoomDatabase
   - Network Module class
      - Create a NetworkModule class and annotate it as @Module and @InstallIn. and create two fun.
      - Create a fun to provide Retrofit object and annotate it as @Provides and @Singleton.
      - Create another fun to provide api interface and annotate it as @Provides and @Singleton.
   - Database Module class  
      - Create a DatabaseModule class and annotate it as @Module and @InstallIn.
      - Create a fun to provide DB object and annotate it as @Provides and @Singleton. 

