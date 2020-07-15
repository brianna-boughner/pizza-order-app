# pizza-order-app

An app for ordering pizza: customers can create and order a custom pizza!

Some manual tests are listed in the Wiki page of the repository.

*side note: I drew all of the graphics myself so I hope you enjoy them :)*

## Requirements

**-> USER FRIENDLY INTERFACE**

The app doesn't have a wide variety of 'actors', since the main target is customers of the pizza store. 

The user must be able to easily create and order their pizza to encourage them to return as a customer.
There will be a limited amount of functions (only checkboxes for different toppings/sizes)
The price will be displayed at the top, and updates when the size or toppings change.
A graphic of the pizza will also be displayed at the top, and when toppings are added they will be added to the pizza.
This will create a more enjoyable experience to the customer.

**-> USE CASE**

The user opens the app. The first screen is displayed: creating the base of the pizza.

*note - you can move between the three 'tabs' easily throughout the pizza making process, so you can change your mind about toppings*

On this page, you can choose the size of the pizza (small, medium or large) as well as the type of crust (thin, regular or thick)
Using the bottom navigation bar, you can move to the next tab and choose your meat toppings. Some toppings are free, and some will cost extra.
On the final tab, you can choose the vegetarian toppings. Like the meat, some toppings will be free and some will cost extra.
Finally, you click the "place order" button. A screen will be displayed which says "thank you for your order"

## Architecture

The main components are the following classes, these are the classes to be edited if any changes are made:

[![class-diagram.png](https://i.postimg.cc/0ynfbD5J/class-diagram.png)](https://postimg.cc/QFB5zBTX)

MainActivity.java, which extends AppCompatActivity

-> not much happens here, but the navigation bar at the bottom is built here, and the three other fragments are connected to this main activity.


The next three are all 'fragments' of the main activity, and they are used to separate the Base, Veggies, and Meat selection pages.
(HomeFragment.java, DashboardFragment.java, and NotificationsFragment.java)

-> Each of these fragments has a corresponding xml file, which is used to create the GUI.

-> All of the 3 fragments work similarly, where there are a certain amount of buttons which correspond to toppings, size or crust. 

-> When a topping is selected, it is added to an array (veggies or meat) in MainActivity, which stores everything. 

-> These arrays are referenced when making the graphics "visible" or "invisible". 

The most probable change to this app would be to alter the prices or toppings available. To edit the toppings, this can be done easily by changing the button text in the xml file for meat or veggies (or adding a new checkbox). However, a new png for the topping will also have to be uploaded.

To edit the prices, change what happens in the OnCheckedChange methods for the checkboxes. There is a specific float value that is added/subtracted when the checkbox is clicked. 
