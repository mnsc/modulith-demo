# Spring Modulith demo

This is just a simple demo on how you could use spring modulith.

## The setup

We have four modules, feel free to play around with them and try out some stuff from the modulith documentation.

### inventory
The inventory module has declared "order :: events" as allowed dependencies and can therefore only access code in the events API package.

This module reacts to OrderCompleted events.

### order
The order module has not declared any allowed dependencies and can therefore access the code in all API packages(module root and named interfaces)

Publishes OrderCompleted events

### payment
The payment module has declared "order" as allowed dependencies and can therefore only access the code in the API packages in the order module(module root and named interfaces)

This module reacts to OrderCompleted events and uses the OrderSPI to do some work.

### worker
The worker module has not declared any allowed dependencies and can therefore access the code in all API packages(module root and named interfaces)

Scheduled to complete orders via OrderManagement

## Docs

https://spring.io/projects/spring-modulith
https://github.com/xmolecules/jmolecules

## Examples

https://github.com/spring-projects/spring-modulith/tree/main/spring-modulith-examples

