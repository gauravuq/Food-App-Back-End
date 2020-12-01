# Food-App-Back-End

This project is about creating a Back-End Microservices based solution for a kitchen management Front-End where customer can Place/Update food orders, administration staff could create/edit daily menus and email valid customers. This app in whole is to be used by a small college where customers are students who can book their meals online. 

### Design of the domain

![Design of the domain](https://github.com/gauravuq/Food-App-Back-End/blob/master/Food%20App%20Back-End%20Domain.svg)

#### Back-End is composed of 4 microservices, explained as below
* Menu Back-End Service : handles menu lifecycle;
  - [X] CRUD: Menu Type and its Menu items;
  - [X] PDF generation for admin staff to download menus;
* Order Back-End Service: handles order lifecycle;
  - [ ] CRUD: for recording booking of orders by the Customer.
  - [ ] Handle rules for creation of an order;
* Email Back-End Service: for generating Event Notifications for its users;
  - [ ] Send email for Kitchen actions to its customers.
* User Back-End Service: for keep track of Customers and Admin staff using this System.
  - [ ] Integrate with email service for sending order booking.
  
#### Back-End Security is being implemented by usind Keycloak Server which priovides OAuth 2.0 Security Standard, explained as below
* [ ] Front-End UI to Back-End Services request protected by PKCE Authorisation Code Grant Type;
* [ ] Communication between Back-End Services is protected by Client Credential Grant Type;

#### Spring Api Gateway for Microservices 
  - [X] To enable Spring Cloud Api Gateway for microservices.
#### Spring Eureka Service Registry for Microservices 
  - [X] To enable Eureka Service Registry for microservices.
#### Spring Cloud Config Server for Microservices 
  - [ ] To enable Cloud Config Server for microservices.
  
### Order Placement Scenario

![Order Placement Scenario](https://github.com/gauravuq/Food-App-Back-End/blob/master/Food%20App%20Back-End%20Order%20Scenario%20.svg)

#### More updates coming soon !!!
