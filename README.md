# Task Description:

Create an Android app featuring a datetime picker and a submit button.
The app has a database with a table named "Employee" containing a single column called “check_in_date"
“check_in_date” Is a date as a String  in the format “yyyy-MM-dd HH:mm”
On the first app launch the datetime picker should be initialized with the response of a mock GET HTTP API call “mock/api/date."
The mock API response is in JSON format: {"dateTime": "yyyy-MM-dd HH:mm”}. 
The initial datetime for the first app launch should be 06:30 of the current day and retrieved from the mocked API call.
Users should be able to change the selected datetime using the picker.
The selected datetime must be validated to ensure it's not in the future (dates after the current datetime of the device should be rejected).
When the user presses the "Submit" button, the selected datetime should be inserted into the "Employee" table in the database.
Subsequent app launches should fetch the most recent datetime from the database table and display it in the datetime picker. 


# Tips:

Organize your code into separate layers/packages/folders to demonstrate a clear separation of network calls/business logic from the UI.
The api call mocking could be as simple as a method call. As long as the method lives in a separate layer than the UI layer and the call itself happens on a background thread.
Handle background work in any way you prefer.
You can choose to implement the UI using either Jetpack Compose or XML layouts.
You can use Kotlin or Java.
Design the UI with full-screen display, paying attention to proper padding and positioning. Don’t spend time on aesthetics such as colors, icons, themes, and animations.
Use any relational database solution of your choice.
Do as much as you can, We will evaluate your work even if it didn’t meet all the requirements. -as long as it builds successfully-   

# Delivery:

Deliver the code as a public GitHub repository link. If you’re unable to do that then deliver it as a zip file.

The expected delivery timeframe for this task should not exceed one week from the moment you receive it. If you have any questions about the task or require an extension, please don't hesitate to reach out to us.
 
The purpose of this task is to assess your ability to build an Android app with database integration, network calls, and user interface components. Best of luck :)
