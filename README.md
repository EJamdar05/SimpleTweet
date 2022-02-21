# Project 2 - Simple Tweet

Simple Tweet is an android app that allows a user to view his Twitter timeline. The app utilizes [Twitter REST API](https://dev.twitter.com/rest/public).

Time spent: 5 hours spent in total

## User Stories

The following **required** functionality is completed:

- [✔️] User can compose a new tweet (5 points)
- [✔️] User can then enter a new tweet and post this to twitter
- [✔️] Newly created tweet should be manually inserted into the timeline and not rely on a full refresh
- [✔️] User is displayed the [relative timestamp](https://gist.github.com/nesquena/f786232f5ef72f6e10a7) for each tweet "8m", "7h"
- [✔️] User can refresh tweets timeline by pulling down to refresh
- [✔️] While composing a tweet, user can see a character counter with characters remaining for tweet out of 280

The following **optional** features are implemented:

- [✔️] Improve the user interface and theme the app to feel "twitter branded" (1 to 5 points)
- [✔️] Improve the user interface and theme the app to feel "twitter branded" (added splash screen)
- [❌] Links in tweets are clickable and will launch the web browser
- [❌] User can tap a tweet to display a "detailed" view of that tweet
- [❌] User can see embedded image media within the tweet detail view
- [❌] User can watch embedded video within the tweet
- [❌] User can open the twitter app offline and see last loaded tweets
- [❌] On the Twitter timeline, leverage the CoordinatorLayout to apply scrolling behavior that hides / shows the toolbar.

The following **additional** features are implemented:

- [✔️] Added twitter logo to sign in

## Video Walkthrough

Here's a walkthrough of implemented user stories:
<img src='https://i.imgur.com/XemkRXH.gif' title='Demo of App' width='' alt='Opening App' />
GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes
The tutorial usage with Kotlin and having to translate certain things to Java was a bit of a learning curb but it was nto a big issue. The biggest one was probably the Percilable object but I managed to figure it out. 
## Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android

## License

    Copyright [yyyy] [name of copyright owner]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
