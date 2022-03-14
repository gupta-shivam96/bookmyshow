# README #

This README would normally document whatever steps are necessary to get your application up and running.

### What is this repository for? ###

* Quick summary
* Version
* [Learn Markdown](https://bitbucket.org/tutorials/markdowndemo)

### How do I get set up? ###

* Summary of set up
* Configuration
* Dependencies
* Database configuration
* How to run tests
* Deployment instructions

### Contribution guidelines ###

* Writing tests
* Code review
* Other guidelines

### Who do I talk to? ###

* Repo owner or admin
* Other community or team contact


*************************************************************************************************************************************************


Step 1 - Master Data For Application

Master Data Entity

City - name, created, modified, join column - List movie_column(Many To Many)

Movie - name,rating,screen_type,language,duration,release_date,genre,certifcate_type,LIst cast_id(join column) - (One To Many), city (Many To One) 

Cast - image,name,movie (Many to Many)


Sub Region - name, created, modified, city join column Many To one

Cinema - name, address, show_id <One To Many>, Many To One join column to region

Shows - timing,

Ticket - type, price, seat no., join_column Many To One, date , cinema, region, city


Serialization
serialision version uid
localdate & date difference
Eager & Lazy Fetch Type
Why is it required to give the type in hashset as well

1Inderlok - Pushpa,Spiderman
2Pitampura
3AshokVihar

1Pushpa - Inderlok, Pitampura
2Spiderman
3KGF




City -> Movie -> Casting -> Show -> Ticket

city_movie
1 1
1 2


10-2-2022

Movie And Cast Post Implementation With Many To Many Mapping

Unique constraint on names where it is requred then try to persist duplicate record and check the exception and handle it with the custom message
"<name> already exist in db. Please use another name to create the record." send with Bad Request

add not null constraints where it is required

Implement Centralized logging AOP Implementaiton add dependency first