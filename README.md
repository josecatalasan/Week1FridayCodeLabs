# Week1FridayCodeLabs

## TwoActivities

Log statements were added to this project to keep track of the life cycle of activities within an application. The onSaveInstanceState method was overridden to preserve data between orientation switchs.

## shopping_list

This application features two activities. The first activity is a collection of TextViews that start off empty and a button that starts the other activity to add grocery items to the list.
An array of strings is used to fill the TextViews, and this array was passed in an Intent to the second activity to be updated.
The second activity held five buttons with the names of common grocery items. When a button is pressed, the array of strings is updated and is passed back to the first activity to have its list of TextViews updated with the new item.
If the list was full, no items were added and a Toast displayed that the list was full would show.

## LifeCycleStateHomework

This application has a single activity with a TextView, a Button, and an EditText. The TextView would start at 0 and increment everytime the Button is pressed. The state of the TextView would be saved on orientation change.

## RecyclerView

This application features a RecylerView fully implemented to be filled in with TextViews with data from a LinkedList of Strings. Each TextView has the same formatting and share a Listener to update its contents if it is tapped.
There is also a FloatingActionButton that adds additional words to the RecyclerView when it is pressed. There is also an ActionBar with a single button that resets the list if pressed. The state of the list of preserved on orientation switch.
