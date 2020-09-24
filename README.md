# AccessAppExercise

<img src="https://github.com/jrying1212/AccessAppExercise/blob/master/pic/user_list.png" width="250"> <img src="https://github.com/jrying1212/AccessAppExercise/blob/master/pic/user_detail.png" width="250"> <img src="https://github.com/jrying1212/AccessAppExercise/blob/master/pic/demo.gif" width="250">

## Features
The App shows the GitHub users in a List, and upon clicking, shows the user detail

## Overview
### The app use the MVVM architecture and has following packages:
- **api**: Github API calls, using Retrofit.
- **data**: The repository class, responsible for triggering API requests using Paging.
- **model**: The User and UserDetail data model.
- **ui**: classes related to displaying an Activity with a RecyclerView.

### GitHub API 
- [List users](https://docs.github.com/en/rest/reference/users#list-users)
- [Get a user](https://docs.github.com/en/rest/reference/users#get-a-user)

## Libraries
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture)
- [Paging](https://developer.android.com/topic/libraries/architecture/paging)
- [Retrofit](Retrofit) for REST api communication
- [Glide](https://github.com/bumptech/glide) for image loading and circle crop
