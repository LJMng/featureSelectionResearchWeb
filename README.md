# featureSelectionResearchWeb

This is a maven project built for **Spring Boot** web application of a **Feature Selection Research web-site**. For dependencies information, please check out the *pom.xml*. 

Entrance of the app is *src/.../web/App.java*.

The java project basic structure is built as follow:

	.
	+--src
	  +--main
	  | +--database		// database scripts
	  | +--java
	  |   +--featureSelection/research/web
	  |      +--common			// for common utilities or implementations 
	  |      +--config			// Spring Boot configurations
	  |      |  +--DataSourceConfiguration.java	// configurations of Database Source.
	  |      +--controller		// web mvc: controller
	  |      |  +--demo
	  |      |  |  +--admin
	  |      |  |  +--visitor
	  |      |  +--execution
	  |      |     +--admin
	  |      |     +--visitor
	  |      +--entity			// web mvc: model
	  |      +--mybatisMapper	// mybatis mapper: java interfaces
	  |      +--service		// web mvc: service
	  |      +--App.java		// Spring Boot app entrance.
	  +--resources
	    +--public				// html pages
	    |    +--pages
	    |    +--popups
	    +--static				// static resources for html
	    |    +--css
	    |    +--jquery
	    |    +--jquery
	    |    +--js
	    |    +--pic			// pictures...
	    |    +--scss
	    +--application.yml		// Spring Boot configurations
	    +--db.properties		// Database configurations
	    +--logback-spring.xml	// logback configurations
	     
Currently, there are **3** sub-systems: *demo*, *execution*, *admin for both*, which are used for different purposes: 
- a **demo system** for quick and simple demonstrations of Feature Selection(FS) algorithms;
- a system for actual and practical **executions** of FS;
- a system for site **administration**.

## Customize

Please modify the following files to adapt to your coding/running environment:
- *resources/db.properties*: Database
- *src/.../config/DataSourceConfiguration*: Database
- *resources/.../mybatisMapper*: Mybatis
- *src/.../mybatisMapper*: Mybatis
- *resources/application.yml*: Spring Boot configurations

### Database
Set your database settings like database url, user name, etc. in **resources/db.properties**, which is set as the config file for data source in **src/.../config/DataSourceConfiguration**(using annotation *@PropertySource*).

### Mybatis
Interfaces should be put under the path **src/.../mybatisMapper**, with mybatis *xml* configuration files put under the path **resources/.../mybatisMapper**

### E-Mail
Please replace the e-mail address set in **resources/application.yml** for e-mail sending.

## Front

### html

All html pages should be put under the path **resources/public**, in folder *pages* for common pages and  folder *popups* for pop-ups.
	 
### static resources

All static resources beside pages should be put under the path **resources/static**

#### Scripts, css, ...

Importing scripts into an *html*, say importing *tools.js* in the path *recources/static/js*, one can use the following code in the header of the html file:
	 
	 <header>
	 	...
	 	<script src="/recources/static/js/tools.js"></script>
	 	...
	 </header>

Importing scripts, say importing *Vue* from *WebJar*, one can use the following code in the *header* of the html file (with the corresponding **WebJar dependencies included in the pom.xml**):
	
	 
	 <header>
	 	...
	 	<script src="/webjars/vue/vue.min.js"></script>
	 	...
	 </header>
	 
And *.css* files works the same way:

	 <header>
	 	...
	 	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	 	...
	 </header>