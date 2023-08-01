Food Delivery Spring Boot Repository
This repository contains a simple food delivery app in Spring Boot. You're going to need a MySQL database called "fooddb" to work.

- [User](#user)
- [Restaurant](#restaurant)
- [OrderFood](#orderFood)
- [Order](#order)
- [Food](#food)
- [DeliveryBoy](#delivery-boy)
- [Delivery](#delivery)
- [Address](#address)
- [Postman collection](Food Delivery app.postman_collection.json)

<h1 id="user">User</h1>
http://localhost:8080/user/
<h2>User Properties:</h2>
<ul>
  <li>UserId</li>
  <li>Pwd (Password, will be encrypted during the user's post)</li>
  <li>Email</li>
  <li>BirthDate</li>
  <li>Code (a code customized by the user to confirm their identity when receiving a request)</li>
  <li>Role (Spring security, can be "admin", "user", or "delivery")</li>
  <li>Addresses (List of user's addresses)</li>
  <li>Authorities (Spring security)</li>
</ul>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/User/User.java">User Class</a></p>
<h2>User Methods:</h2>
<table>
  <tr>
    <th>Method</th>
    <th>URL</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>Get All Users</td>
    <td>/getAll</td>
    <td>Returns all users</td>
  </tr>
  <tr>
    <td>Get User By Id</td>
    <td>/getById/:userId</td>
    <td>Returns a user based on their id</td>
  </tr>
  <tr>
    <td>Get User By Name</td>
    <td>/getByName/:name</td>
    <td>Returns a list of users based on their name</td>
  </tr>
  <tr>
    <td>Get User By Email</td>
    <td>/getByEmail/:email</td>
    <td>Returns a user with the specified email</td>
  </tr>
  <tr>
    <td>Post User Admin</td>
    <td>/post/admin</td>
    <td>Post a new user with the role as "admin"</td>
  </tr>
  <tr>
    <td>Post User</td>
    <td>/post/user</td>
    <td>Post a new user with the role as "user"</td>
  </tr>
  <tr>
    <td>Post User Restaurant</td>
    <td>/post/restaurant</td>
    <td>Post a new user with the role as "restaurant"</td>
  </tr>
  <tr>
    <td>Post User Delivery</td>
    <td>post/delivery</td>
    <td>Post a new user with the role as "delivery"</td>
  </tr>
  <tr>
    <td>Edit User</td>
    <td>/edit/:userId</td>
    <td>Edits a user based on their id</td>
  </tr>
  <tr>
    <td>Delete User By Id</td>
    <td>/delete/:userId</td>
    <td>Deletes a user based on their id</td>
  </tr>
  <tr>
    <td>Add Address</td>
    <td>/addAddress/:userId</td>
    <td>Add an address to the user's address list (the address should be passed in the body)</td>
  </tr>
  <tr>
    <td>Edit Address</td>
    <td>/editAddress/:userId/:addressId</td>
    <td>Edits an address based on its id</td>
  </tr>
</table>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/User/UserServiceImpl.java">User Service Implementation</a></p>
<h1 id="restaurant">Restaurant</h1>
http://localhost:8080/restaurant
<h2>Restaurant Properties:</h2>
<ul>
  <li>RestaurantId</li>
  <li>Name</li>
  <li>Description</li>
  <li>Items (List of foods)</li>
  <li>Address</li>
  <li>RestaurantOwner (User Class)</li>
</ul>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/restaurant/Restaurant.java">Restaurant.class</a></p>
<h2>Restaurant Methods:</h2>
<table>
  <tr>
    <th>Method</th>
    <th>URL</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>Get All Restaurants</td>
    <td>/getAll</td>
    <td>Returns all restaurants</td>
  </tr>
  <tr>
    <td>Get Restaurant By Id</td>
    <td>/getById/:restaurantId</td>
    <td>Returns a restaurant based on its id</td>
  </tr>
  <tr>
    <td>Post Restaurant</td>
    <td>/post/:userId</td>
    <td>Post a restaurant from a user id</td>
  </tr>
  <tr>
    <td>Put Restaurant</td>
    <td>/put/:restaurantId</td>
    <td>Edits a restaurant based on its id</td>
  </tr>
  <tr>
    <td>Delete Restaurant By Id</td>
    <td>/delete/:restaurantId</td>
    <td>Deletes a restaurant based on its id</td>
  </tr>
  <tr>
    <td>Edit Address By Id</td>
    <td>/restaurant/edit/address/:restaurantId</td>
    <td>Edit an address based on the restaurant id</td>
  </tr>
  <tr>
    <td>Add an Address to a Restaurant</td>
    <td>/addAddress/:restaurantId</td>
    <td>Adds an address to a restaurant based on its ID</td>
  </tr>
  <tr>
    <td>Approve Delivery</td>
    <td>/approveDelivery/:restaurantId/:deliveryId</td>
    <td>When a user places an order, the restaurant needs to approve the request to avoid ingredient shortages or other complications. This method requires the restaurant's ID followed by the delivery ID. Also set the status as COOKING</td>
  </tr>
  <tr>
    <td>Set Delivery Status as In Delivery</td>
    <td>/restaurant/inDelivery/:restaurantId/:deliveryId</td>
    <td>When the delivery driver has the order, the restaurant must update the order status. This method requires the restaurant's ID followed by the delivery ID</td>
  </tr>
</table>
<p><a href="https://github.com/ThiagoDambroski/Spring-Boot-Project/blob/main/src/main/java/com/dambroski/webStoreProject/Itens/ItemServiceimpl.java">ItemServiceImpl.class</a></p>
<h1 id="orderFood">OrderFood</h1>
http://localhost:8080/orderFood
This class serves as an item that will go into the shopping cart, containing a food item and its quantity

<h2>OrderFood Properties:</h2>
<ul>
  <li>orderFoodId</li>
  <li>Food</li>
  <li>Quantity</li>
</ul>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/orderFood/OrderFood.java">OrderFood.class</a></p>
<h2>OrderFood Methods:</h2>
<table>
  <tr>
    <th>Method</th>
    <th>URL</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>Get All OrderFood</td>
    <td>/getAll</td>
    <td>Returns all OrderFoods</td>
  </tr>
  <tr>
    <td>Post OrderFood</td>
    <td>/post/:foodId</td>
    <td>Post an OrderFood</td>
  </tr>
</table>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/orderFood/OrderFoodServiceImpl.java">OrderFoodServiceImpl.class</a></p>
<h1 id="order">Order</h1>
http://localhost:8080/order
<h2>Order Properties:</h2>
<ul>
  <li>orderId</li>
  <li>user (the user that is making the order)</li>
  <li>address (Address that gonna be delivery)</li>
  <li>foodsId (Used at the time of placing an order, to know which are the IDs of the required OrderFoods for this order.)</li>
  <li>foods (List with OrderFood, this variable is filled based on the foodsId at the time of the POST request)</li>
  <li>restaurant</li>
  <li>status (Enum with the values PAID, IN_PROCESS, and CANCELLED)</li>
  <li>totalValue (The total purchase value is filled when an order is placed, based on the requested items)</li>
</ul>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/order/Order.java">Order.class</a></p>
<h2>Order Methods:</h2>
<table>
  <tr>
    <th>Method</th>
    <th>URL</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>Get All Orders</td>
    <td>/getAll</td>
    <td>Returns all orders</td>
  </tr>
  <tr>
    <td>Get Orders By User</td>
    <td>/getByUser/:userId</td>
    <td>Returns all orders made by the user</td>
  </tr>
  <tr>
    <td>Post Order</td>
    <td>/post/:userId/:addressId/:restaurantId</td>
    <td>To place an order, you need a list of OrderFood IDs that compose this order in the request body. Additionally, you also need the user's ID who is placing the order, followed by the address ID where the order will be delivered, and finally, the restaurant ID from which the order is being placed</td>
  </tr>
  <tr>
    <td>Delete Order By Id</td>
    <td>/delete/:orderId</td>
    <td>Deletes an order based on its id</td>
  </tr>
  <tr>
    <td>Paid Order By Id</td>
    <td>/paidOrder/:orderId</td>
    <td>Changes the status of an order to PAID</td>
  </tr>
</table>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/order/OrderServiceImpl.java">OrderServiceImpl.class</a></p>
<h1 id="food">Food</h1>
http://localhost:8080/food
<h2>Food Properties:</h2>
<ul>
  <li>FoodId</li>
  <li>Name</li>
  <li>Price</li>
  <li>Description</li>
  <li>Stock (Optional)</li>
  <li>Category (Enum)</li>
  <li>Restaurant</li>
</ul>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/food/Food.java">Food.class</a></p>
<h2>Food Methods:</h2>
<table>
  <tr>
    <th>Method</th>
    <th>URL</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>Get All Foods</td>
    <td>/getAll</td>
    <td>Returns all foods</td>
  </tr>
  <tr>
    <td>Get Food By Id</td>
    <td>/getById/:foodId</td>
    <td>Returns a food based on its id</td>
  </tr>
  <tr>
    <td>Get Foods By Name</td>
    <td>/getByName/:name</td>
    <td>Returns a list of foods based on their name</td>
  </tr>
  <tr>
    <td>Get Foods By Category</td>
    <td>/getByCategory/:category</td>
    <td>Returns a list of foods based on their category</td>
  </tr>
  <tr>
    <td>Post Food</td>
    <td>/post/:restaurantId</td>
    <td>Post a food to a restaurant</td>
  </tr>
  <tr>
    <td>Put Food</td>
    <td>/put/:foodId</td>
    <td>Edits a food based on its id</td>
  </tr>
  <tr>
    <td>Delete Food By Id</td>
    <td>/delete/:foodId</td>
    <td>Deletes a food based on its id</td>
  </tr>
</table>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/food/FoodServiceImpl.java">FoodServiceImpl.class</a></p>
<h1 id="delivery-boy">DeliveryBoy</h1>
http://localhost:8080/deliveryBoy
<h2>DeliveryBoy Properties:</h2>
<ul>
  <li>Id</li>
  <li>User (User associated with the delivery boy)</li>
  <li>Region (The region where the delivery boy wishes to make deliveries)</li>
  <li>Deliveries (List of deliveries made by the delivery boy)</li>
</ul>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/deliveryBoy/DeliveryBoy.java">DeliveryBoy.class</a></p>
<h2>DeliveryBoy Methods:</h2>
<table>
  <tr>
    <th>Method</th>
    <th>URL</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>Get All DeliveryBoys</td>
    <td>/getAll</td>
    <td>Returns all delivery boys</td>
  </tr>
  <tr>
    <td>Get DeliveryBoy By Id</td>
    <td>/getById/:boyId</td>
    <td>Returns a delivery boy based on their id</td>
  </tr>
  <tr>
    <td>Post DeliveryBoy</td>
    <td>/post/:userId</td>
    <td>Post a delivery boy from a user id</td>
  </tr>
  <tr>
    <td>Delivery Order</td>
    <td>/deliveryAOrder/:deliveryId/:deliveryBoyId/:code</td>
    <td>Indicates that the order has been delivered, requires the Delivery Id, DeliveryBoy Id, and the user's code</td>
  </tr>
  <tr>
    <td>Change DeliveryBoy Region</td>
    <td>/changeBoyRegion/:boyId</td>
    <td>Change the delivery region for a delivery boy, the new region is passed in the request body</td>
  </tr>
</table>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/deliveryBoy/DeliveryBoyServiceImpl.java">DeliveryBoyServiceImpl.class</a></p>
<h1 id="delivery">Delivery</h1>
http://localhost:8080/delivery
<p>This class is created when the Paid Order method is called</p>
<h2>Delivery Properties:</h2>
<ul>
  <li>Id</li>
  <li>Order (Order associated with the delivery)</li>
  <li>Status (Enum with the values DELIVERY, COOKING, IN_DELIVERY, WAITING_FOR_RESTAURANT_APPROVE)</li>
  <li>SelectAddress (It is automatically filled when the delivery is posted)</li>
  <li>Boy (DeliveryBoy)</li>
</ul>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/delivery/Delivery.java">Delivery.class</a></p>
<h2>Delivery Methods:</h2>
<table>
  <tr>
    <th>Method</th>
    <th>URL</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>Get All Deliveries</td>
    <td>/getAll</td>
    <td>Returns all deliveries</td>
  </tr>
  <tr>
    <td>Get Delivery by Delivery Boy Region</td>
    <td>/getByRegionDeliveryBoy/:boyId</td>
    <td>Returns deliveries based on the delivery boy's region</td>
  </tr>
  <tr>
    <td>Add DeliveryBoy to Delivery</td>
    <td>/addDeliveryBoy/:deliveryId/:deliveryboyId</td>
    <td>Link a delivery boy to a delivery</td>
  </tr>
</table>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/delivery/DeliveryServiceImpl.java">DeliveryServiceImpl.class</a></p>
<h1 id="address">Address</h1>
http://localhost:8080/address
<h2>Address Properties:</h2>
<ul>
  <li>Id</li>
  <li>State</li>
  <li>TypeId (Id from the user linked to this address)</li>
  <li>Type (It is automatically filled when the address is posted, can be USER or RESTAURANT)</li>
  <li>City</li>
  <li>Address (Street)</li>
</ul>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/Address/Address.java">Address.class</a></p>
<h2>Address Methods:</h2>
<table>
  <tr>
    <th>Method</th>
    <th>URL</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>Get All Addresses</td>
    <td>/getAll</td>
    <td>Returns all addresses</td>
  </tr>
  <tr>
    <td>Delete Address By Id</td>
    <td>/deleteAddress/:AddressId</td>
    <td>Deletes an address based on its id</td>
  </tr>
</table>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/Address/AddressServiceImpl.java">AddressServiceImpl.class</a></p>
