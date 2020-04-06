/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.2.2).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package io.pismo.api.transaction.manager;

import io.pismo.api.transaction.manager.models.ApiError;
import io.pismo.api.transaction.manager.models.Transaction;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-04-06T09:34:52.257-03:00[America/Sao_Paulo]")

@Validated
@Api(value = "transactions", description = "the transactions API")
public interface TransactionsApi {

    @ApiOperation(value = "Transaction register", nickname = "createTransaction", notes = "", response = Transaction.class, tags={ "transaction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful Operation", response = Transaction.class),
        @ApiResponse(code = 400, message = "Bad Request", response = ApiError.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class) })
    @RequestMapping(value = "/transactions",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Transaction> createTransaction(@ApiParam(value = "Transaction created" ,required=true )  @Valid @RequestBody Transaction body);

}
