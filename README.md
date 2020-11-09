# Food-App-Back-End

###
This project is abour creating  a Back-End Microservices based solution for a kitchen management Front-End where customer can Place/Update orders, administration staff could Create/Edit daily menus and email customers accordingly. 

#### This Backend is composed of three microservices , explained as below
* Menu Back-End Service : handles menu lifecycle;
  - [X] CRUD: Menu Type and its Menu items;
  - [X] PDF generation for admin staff to download menus;
* Order Back-End Service: handles order lifecycle;
  - [ ] CRUD: for recording booking of orders by the Customer.
  - [ ] Handle rules for creation of an order booking;
* Email Back-End Service: for generating Event Notifications for its users;
  - [ ] Send email for Kitchen actions to its customers.
* User Back-End Service: for keep track of Customers and Admin staff using this System.
  - [ ] Integrate with email service for sending order booking.

![Design of the domain](https://github.com/gauravuq/Food-App-Back-End/blob/master/Food%20App%20Back-End%20Domain.svg)
