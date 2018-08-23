# Management_system

## Description 

This program is designed to be a data management tool which is able to perform Employee, Product and Order management.

This is a JavaWeb program which follows the MVC pattern. 

MySQL is used as the data storage tool. Framework was not being used in this program, please be careful about the database naming if you want to try it on your local machine.

## Key Words
#### * Java   * JavaScript   * JSP/HTML/CSS   * MySQL
#### * Servlet    * Tomcat  
#### * MVC   * Dynamic webpage

## User Cases

### welcome page

User will be directed to this page when program is started

![Image text](https://github.com/JamesW121/Management_system/blob/master/image/1.PNG)


The first component of Employee Management allows users to add a new employee.
(Note: Users are required to complete every blank field)

![Image text](https://github.com/JamesW121/Management_system/blob/master/image/2.PNG)


If operation  is completed, users will be notified.

![Image text](https://github.com/JamesW121/Management_system/blob/master/image/3.PNG)


Or if the operation failed.
(Note: Information will be checked by both front-end & back-end, missing/identical information will be detected and cause operation failure)

![Image text](https://github.com/JamesW121/Management_system/blob/master/image/5.PNG)


There is also a search function which allow users to search for a existing employee by ANY partial/complete condition 

![Image text](https://github.com/JamesW121/Management_system/blob/master/image/4.PNG)


Structure of the database --- Employee

![Image text](https://github.com/JamesW121/Management_system/blob/master/image/6.PNG)


Similar to EM, Product management also have a add-new function which includes more information

![Image text](https://github.com/JamesW121/Management_system/blob/master/image/11.PNG)


The program does not allow identical ID/Name existing at the same time in the database. But to make things easier, a merge feature is provided. When user is trying to add an item more than once, the system can detect such case and give user an option to merge them.

![Image text](https://github.com/JamesW121/Management_system/blob/master/image/12.PNG)


If no problem is detected, user will be notified and given the updated information

![Image text](https://github.com/JamesW121/Management_system/blob/master/image/13.PNG)


Search a product/products by any condition!

![Image text](https://github.com/JamesW121/Management_system/blob/master/image/14.PNG)


#### The CORE/Most INTERESTING feature of this part of the program!!! It can show you the current news of the products!

The product and order management are depending on each other in this program. 

You can view which item is almost out of stock, the next expiring item or you can get a note on the best-selling items! This part can be  costumed as much as user prefers.

![Image text](https://github.com/JamesW121/Management_system/blob/master/image/15.PNG)


Database --- Product Management

![Image text](https://github.com/JamesW121/Management_system/blob/master/image/16.PNG)


Add a new order
(Note: Product name/ID must be matched with one of the exciting product in the Product Database)

![Image text](https://github.com/JamesW121/Management_system/blob/master/image/21.PNG)


Feature: Member Discount! A 10% off will be auto-applied if the customer has a membership 

![Image text](https://github.com/JamesW121/Management_system/blob/master/image/22.PNG)


Failure case
(Note: maybe caused by the unmatched product name/ID)

![Image text](https://github.com/JamesW121/Management_system/blob/master/image/23.PNG)


Search for an order by any condition!

![Image text](https://github.com/JamesW121/Management_system/blob/master/image/24.PNG)


#### Another core function of the program! 

It can give you a summery on your recent performance, and each item's performance.

![Image text](https://github.com/JamesW121/Management_system/blob/master/image/25.PNG)


Database --- Order Management

![Image text](https://github.com/JamesW121/Management_system/blob/master/image/26.PNG)

