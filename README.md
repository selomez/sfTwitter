+# Project 3 - *sfwitter* is an android app that allows a user to view his Twitter timeline and post a new tweet. The app utilizes [Twitter REST API](https://dev.twitter.com/rest/public).
+
+Time spent: **20** hours spent in total
+
+## User Stories
+
+The following **required** functionality is completed:
+
+* [X]	User can **sign in to Twitter** using OAuth login
+* [X]	User can **view tweets from their home timeline**
+  * [X] User is displayed the username, name, and body for each tweet
+  * [X] User is displayed the [relative timestamp](https://gist.github.com/nesquena/f786232f5ef72f6e10a7) for each tweet "8m", "7h"
+* [X] User can **compose and post a new tweet**
+  * [X] User can click a “Compose” icon in the Action Bar on the top right
+  * [X] User can then enter a new tweet and post this to twitter
+  * [X] User is taken back to home timeline with **new tweet visible** in timeline
+  * [X] Newly created tweet should be manually inserted into the timeline and not rely on a full refresh
+
+The following **optional** features are implemented:
+
+* [ ] User can **see a counter with total number of characters left for tweet** on compose tweet page
+* [X] User can **pull down to refresh tweets timeline**
+* [X] User is using **"Twitter branded" colors and styles**
+* [ ] User sees an **indeterminate progress indicator** when any background or network task is happening
+* [X] User can **select "reply" from detail view to respond to a tweet**
+  * [X] User that wrote the original tweet is **automatically "@" replied in compose**
+* [X] Use Parcelable instead of Serializable using the popular [Parceler library](http://guides.codepath.com/android/Using-Parceler).

+
+
+The following **additional** features are implemented:
+
+* [ ] List anything else that you can get done to improve the app functionality!
+
+## Video Walkthrough
+
+Here's a walkthrough of implemented user stories:
+
+<img src='http://i.imgur.com/link/to/your/gif/file.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />
+
+GIF created with [LiceCap](http://www.cockos.com/licecap/).
+
+## Notes
+
+Describe any challenges encountered while building the app.
+
+The challenge was retreiving the necessary objects and parsing them correctly.
+
+## Open-source libraries used
+
+- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
+- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android
+
+## License
+
+    Copyright 2018 Selome
+
+    Licensed under the Apache License, Version 2.0 (the "License");
+    you may not use this file except in compliance with the License.
+    You may obtain a copy of the License at
+
+        http://www.apache.org/licenses/LICENSE-2.0
+
+    Unless required by applicable law or agreed to in writing, software
+    distributed under the License is distributed on an "AS IS" BASIS,
+    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
+    See the License for the specific language governing permissions and
+    limitations under the License.
