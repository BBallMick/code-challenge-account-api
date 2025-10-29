This project tries to give a rough outline of how I would go about solving the Account API coding challenge.

Due to time constraints, the project is no where near fully complete and does not implement all design considerations which one might have for such a service.
I will do my best to try and remember and explain the the considerations or alternative solutions which have not been implemented in this project.

The project is structured based on Clean Architecture principles, although I do admit that I in certain places slack a bit on this in order to have time to focus on other things.
However, the goal is to structure to code in a way where dependencies between different layers of the application only ever "looks" inwards. And when required, interfaces are in place in inner layers and implemented in outer layers.

The project contains a single unit test class, which tries to showcase my approach to unit testing and the use unit testing frameworks and mocking.
It does not include any integraiton tests to e.g. an underlying databse or any api tests using stubs and in memory database and such, but this would be something to consider in a fully complete service.

Considerations:

Error Handling:
Some examples are present of how I would approach error handling. The exceptions are thrown and "bubbles" up through the layers and is being handled in the out most REST layer.
It can be discussed how to treat exceptions as they rise up through the layers, and whether or not each layer should map the exception received to it's own "interpretation" of the exception to hide redundant or sensitive implementation details from the end user.

Validation:
I try to come up with an example of business logic validation. It's a simple approach where the validation logic is located directly in the same place as the "business logic".
While it's fine and easy to understand and locate, I do find that it can quickly become very messy once too many validation rules are present. This can lead to methods and functions containing more validation logic than actual business logic and can muddy the waters for what the code acutally do.
It's of course possible to separate validation logic from businessl logic using Bean validation, validation services or customer validators with more or less complexity, visibility and manual invocation.

Observability:
I did not get to implement any observability features, However potential steps to take to increase observability would be to:
- Use some sort of logging framework to aggregate and structure the logs in such a way that it enables searching and filtering using log tools like Splunk or Humio etc.
- Add metrics and health checks for response times, cpu usage, memory usage, DB reads and writes and the list goes on and visualize these metrics and checks.
- Implement Tracing in the logs to be able to follow requests end to end and all the steps in between as it travels through the service internally and across services.

Auditing:
Storing all money transfers along with relevant information about who what where and why is a good start to be able to audit any transactions or a history/timeline of transactions

Security:
To increase security and restrict access to certain endpoints, data etc. one should consider using Spring Security along with something like JWT or OAuth2 in order to authenticate the user and extract the user identity in order to make decissions on if they're allowed to access or fetch whatever data they're trying to.
In my project I've simply added e.g. a UserId to the request body or path parameter of certain endpoints, which the user can freely input whatever they want. It would be more secure (but also more complex) to also extract the user identity and see if it matches the user provided in the request body/path.

Additional Considerations/Design Choices:
I took the liberty to make use of different tools and libraries to lessen boiler plate, and decrease the chance of human errors when writing the code.
I'm making use og Lombok to help with boilder plate code for objects, it also comes with the ability to make use of builders and immutability.
I'm also a big fan of the api first approach when designing and implementing rest servers/clients, so I'm using a tool for auto generating rest servers based on OAS files.
Finally, I'm making use of a mapping library, which removes a lot of boiler plate and can help to auto generate mapping code for mapping between entities -> domain objects -> DTOs.
Notice that I Have 3 "layers" of objects. I most often prefer to have a domain model separate from the entity model, to increase flexibility in modelling the objects,
while also hiding specific entity only relates stuff like database IDs, generic audit information and such, which more often than not is not relevant for the actual bussiness domain and it's logic.
