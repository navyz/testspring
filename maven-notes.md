###### dependency scope

compile
- default scope

provided
- be defined by the JDK or container

runtime
- be present in runtime and test classpath

test
- be present in test classpath

###### maven phase, goal, plugin

#### each build lifecycle is made up of phases
# list of lifecycle
clean
validate
compile
test
package
verify
install
site
deploy

# clean lifecycle comprise of 3 phase
-pre-clean
clean
post-clean

# default lyfecycle comprise of alot of phase
clean
validate
compile
test
package
verify
install
site
deploy


#### Each phase includes one or more plugin-goals in order

# Below is the built-in lifecycle binding in the format of 
phase plugin:goal

clean clean:clean
compile compiler:compile
test-compile compiler:testCompile
test surefire:test
package jar:jar or war:war
install install:install
deploy deploy:deploy
site site:site

#### Examples
# when i run the command
mvn clean verify sonar:sonar 

# below goals will be executed
maven-clean-plugin:3.1.0:clean
jacoco-maven-plugin:0.8.2:prepare-agent
maven-resources-plugin:3.1.0:resources
maven-compiler-plugin:3.8.1:compile
maven-resources-plugin:3.1.0:testResources
maven-compiler-plugin:3.8.1:testCompile
maven-surefire-plugin:2.22.2:test
jacoco-maven-plugin:0.8.2:report
maven-jar-plugin:3.2.0:jar
spring-boot-maven-plugin:2.3.0.RELEASE:repackage
sonar-maven-plugin:3.7.0.1746:sonar

# some of common used plugins
spring-boot run, start, stop, repackage, help
surefile test, help
compiler compile, testCompile