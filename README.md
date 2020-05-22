# springboot-swagger-generator

This is a sample spring boot project to generate the swagger documentation.

For swagger generation we are using **springfox-swagger2** dependency.
By default  it generate the swagger doc at ${applicationContextPath}/v2/api-docs. This is a json representation by default, we can customise it to generate in yaml format also.

MavenDependency:

    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger2</artifactId>
        <version>2.9.2</version>
    </dependency>
    
We can customise Swagger from Java
  
    @Bean
    public Docket swaggerConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .protocols(Sets.newHashSet("https"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.springbootswaggercrud.crud.controller"))
                .build();
    }

### Swagger UI

  **springfox** with **springfox-swagger-ui** will generate a swagger html page, It makes user interaction with the Swagger documentation much easier.
  swagger ui html can be generated at ${applicationContextPath/swagger-ui.html
  
  MavenDependency:
  
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger-ui</artifactId>
        <version>2.9.2</version>
    </dependency>