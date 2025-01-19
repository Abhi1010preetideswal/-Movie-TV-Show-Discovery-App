MovieTV App :-
The MovieTV App is a Compose-based Android application designed to fetch and display movie and TV 
show information using the Watchmode API. This repository includes the source code, project 
structure, and all related files for the application. 
Features Implemented :- 
Movie Search: 
1) Users can search any movies using a keyword. 
2) The app fetches/Search the data from the Watchmode API and displays it in a list format
   
Dynamic UI: 
1) In this App , I'm using the Jetpack Compose for a dynamic UI. 
2) I try to includes these components such as LazyColumn, Snackbar, and Image handling using Coil.

API Integration: 
1) Integrated with Watchmode API to fetching movie data. 
2) Handles API requests using Retrofit with RxJava3 for asynchronous operations.   

Error Handling: 
1) Displays appropriate error messages using Snackbar for user feedback. 
2) Handles cases where no results are returned from the API.

Clean Architecture: 
1) Followed MVVM (Model-View-ViewModel) architecture. 
2) Dependency injection with Koin for clean and testable code.

For Testing Ready: 
1) Added logging to debug and ensure correctness. 


Experience :-

For building this App.I'm Getting a Valua valuable learning experience in implementing advanced Android concepts such as:

1) Using Jetpack Compose for UI development. 
2) Managing API integrations with Retrofit and RxJava3. 
3) Debugging and error handling in real-world scenarios. 
4) Working with external APIs.

   
Challenges Faced :-

1) API Key Usage: 
Ensuring the API key was passed correctly while maintaining security. 
Debugging when API calls initially failed due to incorrect or expired keys.

2) Data Mapping: 
Adjusting the data model to match the API response. 
Ensuring null-safe handling of fields like name, Year, Id, and poster.

3) Network Issues: 
Verified the network status and API reachability using tools like Postman and curl. 

4) UI Debugging: 
Aligning components in Jetpack Compose for a visually appealing layout. 
Handling empty lists gracefully and providing feedback through loading spinners and error messages. 

5) Performance Optimization: 
Fixed skipped frames and heavy operations on the main thread. 
Used RxJava3 for smooth and non-blocking API calls. 


Assumptions Made :-

1) The API key provided (WjOkFXMhndyW8rUXkaIP5oEm0iQrFbsdons3sovi) was assumed to have sufficient quota during testing and usage. 

2) The Watchmode API's response format was consistent and followed the documented schema. 

3) Users would search using movie titles or keywords, and data would be displayed directly from the API response without additional filtering. 

4) Default images and fallback messages were sufficient for handling missing or null data in API responses. 
