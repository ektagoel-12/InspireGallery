# InspireGallery

A simple Android image gallery built with Jetpack Compose. It reads a list of image URLs from a bundled JSON file and shows them in a scrolling list.

## Features

- Image list loaded from `app/src/main/assets/images.json`
- Remote images rendered with Coil
- Compose `LazyColumn` with Material 3

## Tech stack

- Kotlin, Jetpack Compose, Material 3
- Coil (`coil-compose`) for image loading
- Gson for JSON parsing
- Navigation Compose is included as a dependency
- Android `minSdk` 28, `compileSdk` / `targetSdk` 36

## Run it

Open the project in Android Studio and run the `app` configuration, or with a device or emulator connected:

```bash
./gradlew installDebug
```

The app needs internet access to load the images.

## Change the images

Edit `app/src/main/assets/images.json`. Each entry has an `id` and a `url`:

```json
{ "id": 1, "url": "https://picsum.photos/id/1011/400/300" }
```

## Project structure

```
app/src/main/java/com/example/inspiregallery/
  MainActivity.kt   Compose list screen
  utils/JsonUtils.kt  Loads images.json
  data/model/       ImageItem, ImageResponse
```
