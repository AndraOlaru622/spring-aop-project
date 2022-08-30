# [Java Project by Andrei Decuseara](#)

#End points

## I. Drivers

### 1. Get all drivers [GET]

http://localhost:8080/drivers/get

#### Function:

```
    public List<Driver> getDrivers() {
      List<Driver> drivers = jdbcTemplate.query(Querys.GET_DRIVERS_SQL, (resultSet, i) ->  new Driver(
                    resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getInt("age"),
                    resultSet.getInt("year_employment"),
                    resultSet.getDouble("salary"),
                    resultSet.getInt("idLocation")
            ));
        LOGGER.info("Retrieving drivers ... {}", drivers);
        jdbcTemplate.update(Querys.ADD_ACTION, "Retrieving drivers from database", LocalDate.now());
        return drivers;
    }
```

### 2. Adding a driver [POST]

http://localhost:8080/drivers/add

Example JSON:

{<br>
"first_name": "Cristi",<br>
"last_name": "Dec", <br>
"age": 22, <br>
"year_employment": 2020, <br>
"salary": 3000, <br>
"idLocation": 1 <br>
}

#### Function:
```
    public List<Driver> addDriver(Driver p) {
        jdbcTemplate.update(Querys.ADD_DRIVER, p.getFirst_name(), p.getLast_name(), p.getAge(), p.getYear_employment(), p.getSalary(), p.getIdLocation());
        LOGGER.info("Adding driver to database ... {}", p);
        jdbcTemplate.update(Querys.ADD_ACTION, "Adding driver to database", LocalDate.now());
        return getDrivers();
    }
```

### 3. Get a driver by id [GET]

http://localhost:8080/drivers/getById?id=3

#### Function:
```
    public List<Driver> getDriverById(int id) {
        return getDrivers().stream()
                .filter(driver -> driver.getId() == id)
                .collect(Collectors.toList());
    }
```

### 4. Update a driver by id [PUT]

http://localhost:8080/drivers/update?id=3

Example JSON:

{<br>
"first_name": "CristiUpdate",<br>
"last_name": "DecUpdate", <br>
"age": 29, <br>
"year_employment": 2010, <br>
"salary": 4000, <br>
"idLocation": 1 <br>
}

#### Function:

```
    public List<Driver> updateDriver(Driver p, int id) {
        jdbcTemplate.update(Querys.UPDATE_DRIVER, p.getFirst_name(), p.getLast_name(), p.getAge(), p.getYear_employment(), p.getSalary(), p.getIdLocation(), id);
        LOGGER.info("Updating driver to database ... {}", p);
        jdbcTemplate.update(Querys.ADD_ACTION, "Updating driver to database", LocalDate.now());
        return getDrivers();
    }
```

### 5. Delete a driver by id [DELETE]

http://localhost:8080/drivers/delete?id=3

#### Function:
```
    public List<Driver> deleteDriverById(int id) {
        jdbcTemplate.update(Querys.DELETE_DRIVER,id);
        return getDrivers();
    }
```

## II. Lines

### 1. Get all lines [GET]

http://localhost:8080/lines/get

#### Function:
```
    public List<Line> getLines() {
        List<Line> lines = jdbcTemplate.query(Querys.GET_LINES_SQL, (resultSet, i) ->  new Line(
                resultSet.getInt("id"),
                resultSet.getString("departure"),
                resultSet.getString("destination"),
                resultSet.getString("type"),
                resultSet.getInt("duration")


        ));
        LOGGER.info("Retrieving lines ... {}", lines);
        jdbcTemplate.update(Querys.ADD_ACTION, "Retrieving lines from database", LocalDate.now());
        return lines;
    }
```

### 2. Adding a new line [POST]

http://localhost:8080/lines/add

Example JSON:

{ <br>
"departure": "Ploiesti", <br>
"destination": "Buzau", <br>
"type": "goods", <br>
"duration": 190 <br>
}

#### Function:
```
    public List<Line> addLine(Line p) {
        jdbcTemplate.update(Querys.ADD_LINE, p.getDeparture(), p.getDestination(), p.getType(), p.getDuration());
        return getLines();
    }
```


### 3. Delete a line by id [DELETE]

http://localhost:8080/lines/delete?id=3

#### Function:
```
    public List<Line> deleteLineById(int id) {
        jdbcTemplate.update(Querys.DELETE_LINE,id);
        return getLines();
    }
```

## III. Locations

### 1. Get all locations [GET]

http://localhost:8080/locations/get

#### Function:
```
    public List<Location> getLocations() {
        List<Location> locations = jdbcTemplate.query(Querys.GET_LOCATIONS_SQL, (resultSet, i) ->  new Location(
                resultSet.getInt("id"),
                resultSet.getString("city"),
                resultSet.getString("country")

        ));
        LOGGER.info("Retrieving locations ... {}", locations);
        jdbcTemplate.update(Querys.ADD_ACTION, "Retrieving locations from database", LocalDate.now());
        return locations;
    }
```

### 2. Adding a new location [POST]

http://localhost:8080/locations/add

Example JSON:

{<br>
"city": "Bacau", <br>
"country": "Franta" <br>
} <br>

#### Function:
```
    public List<Location> addLocation(Location p) {
        jdbcTemplate.update(Querys.ADD_LOCATION, p.getCity(), p.getCountry());
        return getLocations();
    }
```


### 3. Delete a location by id [DELETE]

http://localhost:8080/locations/delete?id=3

#### Function:
```
    public List<Location> deleteLocationById(int id) {
        jdbcTemplate.update(Querys.DELETE_LOCATION,id);
        return getLocations();
    }
```

## IV. Prices

### 1. Get all prices [GET]

http://localhost:8080/prices/get

