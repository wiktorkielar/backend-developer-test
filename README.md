# Backend Developer Test

## Description

Simple web application with REST endpoint that allows to find the optimal route between two countries using
Breadth-first Search algorithm.

## Requirements

1. Latest JDK
2. Git

## Configuration

1. `app-data.json-uri` can be configured to set uri for JSON, that is used as a data source

## Building and Running

1. `git clone https://github.com/wiktorkielar/backend-developer-test.git .`
2. `./mvnw clean install`
3. `java -jar target/backend-developer-test-0.0.1-SNAPSHOT.jar`

## Running Unit Tests

1. `./mvnw test`

## Using the application

1. Send HTTP GET request to `localhost:8080/routing/{sourceCountry}/{destinationCountry}`, where sourceCountry and destinationCountry are country codes available in cca3 format here: https://raw.githubusercontent.com/mledoze/countries/master/countries.json.
   For example, to find the shortest path between the Czech Republic and Russian Federation send HTTP GET request to `localhost:8080/routing/CZE/RUS`
   
Sample response from the API would be:
```
{
   "route": [
      "CZE",
      "POL",
      "RUS"
   ]
}
```

