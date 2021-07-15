# Spring GraphQL API

A simple GraphQL API built on Spring with graphql-java-tools and JPA.

## Schema

- Query:
  - `item({id})`
  - `items`
- Mutation:
  - `createItem(content: {itemContent})`

```
type Item {
    id: ID!,
    content: String,
}

type Query {
    items: [Item]
    item(id: ID): Item
}

type Mutation {
    createItem(content: String!): Item
}
```

## Configure MySQL database

First, create your database using console command:
```
mysql> create database {databaseName};
```

Then, go to application.properties and add:

```
spring.datasource.url=jdbc:mysql://localhost:{portNumber}/{databaseName}?useSSL=false
spring.datasource.username={username}
spring.datasource.password={password}
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto=update
```

Now the data being written should stay persistent 

## License

`MIT License`