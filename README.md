This repository implements the Singleton Design Pattern for managing a thread-safe, centralized database connection pool. The design ensures only one instance of the connection pool exists during the application’s lifecycle, optimizing resource usage and performance. Key Features: Singleton Pattern: Guarantees a single instance of the connection pool, avoiding multiple instances and unnecessary resource consumption.

Connection Pooling: Maintains a fixed number of database connections, reusing them efficiently, with a default pool size of 5. Connections are checked out and returned to the pool, reducing connection creation overhead.

Thread Safety: Supports multi-threaded applications by ensuring that multiple threads can safely access the connection pool without causing conflicts.

Lazy Initialization: The connection pool is initialized only when needed, reducing unnecessary resource allocation. Usage: Initialize the Pool: The connection pool is created when DatabaseConnectionPool.getInstance() is called. Get a Connection: Use getConnection() to retrieve an available connection from the pool. Execute Operations: Use the retrieved connection for database queries or updates. Release Connection: After the operation, call releaseConnection() to return the connection to the pool.

Technologies Used: Java, JDBC (MySQL)
