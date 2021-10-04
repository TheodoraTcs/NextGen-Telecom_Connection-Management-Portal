# User story

As a Customer
- view my subscription

As a Relationship Manager
- Find a customer subscription by registrationID

Data available
*tbl_Customers*
- customerId
- customerName
- customerAddress
- customerEmail
- customerNumber
- customerPassword

*tbl_Plans*
- planName
- customerId
- dateOfStart

*tbl_Tarriffplan*
- id
- planName
- typeOfPlan
- tariffRate
- validity
- rental


Data needed:
- registrationID
- Name
- emailID
- address
- contact number
(- planID- foreign key) ?

- planID
- plan name
- type
- tariff
- rental
- duration
