# INITIALIZE EMBEDDED DATABASE

######  To initialize database, we need to do 3 things

 1. Create database
 2. Create schema (table, index, ...)
 3. Initialize data


######  The first time to run (all 3 does not exist)
 1. Create database
 append ";create=true" the end of spring.datasource.url
 2. create schema
 copy schema.sql to resources folder
 note: need to set spring.jpa.hibernate.ddl-auto=none (or validate)
 3. initialize data
 copy data.sql to resources folder
 note: comment out initDatabase

###### Sub-sequence run
1. no need to re-create database
remove this create=true

2. no need to create database again
rename schema.sql -> schema.sql.x

3. initialize data: truncate and insert data again
keep data.sql as it is

###### To truncate database. This is the alternative way of the first time run
1. remove "create=true" on the spring.datasource.url
2. spring.jpa.hibernate.ddl-auto=create  (NOTES: if create=true in step 2, there is warning that the tables do not exist)
3. data.sql will still be there if we want to initialize data


###### Understand the settings
1. "create=true" at the end of spring.datasource.url
Spring attribute. to create the database when starting application.
If the database already exists, creates a connection to the existing database and an SQLWarning is issued.

2. spring.jpa.generate-ddl=false
"false" by default to not create schema.

3. spring.jpa.hibernate.ddl-auto (none, validate, create, create-drop)
You should not use both spring.jpa.hibernate.ddl-auto and schema.sql.
Make sure to disable spring.jpa.hibernate.ddl-auto if you use schema.sql.

4. ddl-auto (create, create-drop)
it's hibernate feature, not spring
this will go along with schema.sql file

5. schema.sql, data.sql, application.properties
all these 3 files should be placed in resources folder


###### Sonar scanner
- Update maven\conf\settings.xml (https://docs.sonarqube.org/latest/analysis/scan/sonarscanner-for-maven/)
- Run command 
    mvn clean verify sonar:sonar
 - Following tasks will be executeds
    
    
###### remove files from test coverage report
There are 5 ways to do this. The list below is in time/workflow backward order  
1. Sonar General Settings: Admistration => Analysis Scope => Coverage Exclusions

2. Sonar Project Settings: Project Settings => General Settings => Analysis Scope => Coverage Exclusions

3. In build command line (NOT WORKING)
-Dsonar.jacoco.excludes=**/useless/*

tried in this way also
<properties>
    <sonar.jacoco.excludes>**/useless/*,**/xxx/*</sonar.jacoco.excludes>
</properties>


4. Define sonar.coverage.exclusions in pom.xml file
<properties>
    <sonar.coverage.exclusions>**/useless/*,**/controller/**</sonar.coverage.exclusions>
</properties>

5. Define jacoco exclude pattern in pom.xml file, under jacoco plugin
NOT WORKING. 
These files will not be included in jacoco report, but in sonar, the files are still marked as not tested. 

    <configuration> 
        <excludes> 
            <exclude>**/useless/*</exclude> 
            <exclude>**/xxx/*</exclude> 
        </excludes> 
    </configuration>