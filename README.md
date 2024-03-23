# REST-api-gemeentes
A REST api that reads municipalities from a provided json file. And province info from a csv file

For a test the assignment was to create a REST api that
1) list of municipalities can be retrieved by a GET request from "http://localhost/v1/gemeenten"
2) Get the info from a specific municipality: by calling "http://localhost/v1/gemeenten/{id}"
3) Add the possibility to sort the municipalities: alphabetically or by inhabitants

**Example Request**

http://localhost:8080/v1/gemeenten?sort_by=inwoners&order_by=desc

gemeente has properties: id, naam, provincie, inwoners
