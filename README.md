# Bookcase
A book management system built with Java, Spring Boot, MongoDB and Redis.

## Usage

#### 1. Install Redis and MongoDB

#### 2. Run Redis and MongoDB
Run in command line:

a) redis-server

b) redis-cli monitor

c) mongod --dbpath ~/data/db


#### 3. Run the project

#### 4. Use Postman to test
a) Post a json with property "name"

b) Get all books at http://localhost:8080/api/bookcase/mongodb/all

c) Copy and paste the id of the book you just created

d) Replace "all" in the link above with the id, and use GET method agin

e) Check the redis-cli monitor, the book with specified id was cached

## Screenshots
![get book](https://github.com/edisoncat/bookcase/screenshots/get.png)

![caching](https://github.com/edisoncat/bookcase/screenshots/caching.png)
