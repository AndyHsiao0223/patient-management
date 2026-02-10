# Record personal improvements

## GlobalExceptionHandler.java

The original version return each exception column and message in the response body. This can expose sensitive
information about our db schema and take more time to validate every column.

To improve security and performance, we use Hibernate fail_fast strategy to return only the first error encountered, and
we customize the error response to return an error code and a custom message like many companies do.