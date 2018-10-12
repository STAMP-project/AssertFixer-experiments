[![Codacy Badge](https://api.codacy.com/project/badge/Grade/4af8bb2f17124071b0361ec18c457e57)](https://www.codacy.com/app/MerkulovAA/graduation?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=MerkulovAA/graduation&amp;utm_campaign=Badge_Grade)   [![Build Status](https://travis-ci.org/MerkulovAA/graduation.svg?branch=master)](https://travis-ci.org/MerkulovAA/graduation)

## Выпускной проект Topjava

Design and implement a REST API using Hibernate/Spring/SpringMVC (or Spring-Boot) **without frontend**.

The task is:

Build a voting system for deciding where to have lunch.

 * 2 types of users: admin and regular users
 * Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
 * Menu changes each day (admins do the updates)
 * Users can vote on which restaurant they want to have lunch at
 * Only one vote counted per user
 * If user votes again the same day:
    - If it is before 11:00 we asume that he changed his mind.
    - If it is after 11:00 then it is too late, vote can't be changed

Each restaurant provides new menu each day.

As a result, provide a link to github repository.

It should contain the code and **README.md with API documentation and curl commands to get data for voting and vote.**


### curl samples (application deployed in application context `votingsystem`).
> For windows use `Git Bash`

#### FOR ADMIN

#### USER

#### get All Users
`curl -s http://localhost:8080/votingsystem/rest/admin/users --user admin@gmail.com:admin`

#### get Users 100001
`curl -s http://localhost:8080/votingsystem/rest/admin/users/100001 --user admin@gmail.com:admin`

#### getByEmail Users user@yandex.ru
`curl -s http://localhost:8080/votingsystem/rest/admin/users/by?email=user@yandex.ru --user admin@gmail.com:admin`

#### create User
`curl -s -X POST -d '{"name": "newUser","email": "newUser@gmail.com","password": "newUser","roles": ["ROLE_USER"]}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/votingsystem/rest/admin/users --user admin@gmail.com:admin`

#### update User
`curl -s -X PUT -d '{"name": "updateUser","email": "updateUser@gmail.com","password": "updateUser","roles": ["ROLE_USER"]}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/votingsystem/rest/admin/users/100001 --user admin@gmail.com:admin`

#### delete User
`curl -s -X DELETE http://localhost:8080/votingsystem/rest/admin/users/100001 --user admin@gmail.com:admin`

#### enable/disable User
`curl -s -X POST http://localhost:8080/votingsystem/rest/admin/users/100000?enabled=false --user admin@gmail.com:admin`


#### RESTAURANTS

#### get All Restaurants
`curl -s http://localhost:8080/votingsystem/rest/admin/restaurants --user admin@gmail.com:admin`

#### get Restaurant 100003
`curl -s http://localhost:8080/votingsystem/rest/admin/restaurants/100003 --user admin@gmail.com:admin`

#### getByName Restaurant Cafe Maya
`curl -s http://localhost:8080/votingsystem/rest/admin/restaurants/by?name=Cafe%20Maya --user admin@gmail.com:admin`

#### getWithMeals Restaurant 100004
`curl -s http://localhost:8080/votingsystem/rest/admin/restaurants/100004/meals --user admin@gmail.com:admin`

#### create Restaurant
`curl -s -X POST -d '{"name": "newRestaurant"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/votingsystem/rest/admin/restaurants --user admin@gmail.com:admin`

#### update Restaurant
`curl -s -X PUT -d '{"name": "updateRestaurant"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/votingsystem/rest/admin/restaurants/100003 --user admin@gmail.com:admin`

#### delete Restaurant
`curl -s -X DELETE http://localhost:8080/votingsystem/rest/admin/restaurants/100003 --user admin@gmail.com:admin`


#### MEALS

#### get All meals by restaurant 100002
`curl -s http://localhost:8080/votingsystem/rest/admin/restaurants/100002/meals/history --user admin@gmail.com:admin`

#### get Meal 100007 by restaurant 100002
`curl -s http://localhost:8080/votingsystem/rest/admin/restaurants/100002/meals/100007 --user admin@gmail.com:admin`

#### getAllByToday Meals by restaurant 100002
`curl -s http://localhost:8080/votingsystem/rest/admin/restaurants/100002/meals/today --user admin@gmail.com:admin`

#### getAllByDate Meals by restaurant 100002
`curl -s http://localhost:8080/votingsystem/rest/admin/restaurants/100002/meals/byDate?date=2018-10-05 --user admin@gmail.com:admin`

#### getAllBetween Meals by restaurant 100002
`curl -s "http://localhost:8080/votingsystem/rest/admin/restaurants/100002/meals/filter?startDate=&endDate=" --user admin@gmail.com:admin`

#### create Meal
`curl -s -X POST -d '{"name": "newMeal", "price":"1.50"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/votingsystem/rest/admin/restaurants/100002/meals --user admin@gmail.com:admin`

#### update Meal
`curl -s -X PUT -d '{"name": "updateMeal",  "price":"1.25"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/votingsystem/rest/admin/restaurants/100002/meals/100007 --user admin@gmail.com:admin`

#### delete Meal
`curl -s -X DELETE http://localhost:8080/votingsystem/rest/admin/restaurants/100002/meals/100007 --user admin@gmail.com:admin`


#### FOR PROFILE

#### USER

#### get User profile
`curl -s http://localhost:8080/votingsystem/rest/profile --user user@yandex.ru:password`

#### delete User profile
`curl -s -X DELETE http://localhost:8080/votingsystem/rest/profile --user user@yandex.ru:password`

#### register new profile
`curl -s -X POST -d '{"name": "newUser","email": "newUser@gmail.com","password": "newUser"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/votingsystem/rest/profile/register`

#### update User Profile
`curl -s -X PUT -d '{"name": "updateUser","email": "updateUser@gmail.com","password": "updateUser"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/votingsystem/rest/profile --user user@yandex.ru:password`


#### RESTAURANT

#### getAllWithMealsByToday Get All Restaurants
`curl -s http://localhost:8080/votingsystem/rest/profile/restaurants --user user@yandex.ru:password`

#### Voting for restaurant
`curl -s -X POST http://localhost:8080/votingsystem/rest/profile/restaurants?restaurantId=100003 --user user@yandex.ru:password`



#### validate with Error
`curl -s -X PUT -d '{"name": "u"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/votingsystem/rest/admin/restaurants/100003 --user admin@gmail.com:admin`

`curl -s -X POST -d '{"name": "newMeal"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/votingsystem/rest/admin/restaurants/100002/meals --user admin@gmail.com:admin`