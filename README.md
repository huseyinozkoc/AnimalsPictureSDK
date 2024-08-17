## 📍 Overview

**Animals Picture SDK**

This is an SDK and library from where you can get random animal images url.

<p align="center">
  <img src="https://github.com/user-attachments/assets/dfbc7d8c-ce66-4a03-9b60-e01e2c451694" alt="all_Animals">
</p>


## 🚀Screenshots

| Animals | Animals | Animals  | Animals | Animals |
:-------------------------:|:-------------------------:|:-------------------------:|:-------------------------:|:-------------------------:
 ![image](https://github.com/user-attachments/assets/f0dc5946-c90f-4a2e-beca-b5a08afe4cc2) | ![image](https://github.com/user-attachments/assets/14c4d5f4-f46b-4ee0-a7d1-166aeb8f42e5) |![image](https://github.com/user-attachments/assets/fd192b04-5e3d-4653-8cf5-93448712a613)| ![image](https://github.com/user-attachments/assets/f75145c5-17f4-45e8-8c64-9a2e91bfe74b) | ![image](https://github.com/user-attachments/assets/057ebeb0-56e8-4c9a-9c04-76ae1988fcb6) |

## 📍 Gradle

Add  " maven { url 'https://jitpack.io' } " in your `root build.gradle` at the end of repositories:

```
dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```

Add dependency to your `build.gradle` and sync your project

```
implementation ("com.github.huseyinozkoc:AnimalsPictureSDK:1.0.7")
```

## 📍  How to use

To access the URLs of random animal pictures, you can easily use the UseCase of the relevant animals and randomly access the URLs of the pictures of the animals you want:

```Kotlin
@HiltViewModel
class AnimalViewModel @Inject constructor(
    private val getDogUseCase: GetDogUseCase,
    private val getFoxUseCase: GetFoxUseCase,
    private val getDuckUseCase: GetDuckUseCase,
    private val getCatUseCase: GetCatUseCase
) : ViewModel() {

    private val _dog = MutableStateFlow<Resource<Dog>>(Resource.Loading)
    val dog: StateFlow<Resource<Dog>> = _dog

    private val _fox = MutableStateFlow<Resource<Fox>>(Resource.Loading)
    val fox: StateFlow<Resource<Fox>> = _fox

    private val _duck = MutableStateFlow<Resource<Duck>>(Resource.Loading)
    val duck: StateFlow<Resource<Duck>> = _duck

    private val _cat = MutableStateFlow<Resource<Cat>>(Resource.Loading)
    val cat: StateFlow<Resource<Cat>> = _cat
```

```Kotlin
sealed interface Resource<out T> {
    data class Success<T>(val data: T) : Resource<T>
    data class Error(val throwable: Throwable) : Resource<Nothing>
    object Loading : Resource<Nothing>
}
```

### 📍 Animals

Now you can only access random  `Cat, Dog, Duck and Fox ` image urls  `using the 4 relevant UseCase above.`

```Kotlin
    private val getDogUseCase: GetDogUseCase,
    private val getFoxUseCase: GetFoxUseCase,
    private val getDuckUseCase: GetDuckUseCase,
    private val getCatUseCase: GetCatUseCase
```

### 📍 Models

You can use the previously created`Cat, Dog, Duck and Fox ` models from the SDK. These contain the image urls of the animals.

```Kotlin
data class Fox(
    val image: String,
    val link: String
)
data class Dog(
    val fileSizeBytes: Int,
    val url: String
)
data class Duck(
    val message: String,
    val url: String
)
data class Cat(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int
)
```

### 📍 Other configurations

While writing the SDK, version 2.48 of the Hilt library for Dependecy Injection was used, please work on this version in your projects and do not forget to create the "@HiltAndroidApp" class in your project for the SDK to work.
![image](https://github.com/user-attachments/assets/a3dcb8f8-ee7d-4f03-b67e-145b90024846)
![image](https://github.com/user-attachments/assets/e8f9fef2-1f54-4297-810e-ba0929a05b44)

### 📍 If you want you can download the Sdk from here.

[CatDogSDK-debug.zip](https://github.com/user-attachments/files/16646265/CatDogSDK-debug.zip)

![image](https://github.com/user-attachments/assets/d19cdc6b-6a38-4e1f-9cae-4b67015fd572)

![image](https://github.com/user-attachments/assets/7da1e1b4-f0c6-4d69-bead-2e62001df33a)



Have a `fun code()`!
