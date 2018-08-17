# UNUM_Dogs

This project was made for a coding challenge from UNUM, Inc.

<img src="https://github.com/rkuang/UNUM_Dogs/blob/assets/Screenshot_1534479214.png?raw=true" alt="screenshot" width="400px" height="auto"> <img src="https://github.com/rkuang/UNUM_Dogs/blob/assets/untitled.gif?raw=true" alt="gif" width="400px" height="auto">

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

## Design Patterns
I tried to use Design Patterns where necessary.
* Adapter
  * Implemented as is necessary for the RecyclerView.
* Singleton
  * Used for the DogAPIHelper. Only one instance of this needs to exist at a time. Made simple by the object keyword in Kotlin
* ModelViewController
  * This is just kind of how things are done in Android Studio. My model is the Breed class. My view is the main activity layout. My 
    controller is the main activity class.

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
Glide is a newer library that is still supported, and it handles loading images without much difficulty. Built in animation support is a 
huge plus as well.

## Conclusions
I spent about 2.5 hours coding up this project. It was a really fun experience learning Kotlin, Dog API, and Glide. I find the practice 
very valuable as well. This project is definitely something I'll want to expand upon in the future. It'd be nice to make this app more 
interactive by giving the user the option to click on the different dog breeds and finding out more information or looking at more 
pictures.