#### Function:
```
    public List<Price> getPrices() {
        List<Price> prices = jdbcTemplate.query(Querys.GET_PRICES_SQL, (resultSet, i) ->  new Price(
                resultSet.getInt("id"),
                resultSet.getInt("idLine"),
                resultSet.getDouble("price"),
                resultSet.getString("currency")

        ));
        LOGGER.info("Retrieving prices ... {}", prices);
        jdbcTemplate.update(Querys.ADD_ACTION, "Retrieving prices from database", LocalDate.now());
        return prices;
    }
```

### 2. Adding a new price [POST]

http://localhost:8080/prices/add

Example JSON:

{ <br>
"idLine": 3, <br>
"price": 30, <br>
"currency": "Euro" <br>
} <br>
#### Function:
```
    public List<Price> addPrice(Price p) {
        jdbcTemplate.update(Querys.ADD_PRICE, p.getIdLine(), p.getPrice(), p.getCurrency());
        return getPrices();
    }
```


### 3. Delete a price by id [DELETE]

http://localhost:8080/prices/delete?id=4

#### Function:
```
    public List<Price> deletePriceById(int id) {
        jdbcTemplate.update(Querys.DELETE_PRICE,id);
        return getPrices();
    }
```

## V. Vehicles

### 1. Get all vehicles [GET]

http://localhost:8080/vehicles/get

#### Function:
```
    public List<Vehicle> getVehicles() {
        List<Vehicle> vehicles = jdbcTemplate.query(Querys.GET_VEHICLES_SQL, (resultSet, i) ->  new Vehicle(
                resultSet.getInt("id"),
                resultSet.getInt("idDriver"),
                resultSet.getInt("idLine"),
                resultSet.getString("brand"),
                resultSet.getInt("year"),
                resultSet.getString("service_condition")


        ));
        LOGGER.info("Retrieving vehicles ... {}", vehicles);
        jdbcTemplate.update(Querys.ADD_ACTION, "Retrieving vehicles from database", LocalDate.now());
        return vehicles;
    }
```

### 2. Adding a new price [POST]

http://localhost:8080/vehicles/add

Example JSON:

{<br>
"idDriver": 1, <br>
"idLine": 2, <br>
"brand": "Mercedes", <br>
"year": 2018, <br>
"serviceCondition": "medium" <br>
} <br>
#### Function:
```
    public List<Vehicle> addVehicle(Vehicle p) {
        jdbcTemplate.update(Querys.ADD_VEHICLE, p.getIdDriver(), p.getIdLine(), p.getBrand(), p.getYear(), p.getServiceCondition());
        return getVehicles();
    }
```


### 3. Delete a price by id [DELETE]

http://localhost:8080/vehicles/delete?id=7

#### Function:
```
    public List<Vehicle> deleteVehicleById(int id) {
        jdbcTemplate.update(Querys.DELETE_VEHICLE,id);
        return getVehicles();
    }
```

## VI. Main commands

### 1. Get all drivers location [GET]

http://localhost:8080/getDriverLocation

#### Function:

```
    public List<DriverLocation> getDriverLocations() {
        List<DriverLocation> driver_locations = jdbcTemplate.query(Querys.DRIVERS_LOCATION, (resultSet, i) ->  new DriverLocation(
                resultSet.getInt("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("city"),
                resultSet.getString("country")

        ));
        LOGGER.info("Retrieving driver's locations ... {}", driver_locations);
        jdbcTemplate.update(Querys.ADD_ACTION, "Retrieving driver's locations from database", LocalDate.now());
        return driver_locations;
    }
```

### 2. Get all drivers vehicles [GET]

http://localhost:8080/getDriverVehicle

#### Function:

```
    public List<DriverVehicle> getDriverVehicles() {
        List<DriverVehicle> driver_vehicles = jdbcTemplate.query(Querys.DRIVERS_VEHICLE, (resultSet, i) ->  new DriverVehicle(
                resultSet.getInt("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("brand"),
                resultSet.getString("service_condition")

        ));
        LOGGER.info("Retrieving driver's vehicles ... {}", driver_vehicles);
        jdbcTemplate.update(Querys.ADD_ACTION, "Retrieving driver's vehicles from database", LocalDate.now());
        return driver_vehicles;
    }
```

### 3. Get all drivers lines [GET]

http://localhost:8080/getVehicleLine

#### Function:

```
    public List<VehicleLine> getVehicleLines() {
        List<VehicleLine> vehicle_lines = jdbcTemplate.query(Querys.VEHICLES_LINE, (resultSet, i) ->  new VehicleLine(
                resultSet.getInt("id"),
                resultSet.getInt("idDriver"),
                resultSet.getString("brand"),
                resultSet.getString("service_condition"),
                resultSet.getString("departure"),
                resultSet.getString("destination"),
                resultSet.getString("type"),
                resultSet.getInt("duration")

        ));
        LOGGER.info("Retrieving vehicle's lines ... {}", vehicle_lines);
        jdbcTemplate.update(Querys.ADD_ACTION, "Retrieving vehicle's line from database", LocalDate.now());
        return vehicle_lines;
    }
```

### 4. Get all lines price [GET]

http://localhost:8080/getLinePrice

#### Function:

```
    public List<LinePrice> getLinesPrice() {
        List<LinePrice> lines_price = jdbcTemplate.query(Querys.LINES_PRICE, (resultSet, i) ->  new LinePrice(
                resultSet.getInt("id"),
                resultSet.getString("departure"),
                resultSet.getString("destination"),
                resultSet.getInt("duration"),
                resultSet.getDouble("price"),
                resultSet.getString("currency")

        ));
        LOGGER.info("Retrieving line's price ... {}", lines_price);
        jdbcTemplate.update(Querys.ADD_ACTION, "Retrieving line's price from database", LocalDate.now());
        return lines_price;
    }
```