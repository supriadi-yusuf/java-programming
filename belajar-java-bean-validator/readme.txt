java bean validation (spec, now version 3)
hibernate (implementation)

Validator (interface) => create once only
ValidatorFactory (interface) is to create validator object => create once only

Constraint is an annotation that is used as a marker for the target that we add
https://jakarta.ee/specifications/bean-validation/3.0/apidocs/

Constraint violation

Validator object has validate() method

interface ExecutableValidator is to validate method

