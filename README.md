# Poq Challenge
Task: Display scrollable list of repositories of “square” organisation in GitHub. The app should consist of only one screen (Repositories Screen).
Each list item should have at least the name and description of the repo.

API link to retrieve data: https://api.github.com/orgs/square/repos

### Used technologies to complete the task:
- Kotlin
- Unit test for DataRepository logic
- DI framework Hilt. Here the best choice would be Hilt or Coin
- MVVM pattern, Clean Architecture. Here if we had a couple of screens task, multiple api handling, it would be best to use SingleActivity pattern as well. 
- Retrofit, Gson, Okhttp Logging - It is best options for handling REST-based web services. Gson is very popular JSON converter, here we could use Moshi Converter as another option 
- Coroutines (StateFlow) - it is lightweight, easy solution to handle asyncronous network operations, the best alternative here could be using RxJava
