# UNUM_Dogs

This project was made for a coding challenge from UNUM, Inc.

<img src="https://github.com/rkuang/UNUM_Dogs/blob/assets/Screenshot_1534479214.png?raw=true" alt="screenshot" width="400px" height="auto">

## Dependencies
* Kotlin
  * I've never used Kotlin before, but I figured now was a good time to try it out. Love how it makes my code so much more concise!
* Dog API
  * Requirement
* Volley
  * Asynchronous scheduled network requests make this an easy option for querying Dog API
* Glide
  * Asynchronous loading of images into an ImageView was easy to integrate into the app after Picasso had failed to do so. This is my 
    first time using Glide, as I had been a Picasso user before. Time to make the switch.

## How it works
The app displays a list of all breeds of dogs that can be found using the API in a 3-column-grid using Android's RecyclerView
with a GridLayoutManager.

### Dog API
When you launch the application, UNUM_Dogs sends queries to the Dog API, which can be found [here](https://dog.ceo/dog-api/).

### Volley
UNUM_Dogs uses Volley to make simple HTTP requests to Dog API. When the app launches, it sends a request for the list of all breeds of 
dogs, and then it iterates through that list and requests each breed's associated image. As each breed is retrieved, a Breed object is 
created and added to the RecyclerView's dataset.

### Glide
When the dataset is modified, the RecyclerView's adapter notifies the RecyclerView that it needs to be updated. The app uses Glide to 
load the image into the ImageView. I initially used Picasso to handle images, but it took a very large toll on the performance of the app.
Glide is a newer library that is still supported, and it handles loading images without much difficulty.
