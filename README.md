# LandParcel CRUD Service

Welcome to the LandParcel CRUD service, I hope you enjoy your stay!

## Standing up Through maven

Make sure you have your `JAVA_HOME` pointing at your local installation
of a java 21 runtime then navigate to the project root in your favourite shell and run:

`./mvnw exec:java` or `./mvnw spring-boot:run` 

## Standing up Through Intellji

!Disclaimer! - This step is only applicable to Intellji users!

When loading in the project navigate to `Project Structure` under the `File` tab.

Under `Project Settings->Project` select your installed Java 21 distribution
Under `Platform Settings->SDKs` select your installed Java 21 distribution

Once intellij has finished loading our dependencies and linking to the build automation tool we should just be able
to select `CodeTestApplication.java` as our entrypoint

Then press play and away we go.

# Seeding data

Upon successfully standing up our application, there are two ways of getting data into the `in memory database`:

1) navigate to `http://localhost:8080/h2-console`
   1) connect to the database (you can just press connect and all being well it should work!)
   2) copy the contents of `populate_h2_database.sql` and press `run`
2) run `./CreateNewLandParcel.sh`

Be warned that should you choose option `1` makes creating new instances through the API impossible. Trying to after
running the seeding script will result in the PK constraint error:

`JdbcSQLIntegrityConstraintViolationException: Unique index or primary key violation: PRIMARY KEY ON PUBLIC.LAND_PARCEL(OBJECT_ID)`

As the `LandParcel::objectId` field is marked with the `@GeneratedValue` and no strategy specified. We instruct 
hibernate to manage the incrementation of the primary key value for new instances. It therefore implicitly rejects any 'out of band writes'. 

I'm sure this is a problem which is easily fixable, however in the interest of time I've left that out!

# Interacting with the API

Included under `test_scripts` are a handful of lightweight `.sh` scripts which wrap around `cURL` for targeting the API

I would recommend running in the following order 

1) `GetAllLandParcels.sh` -> returns 200 OK with no data
2) `CreateNewLandParcel.sh` -> returns 201 with new instance made as detailed in `create_payload`
3) `UpdateCreatedEntity.sh` -> returns 200 with updated instance details
4) `GetAllLandParcels.sh` -> Run to verify the instance has actually changed
5) `DeleteCreatedEntity` -> Returns 200 and details of the entity deleted
6) `GetAllLandParcels.sh` -> returns 200 OK with no data, verifying data has been deleted

Otherwise feel free to use whatever commandline tool or application your prefer.