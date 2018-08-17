# UNUM_Dogs

This project was made for a coding challenge from UNUM, Inc.

<img src="https://github.com/rkuang/UNUM_Dogs/blob/assets/Screenshot_1534479214.png?raw=true" alt="screenshot" width="400px" height="auto">

## Dependencies
* Dog API
* Volley
* Glide

## How it works
When you launch the application, UNUM_Dogs sends queries to the Dog API, which can be found [here](https://dog.ceo/dog-api/).

The app displays a list of all breeds of dogs that can be found using the API in a 3-column-grid using Android's RecyclerView
with a GridLayoutManager.

UNUM_Dogs uses Volley to make simple HTTP requests to Dog API. When the app launches, it sends a request for the list of all breeds of 
dogs, and then it iterates through that list and requests each breed's associated image. As each breed is retrieved, a Breed object is 
created and added to the RecyclerView's dataset.

When the dataset is modified, the RecyclerView's adapter notifies the RecyclerView that it needs to be updated. The app uses Glide to 
load the image into the ImageView. I initially used Picasso to handle images, but it took a very large toll on the performance of the app.
Glide is a newer package that is still supported, and it handles loading images without much difficulty.
